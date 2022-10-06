package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_PREGNANCY_DETAILS)
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class PatientPregnancyDetails extends BaseEntity {

    @Column(name = FieldConstants.PREGNANCY_FETUSES_NUMBER)
    private int pregnancyFetusesNumber;

    @Column(name = FieldConstants.GRAVIDA)
    private int gravida;

    @Column(name = FieldConstants.PARITY)
    private int parity;

    @Column(name = FieldConstants.TEMPERATURE)
    private Float temperature;

    @Column(name = FieldConstants.LAST_MENSTRUAL_PERIOD_DATE)
    private Date lastMenstrualPeriodDate;

    @Column(name = FieldConstants.ESTIMATED_DELIVERY_DATE)
    private Date estimatedDeliveryDate;

    @Column(name = FieldConstants.IS_ON_TREATMENT)
    private Boolean isOnTreatment;

    @Column(name = FieldConstants.DIAGNOSIS_TIME)
    private Date diagnosisTime;

    @Column(name = FieldConstants.DIAGNOSIS, columnDefinition = "varchar[]")
    @Type(type = "list-array")
    private List<String> diagnosis;

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @NotNull
    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;
}
