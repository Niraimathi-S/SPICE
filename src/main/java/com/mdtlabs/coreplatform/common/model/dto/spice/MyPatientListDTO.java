package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.sql.Date;

import lombok.Data;
/**
 * Fields needs to be listed in the My patients list.
 * @author Jeyaharini T A
 *
 */
@Data
public class MyPatientListDTO {

	private Long id;
	private String nationalId;
	private Long programId;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private boolean isInitialReview;
	private String patientStatus;
	private boolean isRedRiskPatient;
	private Date enrollmentAt;
	private Long patientId;

}
