package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDetailDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String patientStatus;

    private String gender;

    private Integer age;

    private Long programId;

    private String nationalId;

    private String siteName;

    private Date enrollmentDate;

    private Long virutualId;
    

}