package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;

import javax.persistence.*;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_NUTRITION_LIFESTYLE)
public class PatientNutritionLifestyle extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = TableConstants.TABLE_PATIENT_NUTRITION_LIFESTYLE_LIFESTYLE, joinColumns = {
            @JoinColumn(name = FieldConstants.PATIENT_NUTRITION_LIFESTYLE_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.NUTRITION_LIFESTYLE_ID) })
    private Set<NutritionLifestyle> lifestyles;

    @Column(name = FieldConstants.LIFESTYLE_ASSESSMENT)
    private String lifestyleAssessment;

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;

    @Column(name = FieldConstants.REFERRED_BY)
    private Long referredBy;

    @Column(name = FieldConstants.REFERRED_DATE)
    private Date referredDate;

    @Column(name = FieldConstants.ASSESSED_BY)
    private Long assessedBy;

    @Column(name = FieldConstants.ASSESSED_DATE)
    private Date assessedDate;

    @Column(name = FieldConstants.CLINICAL_NOTE)
    private String clinicalNote;

    @Column(name = FieldConstants.OTHER_NOTE)
    private String otherNote;

    @Column(name = FieldConstants.IS_VIEWED)
    private boolean isViewed;

}