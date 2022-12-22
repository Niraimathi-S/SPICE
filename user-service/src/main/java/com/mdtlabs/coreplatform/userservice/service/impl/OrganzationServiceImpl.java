package com.mdtlabs.coreplatform.userservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataConflictException;
import com.mdtlabs.coreplatform.common.exception.DataNotAcceptableException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OrganizationDTO;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.userservice.repository.OrganizationRepository;
import com.mdtlabs.coreplatform.userservice.service.OrganizationService;
import com.mdtlabs.coreplatform.userservice.service.RoleService;
import com.mdtlabs.coreplatform.userservice.service.UserService;

/**
 * <p>
 * This service class contain all the business logic for organization module and
 * perform all the organization operation here.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 */
@Service
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	ModelMapper modelMapper = new ModelMapper();

	/**
	 * {@inheritDoc}
	 */
	public Organization addOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Organization> getAllOrganizations() {
		return organizationRepository.getAllOrganizations(Boolean.TRUE);
	}

	/**
	 * {@inheritDoc}
	 */
	public Organization updateOrganization(Organization organization) {
		Organization existingOrganization = organizationRepository.findByIdAndIsDeletedFalse(
			organization.getId());
		if (Objects.isNull(existingOrganization)) {
			throw new DataNotFoundException(23008);
		}
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(organization, existingOrganization);
		return organizationRepository.save(existingOrganization);
	}

	/**
	 * {@inheritDoc}
	 */
	@Modifying
	@Transactional
	public int deleteOrganizationById(long organizationId) {
		return organizationRepository.updateOrganizationStatusById(Boolean.FALSE, organizationId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Organization getOrganizationById(long organizationId) {
		return organizationRepository.getOrganizationById(organizationId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Organization getOrganizationByName(String name) {
		return organizationRepository.getOrganizationByName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Long> getUserTenants(long userId) {
		//return organizationRepository.getUserTenants(userId);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@org.springframework.transaction.annotation.Transactional
	public Organization createOrganization(OrganizationDTO organizationDto) {
		if (Objects.isNull(organizationDto)) {
			throw new BadRequestException(10000);
		}
		Organization existingOrganization = organizationRepository
			.findByNameIgnoreCaseAndIsDeletedFalse(organizationDto.getOrganization().getName());

		if (!Objects.isNull(existingOrganization)) {
			throw new DataConflictException(23007);
		}
		Organization organization = organizationDto.getOrganization();
		organization = organizationRepository.save(organization);
		List<User> validatedUsers = new ArrayList<>();
		List<User> users = new ArrayList<>();
		validatedUsers = userService.validateUser(organization.getParentOrganizationId(), 
			organizationDto.getUsers());

		if (!Objects.isNull(validatedUsers) && !validatedUsers.isEmpty()) {
			List<Long> userTenantsList = validatedUsers.stream().map(user -> user.getTenantId())
				.collect(Collectors.toList());
			validateParentOrganization(organization.getParentOrganizationId(), userTenantsList);
			users.addAll(validatedUsers);
		}

		for (User user : organizationDto.getUsers()) {
			if (Objects.isNull(user.getId()) || 0 == user.getId()) {
				users.add(user);
			}
		}
		for (User user : users) {
			Set<Organization> userOrganizations = new HashSet<>();
			if (Objects.isNull(user.getOrganizations()) || user.getOrganizations().isEmpty()) {
				userOrganizations = Set.of(organization);
			} else {
				userOrganizations = user.getOrganizations();
				userOrganizations.add(organization);
			}
			user.setOrganizations(userOrganizations);
			userService.addUser(user);
		}
		return organization;
	}

	/**
	 * {@inheritDoc}
	 */
	public void validateParentOrganization(Long parentOrganizationId, List<Long> tenantIds) {
		List<Organization> organizations = new ArrayList<>();
		if (!Objects.isNull(parentOrganizationId) && !tenantIds.isEmpty()) {
			organizations = organizationRepository
					.findByParentOrganizationIdAndIsActiveTrueAndTenantIdIn(
					parentOrganizationId, tenantIds);
		}
		if (organizations.size() != tenantIds.size()) {
			throw new DataNotAcceptableException(5002);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, List<Long>> getChildOrganizations(long tenantId, String formName) {
		Map<String, List<Long>> childIds = new HashMap<>();
		List<Organization> childOrgs = new ArrayList<>();
		List<Long> childOrgIds = new ArrayList<>();
		List<Long> childOrgIdsToDelete = new ArrayList<>();

		if (formName.equalsIgnoreCase("country")) {
			childOrgs = organizationRepository.findByParentOrganizationId(tenantId);
			childOrgIds = childOrgs.stream().map(account -> account.getId()).collect(Collectors.toList());
			childIds.put("accountIds", childOrgIds);
			childOrgIdsToDelete.addAll(childOrgIds);
		}
		if (formName.equalsIgnoreCase("country") || formName.equalsIgnoreCase("account")) {
			if (formName.equalsIgnoreCase("account")) {
				childOrgs = organizationRepository.findByParentOrganizationId(tenantId);
			} else {
				childOrgs = organizationRepository.findByParentOrganizationIdIn(childOrgIds);
			}
			childOrgIds = childOrgs.stream().map(operatingUnit -> operatingUnit.getId())
				.collect(Collectors.toList());
			childIds.put("operatingUnitIds", childOrgIds);
			childOrgIdsToDelete.addAll(childOrgIds);
		}
		if (formName.equalsIgnoreCase("country") || formName.equalsIgnoreCase("account")
			|| formName.equalsIgnoreCase("operating unit")) {

			if (formName.equalsIgnoreCase("operating unit")) {
				childOrgs = organizationRepository.findByParentOrganizationId(tenantId);
			} else {
				childOrgs = organizationRepository.findByParentOrganizationIdIn(childOrgIds);
			}

			childOrgIds = childOrgs.stream().map(site -> site.getId()).collect(Collectors.toList());
			childIds.put("siteIds", childOrgIds);
			childOrgIdsToDelete.addAll(childOrgIds);
		}
		return childIds;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<Organization> getOrganizationsByIds(List<Long> organizationIds) {
		return organizationRepository.findByIsDeletedFalseAndIsActiveTrueAndIdIn(organizationIds);
	}

	/**
	 * {@inheritDoc}
	 */
	public User addAdminUsers(User user) {
		Organization organization = organizationRepository.findByIdAndIsDeletedFalse(user.getTenantId());
		if (Objects.isNull(organization)) {
			throw new DataNotFoundException(5001);
		}
		user.setOrganizations(Set.of(organization));
		String roleName = user.getRoles().stream().map(Role::getName).collect(Collectors.toList()).get(0);
		Role role = null;
		if (!roleName.isEmpty()) {
			role = roleService.getRoleByName(roleName);
		}
		user.setRoles(Set.of(role));
		user = userService.addUser(user);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public User updateAdminUsers(User user) {
		Organization organization = organizationRepository.findByIdAndIsDeletedFalse(user.getTenantId());
		if (Objects.isNull(organization)) {
			throw new DataNotFoundException(5001);
		}
		user.setOrganizations(Set.of(organization));
		user = userService.updateOrganizationUser(user);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean deleteAdminUsers(CommonRequestDTO requestDto) {
		return userService.deleteOrganizationUser(requestDto);
	}

}
