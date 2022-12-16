package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Validated
@Table(name = TableConstants.TABLE_LAB_TEST)
public class LabTest extends TenantBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Labtest name should not be empty")
	@Column(name = FieldConstants.NAME)
	private String name;
	
	@Column(name = FieldConstants.DISPLAY_ORDER)
	private int displayOrder;
	
	@Column(name = FieldConstants.IS_RESULT_TEMPLATE)
	private boolean isResultTemplate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = FieldConstants.LAB_TEST_ID)
	@Valid
	private Set<LabTestResult> labTestResults;

	@NotNull(message = "CountryId should not be empty")
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

}