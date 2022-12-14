package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import javax.validation.constraints.*;
import javax.validation.groups.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.util.EnrollmentInfo;
import com.mdtlabs.coreplatform.common.util.ScreeningInfo;

@Data
public class BioDataDTO {
    @NotEmpty(message = ErrorConstants.NATIONAL_ID_NOT_NULL, groups = {ScreeningInfo.class, EnrollmentInfo.class})
    private String nationalId;
    @NotEmpty(message = ErrorConstants.FIRST_NAME_NOT_NULL, groups = {ScreeningInfo.class, EnrollmentInfo.class})
    private String firstName;

    private String middleName;
    @NotEmpty(message = ErrorConstants.LAST_NAME_NOT_NULL, groups = {ScreeningInfo.class, EnrollmentInfo.class})
    private String lastName;
    @NotEmpty(message = ErrorConstants.INITIAL_NOT_NULL, groups = {EnrollmentInfo.class})
    private String initial;
    @NotEmpty(message = ErrorConstants.PHONE_NUMBER_NOT_NULL, groups = {ScreeningInfo.class, EnrollmentInfo.class})
    private String phoneNumber;
    @NotEmpty(message = ErrorConstants.PHONE_NUMBER_CATEGORY_NOT_NULL, groups = {ScreeningInfo.class, EnrollmentInfo.class})
    private String phoneNumberCategory;

    private String landmark;

    private String occupation;

    private String levelOfEducation;

    private String idType;
    
    private String otherIdType;

    private String preferredName;

    private String insuranceId;

    private String insuranceStatus;

    private String insuranceType;

    private Long program;
    @NotNull(message = ErrorConstants.COUNTY_NOT_NULL, groups = {EnrollmentInfo.class})
    private Long county;
    @NotNull(message = ErrorConstants.COUNTRY_NOT_NULL, groups = {EnrollmentInfo.class})
    private Long country;
    @NotNull(message = ErrorConstants.SUB_COUNTY_NOT_NULL, groups = {EnrollmentInfo.class})
    private Long subCounty;
}