package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.springframework.validation.annotation.*;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

@Data
@Entity
@Validated
@Table(name = TableConstants.TABLE_LAB_TEST)
public class LabTest extends BaseEntity {

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

	@NotNull(message = "tenantId should not be empty")
	@Min(1)
	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;


}