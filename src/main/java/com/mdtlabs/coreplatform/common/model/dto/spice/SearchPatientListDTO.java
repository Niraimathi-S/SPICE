package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.sql.Date;

import lombok.Data;

/**
 * Fields needs to be listed while searching a patient.
 * 
 * @author Jeyaharini T A
 *
 */
@Data
public class SearchPatientListDTO {

	private Long id;
	private String nationalId;
	private Long programId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int age;
	private Boolean isInitialReview;
	private String patientStatus;
	private Boolean isRedRiskPatient;
	private Date enrollmentAt;
	private Boolean isRegularSmoker;
	private Boolean isConfirmDiagnosis;
	private Float bmi;
	private Float weight;
	private Float height;
	private Long screeningLogId;

}
