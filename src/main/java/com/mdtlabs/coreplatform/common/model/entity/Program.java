package com.mdtlabs.coreplatform.common.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PROGRAM)
public class Program extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = ErrorConstants.PROGRAM_NAME_NOT_EMPTY)
	@Column(name = FieldConstants.NAME)
	private String name;

    @NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @NotNull(message = ErrorConstants.TENANT_ID_NOT_NULL)
    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_SITE_PROGRAM, joinColumns = {
			@JoinColumn(name = FieldConstants.PROGRAM_ID) }, inverseJoinColumns = {
					@JoinColumn(name = FieldConstants.SITE_ID) })
	private Set<Site> sites;
}
