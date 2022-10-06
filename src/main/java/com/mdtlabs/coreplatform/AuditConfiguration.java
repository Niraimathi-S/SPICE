package com.mdtlabs.coreplatform;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.logger.Logger;
import com.mdtlabs.coreplatform.common.model.entity.Audit;

@Configuration
public class AuditConfiguration {

	@Bean
	public AuthenticationFilter authenticationFilter() {
		return new AuthenticationFilter();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factory,
			DataSource dataSource, JpaProperties jpaProperties, HibernateProperties hibernateProperties) {
		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),
				new HibernateSettings());
		properties.put(Constants.HIBERNATE_EJB_INTERCEPTOR, hibernateInterceptor());
		properties.put(Constants.HIBERNATE_SESSION_FACTORY, hibernateInterceptor());
		return factory.dataSource(dataSource).properties(properties).packages(Constants.PACKAGE_CORE_PLATFORM).build();
	}

	@Bean
	public EmptyInterceptor hibernateInterceptor() {

		return new EmptyInterceptor() {

			@Override
			public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames,
					Type[] types) {
				return false;
			}

			@Override
			public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
					throws CallbackException {
				Audit audit = new Audit();
				if (entity.getClass().getSimpleName().equals(Constants.AUDIT)) {
					return true;
				} else {
					try {
						createAudit(entity, audit, id);
					} catch (IllegalAccessException | InvocationTargetException e) {
						Logger.logError(e);
					}
				}
				return true;

			}

			/**
			 * This method is used to set the audit values
			 * 
			 * @param entity - entity to be audited
			 * @param audit  - audit entity
			 * @throws IllegalAccessException
			 * @throws InvocationTargetException
			 */
			private void createAudit(Object entity, Audit audit, Serializable id)
					throws IllegalAccessException, InvocationTargetException {
				Class userClass = entity.getClass();
				Method[] userClassMethods = userClass.getMethods();
				List<Audit> auditListToBeSaved = new ArrayList<>();
				for (int userMethod = Constants.ZERO; userMethod < userClassMethods.length; userMethod++) {
					Method userClassMethod = userClassMethods[userMethod];
					if (userClassMethod.getName().startsWith(Constants.GET)
							&& ((userClassMethod.getParameterTypes()).length == Constants.ZERO)
							&& (!(userClassMethod.getName().equals(Constants.GET_CLASS)))) {
						Object userClassValue;
						userClassValue = userClassMethod.invoke(entity, null);
						if (userClassValue != null) {
							audit = new Audit();
							audit.setAction(Constants.CREATE.toUpperCase());
							audit.setColumnName(userClassMethod.getName().substring(Constants.NUMBER_THREE));
							audit.setCreatedBy(Constants.EMPTY);
							audit.setUpdatedBy(Constants.EMPTY);
							audit.setEntity(entity.getClass().getSimpleName());
							audit.setNewValue(userClassValue.toString());
							auditListToBeSaved.add(audit);
						}
					}
				}
				authenticationFilter().commonRepository.saveAll(auditListToBeSaved);

			}

			@Override
			public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
					String[] propertyNames, Type[] types) {
				Audit audit = new Audit();
				List<Audit> auditListToBeSaved = new ArrayList<>();
				for (int iterator = Constants.ZERO; iterator < currentState.length; iterator++) {
					if (!Objects.deepEquals(currentState[iterator], previousState[iterator])
							&& Objects.nonNull(currentState[iterator])
							&& (Objects.nonNull(currentState[iterator]) && Objects.nonNull(previousState[iterator]))) {
						audit = new Audit();
						audit.setColumnName(propertyNames[iterator]);
						audit.setOldValue(previousState[iterator].toString());
						audit.setNewValue(currentState[iterator].toString());
						audit.setAction(Constants.UPDATE.toUpperCase());
						audit.setEntity(entity.getClass().getSimpleName());
						audit.setEntityId(Long.valueOf(id.toString()));
						auditListToBeSaved.add(audit);
					}
				}
				authenticationFilter().commonRepository.saveAll(auditListToBeSaved);
				return true;
			}

		};
	}

}
