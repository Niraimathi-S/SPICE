package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_FILL_PRESCRIPTION)
public class FillPrescription extends BaseEntity {

	private static final long serialVersionUID = 5904531222309344526L;

	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

	@Column(name = FieldConstants.PATIENT_VISIT_ID)
	private Long patientVisitId;

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
	private Long patientTrackId;

	@Column(name = FieldConstants.PRESCRIPTION_ID)
	private Long prescriptionId;

	@Column(name = FieldConstants.PRESCRIBED_DAYS)
	private Integer prescribedDays;

	@Column(name = FieldConstants.REMAINING_PRESCRIPTION_DAYS)
	private Integer remainingPrescriptionDays;

	@Column(name = FieldConstants.PRESCRIPTION_FILLED_DAYS)
	private Integer prescriptionFilledDays;

	@Column(name = FieldConstants.IS_ACTIVE)
	private Boolean isActive = true;

	@Column(name = FieldConstants.IS_DELETED)
	private Boolean isDeleted = false;

	@Transient
	private transient String instructionNote;

	@Transient
	private transient Boolean isInstructionUpdated;

}
