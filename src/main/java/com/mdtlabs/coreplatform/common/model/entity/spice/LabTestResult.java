package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * 
 * This LabTest Class is used to get LabTest Entity.
 * 
 * @author ArunKarthik
 *
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_LAB_TEST_RESULT)
@Validated
public class LabTestResult extends BaseEntity {
	private static final long serialVersionUID = -6234779218896037042L;

	@NotBlank(message = "LabTest Result name should not be empty")
	@Column(name = FieldConstants.NAME)
	private String name; 

	// @NotNull
	@Column(name = FieldConstants.TENANT_ID)
	private long tenantId;

	@Column(name = FieldConstants.LAB_TEST_ID)
	private Long labTestId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = FieldConstants.LAB_TEST_RESULT_ID)
	private List<LabTestResultRange> labTestResultRanges;

	@Column(name = FieldConstants.DISPLAY_ORDER)
	private int displayOrder;
}
