package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT)
public class Patient extends TenantBaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.NATIONAL_ID)
    private String nationalId;

    @Column(name = FieldConstants.FIRST_NAME)
    private String firstName;

    @Column(name = FieldConstants.MIDDLE_NAME)
    private String middleName;

    @Column(name = FieldConstants.LAST_NAME)
    private String lastName;

    @Column(name = FieldConstants.GENDER)
    private String gender;

    @Column(name = FieldConstants.DATE_OF_BIRTH)
    private Date dateOfBirth;

    @Column(name = FieldConstants.AGE)
    private Integer age;

    @Column(name = FieldConstants.IS_PREGNANT)
    private Boolean isPregnant;

    @Column(name = FieldConstants.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = FieldConstants.PHONE_NUMBER_CATEGORY)
    private String phoneNumberCategory;

    @NotNull
    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @NotNull
    @Column(name = FieldConstants.COUNTY_ID)
    private Long countyId;

    @NotNull
    @Column(name = FieldConstants.SUB_COUNTY_ID)
    private Long subCountyId;

    @NotNull
    @Column(name = FieldConstants.SITE_ID)
    private Long siteId;

    @Column(name = FieldConstants.LANDMARK)
    private String landmark;

    @Column(name = FieldConstants.OCCUPATION)
    private String occupation;

    @Column(name = FieldConstants.LEVEL_OF_EDUCATION)
    private String levelOfEducation;

    @Column(name = FieldConstants.INSURANCE_STATUS)
    private String insuranceStatus;

    @Column(name = FieldConstants.INSURANCE_TYPE)
    private String insuranceType;

    @Column(name = FieldConstants.INSURANCE_ID)
    private String insuranceId;

    @Column(name = FieldConstants.OTHER_INSURANCE)
    private String otherInsurance;

    @Column(name = FieldConstants.IS_SUPPORT_GROUP)
    private boolean isSupportGroup;

    @Column(name = FieldConstants.SUPPORT_GROUP)
    private String supportGroup;

    @Column(name = FieldConstants.IS_REGULAR_SMOKER)
    private boolean isRegularSmoker;

    @Column(name = FieldConstants.PROGRAM_ID)
    private Long programId;

    @Column(name = FieldConstants.INITIAL)
    private String initial;

    @Column(name = FieldConstants.OTHER_ID_TYPE)
    private String otherIdType;

    @Column(name = FieldConstants.LANGUAGES)
    private String languages;

    @Column(name = FieldConstants.ETHNICITY)
    private String ethnicity;

    @Column(name = FieldConstants.ID_TYPE)
    private String idType;

    @Column(name = FieldConstants.OTHER_LANGUAGES)
    private String otherLanguages;

    @Column(name = FieldConstants.ER_VISIT_REASON)
    private String erVisitReason;

    @Column(name = FieldConstants.LOTE)
    private boolean lote;

    @Column(name = FieldConstants.HOME_MEDICAL_DEVICES)
    private String homeMedicalDevices;

    @Column(name = FieldConstants.ER_VISIT_FREQUENCY)
    private int erVisitFrequency;

    @Column(name = FieldConstants.EMR_NUMBER)
    private long emrNumber;

    @Column(name = FieldConstants.IS_ER_VISIT_HISTORY)
    private boolean isErVisitHistory;

    @Column(name = FieldConstants.ZIP_CODE)
    private long zipCode;

}