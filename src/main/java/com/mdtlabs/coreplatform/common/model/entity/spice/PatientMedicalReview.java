package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

/**
 * Entity class for medical review table
 * 
 * @author Karthick Murugesan 
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_MEDICAL_REVIEW)
public class PatientMedicalReview extends TenantBaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_PATIENT_MEDICAL_REVIEW_PHYSICAL_EXAMINATION, joinColumns = {
			@JoinColumn(name = FieldConstants.PATIENT_MEDICAL_REVIEW_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.PHYSICAL_EXAM_ID) })
    private Set<PhysicalExamination> physicalExams;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_PATIENT_MEDICAL_REVIEW_COMPLAINTS, joinColumns = {
			@JoinColumn(name = FieldConstants.PATIENT_MEDICAL_REVIEW_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.COMPLIANT_ID) })
    private Set<Complaints> complaints;

    @Column(name = FieldConstants.PHYSICAL_EXAM_COMMENTS)
    private String physicalExamComments;

    @Column(name = FieldConstants.COMPLIANT_COMMENTS)
    private String compliantComments;

    @Column(name = FieldConstants.CLINICAL_NOTE)
    private String clinicalNote;

}
