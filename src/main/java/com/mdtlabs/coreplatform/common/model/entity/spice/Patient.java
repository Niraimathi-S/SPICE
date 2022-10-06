package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT)
public class Patient extends BaseEntity {

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

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.LANDMARK)
    private String landmark;

    @Column(name = FieldConstants.OCCUPATION)
    private String occupation;

    @Column(name = FieldConstants.LEVEL_OF_EDUCATION)
    private String levelOfEducation;

    @Column(name = FieldConstants.INSURANCE_STATUS)
    private Boolean insuranceStatus;

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

/*national_id VARCHAR,
  first_name VARCHAR,
  middle_name VARCHAR,
  last_Name VARCHAR,
  gender VARCHAR,
  date_of_birth DATE,
  age INT,
  is_pregnant BOOLEAN,
  phone_number VARCHAR,
  phone_number_category VARCHAR,
  landmark VARCHAR,
  occupation VARCHAR,
  level_of_education VARCHAR,
  insurance_status BOOLEAN,
  insurance_type VARCHAR,
  other_insurance VARCHAR,
  insurance_id VARCHAR,
  is_support_group BOOLEAN,
  support_group VARCHAR,
  is_regular_smoker BOOLEAN,
  initial VARCHAR,
  other_id_type VARCHAR,
  ethnicity VARCHAR,
  languages VARCHAR,
  id_type VARCHAR,
  other_languages VARCHAR,
  er_visit_reason VARCHAR,
  lote BOOLEAN,
  home_medical_devices VARCHAR,
  er_visit_frequency int,
  emr_number BIGINT,
  er_visit_history BOOLEAN,
  zip_code BIGINT,
  site_id BIGINT, FOREIGN KEY (site_id) REFERENCES site(id),
  program_id BIGINT,
  country_id BIGINT, FOREIGN KEY (country_id) REFERENCES country(id),
  county_id BIGINT, FOREIGN KEY (county_id) REFERENCES county(id),
  sub_county_id BIGINT, FOREIGN KEY (sub_county_id) REFERENCES sub_county(id),
  tenant_id BIGINT, FOREIGN KEY (tenant_id) REFERENCES organization(id), */