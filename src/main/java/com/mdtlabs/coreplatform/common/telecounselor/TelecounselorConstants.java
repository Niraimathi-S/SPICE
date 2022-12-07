package com.mdtlabs.coreplatform.common.telecounselor;

import java.util.List;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;

/**
 * <p>
 * To define the common static parameter used in the telecounselor application.
 * </p>
 *
 * @author Prabu created on Nov 03, 2022
 *
 */
public class TelecounselorConstants {

	private TelecounselorConstants() {
	};

	public static final String PACKAGE_TELECOUNSELOR = "com.project";
	public static final int INACTIVE_SESSION_EXPIRE_HOURS = 5;
	public static final String OPEN_BRACE = "{";
	public static final String CLOSE_BRACE = "}";
	public static final String STRING_NULL = null;
	public static final String UNDERSCORE = "_";
	public static final String AND = "and";
	public static final String SERIAL = "serial";
	public static final String ERROR_MESSAGE_PROPERTY = "classpath:error_messages.properties";
	public static final String RAWTYPES = "rawtypes";
	public static final String UNCHECKED = "unchecked";
	public static final String UNUSED = "unused";
	public static final String TEMPLATE_MESSAGE_PROPERTY = "classpath:template_message.properties";
	public static final String TEN_DIGITS_DECIMAL_FORMAT = "#.##########";
	public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";
	public static final String WEEK = "WEEK";
	public static final String DATE_COLUMN = "date";
	public static final String DAY = "DAY";
	public static final String MONTH = "MONTH";
	public static final String YEARS = "YEARS";
	public static final String TRUE = "true";
	public static final String END = "End";
	public static final String BEGIN = "Begin";
	public static final String MMM_YY_FORMAT = "MMM-yy";
	public static final String DD_MM_YYYY = "dd-mm-yyyy";
	public static final String ACTIVE = "active";
	public static final String USER_ROLE = "userRole";
	public static final String ACCOUNT_EXPIRED = "account_expired";
	public static final String ACCOUNT_LOCKED = "account_locked";
	public static final String CREDENTIALS_EXPIRED = "credentials_expired";
	public static final String STATE_ID = "state_id";
	public static final String RESET_CLICK_TIME = "reset_click_time";
	public static final String MAIL_SUBJECT = "Telecounselor Password Reset";
	public static final String TELECOUNSELOR_NAME = "telecounselor_name";
	public static final String TELECOUNSELOR_ID = "telecounselor_id";
	public static final String PATIENT_CHASELIST_ID = "patient_chaselist_id";
	public static final String PATIENT_CALL_REGISTER_ID = "patient_call_register_id";
	public static final String CALL_REASON = "call_reason";
	public static final String ASSIGNED_BY = "assigned_by";
	public static final String DATE_TIME = "date_time";
	public static final String DAY_IN_SMALL = "day";
	public static final String CALL_DURATION = "call_duration";
	public static final String CALL_STATUS = "call_status";
	public static final String RESPOND_BY = "respond_by";
	public static final String IS_ACCEPTED = "is_accepted";
	public static final String PLANNED_CLINIC = "planned_clinic";
	public static final String IS_VISIT_CLINIC = "is_visit_clinic";
	public static final String NO_VISIT_REASON = "no_visit_reason";
	public static final String OTHER_CLINIC = "other_clinic";
	public static final String PLANNED_DATE = "planned_date";
	public static final String FOLLOWUP_INTEREST = "followup_interest";
	public static final String AVAILABLE_DATE = "available_date";
	public static final String CALL_SUMMARY = "call_summary";
	public static final String INTEREST_LEVEL = "interest_level";
	public static final String WHAT_HAPPENED = "what_happened";
	public static final String IS_TAKEN_MEDICATION = "is_taken_medication";
	public static final String EATEN_SUMMARY = "eaten_summary";
	public static final String IS_EATEN_MONITORING = "is_eaten_monitoring";
	public static final String IS_OTHER_HEALTH_ISSUES = "is_other_health_issues";
	public static final String OTHER_HEALTH_ISSUES = "other_health_issues";
	public static final String OTHER_ENROLLED_PLAN = "other_enrolled_plan";
	public static final String IS_FEELING_GOOD = "is_feeling_good";
	public static final String PATIENT_ID = "patient_id";
	public static final String PATIENT_TRACKER_ID = "patient_tracker_id";
	public static final String NATIONAL_ID = "national_id";
	public static final String FULLNAME = "fullname";
	public static final String DOB = "dob";
	public static final String AGE = "age";
	public static final String REGION_ID = "region_id";
	public static final String OPERATING_UNIT = "operating_unit";
	public static final String SITE = "site";
	public static final String PROGRAM = "program";
	public static final String PROGRAM_ID = "program_id";
	public static final String SOURCE_PROGRAM_ID = "source_program_id";
	public static final String CURRENT_CALL_STATUS = "current_call_status";
	public static final String LAST_CALL_STATUS = "last_call_status";
	public static final String REMAINING_ATTEMPTS = "remaining_attempts";
	public static final String REPEATED_ATTEMPTS = "repeated_attempts";
	public static final String ASSIGNED_DATE = "assigned_date";
	public static final String SCREENED_DATE = "screened_date";
	public static final String ENROLLED_DATE = "enrolled_date";
	public static final String PHONE_NUMBER_CATEGORY = "phone_number_category";
	public static final String DAYS_SINCE_SCREENING = "days_since_screening";
	public static final String DAYS_SINCE_LAST_ASSESSMENT = "days_since_last_assessment";
	public static final String DAYS_SINCE_LAST_MEDICAL_REVIEW = "days_since_last_medical_review";
	public static final String CVD_RISK_SCORE = "CVD_risk_score";
	public static final String DAYS_SINCE_MISSED_MEDICAL_REVIEW = "days_since_missed_medical_review";
	public static final String DAYS_SINCE_MISSED_ASSESSMENT = "days_since_missed_assessment";
	public static final String PATIENT_CATEGORY = "patient_category";
	public static final String CVD_RISK = "CVD_risk";
	public static final String RED_ALERT_REASON = "red_alert_reason";
	public static final String NUMBER_OF_RED_ALERTS = "number_of_red_alerts";
	public static final String REFERRED_REASON = "referred_reason";
	public static final String SCREENING_REFERAL_STATUS = "screening_referral_status";
	public static final String TELE_ADMIN = "TELE_ADMIN";
	public static final String TELE_USER = "TELE_USER";
	public static final String CATEGORY = "category";
	public static final String NEXT_MEDICAL_REVIEW_DATE = "next_medical_review_date";
	public static final String NEXT_ASSESSMENT_DATE = "next_assessment_date";
	public static final String LAST_MEDICAL_REVIEW_DATE = "last_medical_review_date";
	public static final String LAST_ASSESSMENT_DATE = "last_assessment_date";
	public static final String SOURCE_CREATED_AT = "source_created_at";
	public static final String SOURCE_CREATED_BY = "source_created_by";
	public static final String SOURCE_UPDATED_AT = "source_updated_at";
	public static final String SOURCE_UPDATED_BY = "source_updated_by";
	public static final String ABBREVIATION_EXPANSION = "abbreviation_expansion";
	public static final String GMT_OFFSET = "gmt_offset";
	public static final String FILTER_VALUES = "filter_values";
	public static final String TABLE_PATIENT_CHASELIST = "patient_chaselist";
	public static final String TABLE_PATIENT_CALL_REGISTER = "patient_call_register";
	public static final String TABLE_PATIENT_CALL_SCRIPT = "patient_call_script";
	public static final String TABLE_PATIENT_ASSIGNED_LIST = "patient_assigned_list";
	public static final String COLUMN_DEFINITION_LONGBLOB = "LONGBLOB";
	public static final String COLUMN_TRANSFORMER_READ_AES_PASSWORD = "AES_DECRYPT(" + FieldConstants.PASSWORD + ", '"
			+ Constants.AES_KEY + "')";
	public static final String COLUMN_TRANSFORMER_WRITE_AES = "AES_ENCRYPT(?, '" + Constants.AES_KEY + "')";
	public static final String LOGIN_USER_AUTH = "login auth key for secure to get user details";
	public static final String ROLE_NAME = "roleName";
	public static final String LIMIT = "limit";
	public static final String OLD_PASSWORD = "oldPassword";
	public static final String NEW_PASSWORD = "newPassword";
	public static final String ALL = "all";
	public static final String RED_ALERT = "red-alert";
	public static final String SCREENING = "screening";
	public static final String ASSESSMENT_FOLLOW_UP = "assessment-followup";
	public static final String MEDICAL_REVIEW_FOLLOW_UP = "medical-review-followup";
	public static final List<PatientCategory> PATIENT_CATEGORY_ALL = List.of(PatientCategory.REDRISK,
			PatientCategory.SCREENING, PatientCategory.ASSESSMENT_FOLLOW_UP, PatientCategory.MEDICAL_REVIEW_FOLLOW_UP);
	public static final String RED_RISK = "REDRISK";
	public static final String REDRISK_DATE = "redrisk_date";
	public static final String IS_HTN = "is_HTN";
	public static final String IS_DM = "is_DM";
	public static final String HTN = "HTN";
	public static final String DM = "DM";
	public static final long THIRTY = 30;
	public static final String FALSE = "false";

}
