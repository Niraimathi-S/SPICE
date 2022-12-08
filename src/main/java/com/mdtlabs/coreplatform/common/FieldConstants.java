package com.mdtlabs.coreplatform.common;

import java.util.Map;

public final class FieldConstants {

    private FieldConstants() {
    }
    
	public static final String ENTITY_ID = "entity_id";
	public static final String SUBCOUNTY_ID = "sub_county_id";
	public static final String SUBCOUNTY = "sub_county";
	public static final String CULTURE = "culture";
	public static final String COUNTRY = "country";
	public static final String ADDRESS_ONE = "address_1";
	public static final String UTC = "UTC";
	public static final String METHOD = "method";
	public static final String API = "api";


    public static final String ID = "id";
    public static final String CREATED_BY = "created_by";
    public static final String MODIFIED_BY = "modified_by";
    public static final String CREATED_AT = "created_at";
    public static final String MODIFIED_AT = "modified_at";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATED_AT = "updated_at";
    public static final String TENANT_ID = "tenant_id";
    public static final String NAME = "name";
    public static final String ABBREVIATION = "abbreviation";
    public static final String OFFSET = "\"offset\"";
    public static final String TIMEZONE_ID = "timezone_id";
    // public static final String MEDICATION_NAME = "medication_name";
    public static final String DESCRIPTION = "description";
    public static final String OTHER_SYMPTOM = "other_symptom";
    public static final String SYMPTOM_ID = "symptom_id";
    public static final String IS_ACTIVE = "is_active";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_ROLE = "userRole";
    public static final String USER_ID = "user_id";
    public static final String ROLE_ID = "role_id";
    public static final String ORGANIZATION_ID = "organization_id";
    public static final String ROLES = "roles";
    public static final String LEVEL = "level";
    public static final String ACCOUNT_EXPIRED = "account_expired";
    public static final String ACCOUNT_LOCKED = "account_locked";
    public static final String CREDENTIALS_EXPIRED = "credentials_expired";
    public static final String TYPE = "type";
    public static final String STATUS = "status";
    public static final String ADDRESS = "address";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String STATE_ID = "state_id";
    public static final String VM_CONTENT = "vm_content";
    public static final String REGION = "region";
    public static final String BODY = "body";
    public static final String TITLE = "title";
    public static final String APP_URL = "app_url";
    public static final String EMAIL_TEMPLATE_ID = "email_template_id";
    public static final String TO_EMAIL = "to_email";
    public static final String CC_EMAILS = "cc_email";
    public static final String SUBJECT = "subject";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String ALTERNATIVE_EMAIL_ID = "alternative_email_id";
    public static final String EMAIL_ID = "email_id";
    public static final String EMAIL = "email";
    public static final String CONTACT_NUMBER = "contact_number";
    public static final String CONTACT_PERSON = "contact_person";
    public static final String ZIP_CODE = "zip_code";
    public static final String DISTRICT = "district";
    public static final String CONTACT_ADDRESS = "contact_address";
    public static final String COUNTRY_ID = "country_id";
    public static final String DISTRICT_ID = "district_id";
    public static final String PHONENUMBER = "phonenumber";
    public static final String MIDDLE_NAME = "middle_name";
    public static final String AUTH_TOKEN = "auth_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String FORGET_PASSWORD_TOKEN = "forget_password_token";
    public static final String FORGET_PASSWORD_TIME = "forget_password_time";
    public static final String FORGET_PASSWORD_COUNT = "forget_password_count";
    public static final String IS_BLOCKED = "is_blocked";
    public static final String BLOCKED_DATE = "blocked_date";
    public static final String INVALID_LOGIN_ATTEMPTS = "invalid_login_attempts";
    public static final String INVALID_LOGIN_TIME = "invalid_login_time";
    public static final String PASSWORD_RESET_ATTEMPTS = "password_reset_attempts";
    public static final String IS_PASSWORD_RESET_ENABLED = "is_password_reset_enabled";
    public static final String INVALID_RESET_TIME = "invalid_reset_time";
    public static final String IS_LICENSE_ACCEPTANCE = "is_license_acceptance";
    public static final String LAST_LOGGED_IN = "last_logged_in";
    public static final String LAST_LOGGED_OUT = "last_logged_out";
    public static final String TELECOUNSELOR = "Telec0unseL0r";
    public static final String RESET_CLICK_TIME = "reset_click_time";
    public static final String ENTITY = "entity";
    public static final String ACTION = "action";
    public static final String DATA_ID = "data_id";
    public static final String COLUMN_NAME = "column_name";
    public static final String OLD_VALUE = "old_value";
    public static final String NEW_VALUE = "new_value";
    public static final String ROLE_ENTITY = "Role";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String NATIONAL_ID = "national_id";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String PHONE_NUMBER_CATEGORY = "phone_number_category";
    public static final String LANDMARK = "landmark";
    public static final String OCCUPATION = "occupation";
    public static final String IS_SUPPORT_GROUP = "is_support_group";
    public static final String SUPPORT_GROUP = "support_group";
    public static final String INITIAL = "initial";
    public static final String LEVEL_OF_EDUCATION = "level_of_education";
    public static final String DATE_OF_BIRTH = "date_of_birth";
    public static final String AGE = "age";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";
    public static final String BMI = "bmi";
    public static final String IS_REGULAR_SMOKER = "is_regular_smoker";
    public static final String COUNTY_ID = "county_id";
    public static final String SUB_COUNTY_ID = "sub_county_id";
    public static final String CATEGORY = "category";
    public static final String AVG_SYSTOLIC = "avg_systolic";
    public static final String AVG_DIASTOLIC = "avg_diastolic";
    public static final String AVG_PULSE = "avg_pulse";
    public static final String GLUCOSE_TYPE = "glucose_type";
    public static final String GLUCOSE_UNIT = "glucose_unit";
    public static final String HBA1C_UNIT = "hba1c_unit";
    public static final String GLUCOSE_VALUE = "glucose_value";
    public static final String LAST_MEAL_TIME = "last_meal_time";
    public static final String IS_UPDATED_FROM_ENROLLMENT = "is_updated_from_enrollment";
    public static final String GLUCOSE_DATE_TIME = "glucose_date_time";
    public static final String IS_BEFORE_DIABETIC_DIAGNOSIS = "is_before_diabetic_diagnosis";
    public static final String PHQ4_SCORE = "phq4_score";
    public static final String PHQ4_RISK_LEVEL = "phq4_risk_level";
    public static final String CVD_RISK_LEVEL = "cvd_risk_level";
    public static final String CVD_RISK_SCORE = "cvd_risk_score";
    public static final String REFER_ASSESSMENT = "refer_assessment";
    public static final String IS_LATEST = "is_latest";
    public static final String IS_LATEST_REQUIRED = "isLatestRequired";
    public static final String IS_BEFORE_HTN_DIAGNOSIS = "is_before_htn_diagnosis";
    public static final String PROGRAM_ID = "program_id";
    public static final String SCREENING_ID = "screening_id";
    public static final String PATIENT_ID = "patient_id";
    public static final String SITE_ID = "site_id";
    public static final String NEXT_MEDICAL_REVIEW_DATE = "next_medical_review_date";
    public static final String PATIENT_STATUS = "patient_status";
    public static final String IS_OBSERVATION = "is_observation";
    public static final String IS_SCREENING = "is_screening";
    public static final String ENROLLMENT_AT = "enrollment_at";
    public static final String LAST_REVIEW_DATE = "last_review_date";
    public static final String IS_CONFIRM_DIAGNOSIS = "is_confirm_diagnosis";
    public static final String PROVISIONAL_DIAGNOSIS = "provisional_diagnosis";
    public static final String CONFIRM_DIAGNOSIS = "confirm_diagnosis";
    public static final String LAST_ASSESSMENT_DATE = "last_assessment_date";
    public static final String IS_INITIAL_REVIEW = "is_initial_review";
    public static final String DIAGNOSIS_COMMENTS = "diagnosis_comments";
    public static final String INSURANCE_STATUS = "insurance_status";
    public static final String INSURANCE_TYPE = "insurance_type";
    public static final String OTHER_INSURANCE = "other_insurance";
    public static final String INSURANCE_ID = "insurance_id";
    public static final String PHQ9_SCORE = "phq9_score";
    public static final String SYMPTOM = "symptom";
    public static final String PHQ9_RISK_LEVEL = "phq9_risk_level";
    public static final String GAD7_SCORE = "gad7_score";
    public static final String GAD7_RISK_LEVEL = "gad7_risk_level";
    public static final String RISK_LEVEL = "risk_level";
    public static final String IS_RED_RISK_PATIENT = "is_red_risk_patient";
    public static final String PHQ4_FIRST_SCORE = "phq4_first_score";
    public static final String PHQ4_SECOND_SCORE = "phq4_second_score";
    public static final String SCREENING_REFERRAL = "screening_referral";
    public static final String ESTIMATED_DELIVERY_DATE = "estimated_delivery_date";
    public static final String LAST_MENSTRUAL_PERIOD_DATE = "last_menstrual_period_date";
    public static final String IS_PREGNANT = "is_pregnant";
    public static final String PATIENT_TRACK_ID = "patient_track_id";
    public static final String HB1AC = "hba1c";
    public static final String TEMPERATURE = "temperature";
    public static final String BP_LOG_ID = "bp_log_id";
    public static final String GLUCOSE_LOG_ID = "glucose_log_id";
    public static final String ASSESSMENT_LOG_ID = "assessment_log_id";
    public static final String CORE_TYPE = "core_type";
    public static final String IS_DELETED = "is_deleted";
    public static final String DISPLAY_ORDER = "display_order";
    public static final String CLASSIFICATION_ID = "classification_id";
    public static final String BRAND_ID = "brand_id";
    public static final String DOSAGE_FORM_ID = "dosage_form_id";
    public static final String BRAND_NAME = "brand_name";
    public static final String DOSAGE_FORM_NAME = "dosage_form_name";
    public static final String DOSAGE_UNIT_NAME = "dosage_unit_name";
    public static final String CLASSIFICATION_NAME = "classification_name";
    public static final String REF_MEDICATION_ID = "ref_medication_id";
    // labresult fields
    public static final String LAB_TEST_ID = "lab_test_id";
    public static final String GENDER = "gender";
    public static final String DIABETIC_TYPE = "diabetic_type";
    public static final String LABTEST_RESULT_RANGE = "labtest_result_range";
    public static final String IS_RESULT_TEMPLATE = "is_result_template";
    public static final String SYSTOLIC = "systolic";
    public static final String DIASTOLIC = "diastolic";
    public static final String PULSE = "pulse";
    public static final String BPLOG_DETAILS = "bplog_details";

    // country fields
    public static final String COUNTRY_CODE = "country_code";
    public static final String CODE = "code";
    public static final String UNIT_MEASUREMENT = "unit_measurement";
	// region customization fields
	public static final String FORM_INPUT = "form_input";
    public static final String COUNTY = "county_id";
    // Program fields
    // public static final String OPERATING_UNIT = "operating_unit_id";
    // public static final String ACCOUNT = "account_id";
    // public static final String SITE = "site_id";
    // public static final String QUESTION_ID = "question_id";
    // public static final String ANSWER_ID = "answer_id";
    // public static final String SCORE = "score";
    // public static final String MENTAL_HEALTH_DETAILS_ID = "mental_health_details_id";
    // public static final String PATIENT_VISIT_ID = "patient_visit_id";
    public static final String IS_PROVISIONAL = "is_provisional";
    public static final String ANTENATAL_CHECK_FREQUENCY = "antenatal_check_frequency";
    public static final String DIABETIC_FOOT_CHECK_FREQUENCY = "diabetic_foot_check_frequency";
    public static final String HBA1C_CHECK_FREQUENCY = "hba1c_check_frequency";
    public static final String MENTAL_HEALTH_CHECK_FREQUENCY = "mental_health_check_frequency";
    public static final String BG_CHECK_FREQUENCY = "bg_check_frequency";
    public static final String BP_CHECK_FREQUENCY = "bp_check_frequency";
    public static final String MEDICAL_REVIEW_FREQUENCY = "medical_review_frequency";
    // public static final String = "";
    public static final String FREQUENCY_NAME = "frequency_name";
    public static final String FREQUENCY_TYPE = "frequency_type";
    public static final String DURATION = "duration";
    public static final String PERIOD = "period";
    // public static final String COMORBIDITY_ID = "comorbidity_id";
    // public static final String OTHER_COMORBIDITY = "other_comorbidity";
    // public static final String IS_DIABETES_DIAGNOSIS = "is_diabetes_diagnosis";
    // public static final String DIABETES_DIAG_CONTROLLED_TYPE = "diabetes_diag_controlled_type";
    // public static final String DIABETES_PATIENT_TYPE = "diabetes_patient_type";
    // public static final String HTN_PATIENT_TYPE = "htn_patient_type";
    // public static final String DIABETES_DIAGNOSIS = "diabetes_diagnosis";
    // public static final String IS_HTN_DIAGNOSIS = "is_htn_diagnosis";
    // public static final String DIABETES_YEAR_OF_DIAGNOSIS = "diabetes_year_of_diagnosis";
    // public static final String HTN_YEAR_OF_DIAGNOSIS = "htn_year_of_diagnosis";
    public static final String NEXT_BP_ASSESSMENT_DATE = "next_bp_assesment_date";
    public static final String NEXT_BG_ASSESSMENT_DATE = "next_bg_assesment_date";
	// account fields
	public static final String MAX_NO_OF_USERS = "max_no_of_users";
	public static final String IS_USERS_RESTRICTED = "is_users_restricted";
	public static final String CLINICAL_WORFKLOWS = "clinical_workflows";
	// account workflow fields
	public static final String VIEW_SCREENS = "view_screens";
	public static final String MODULE_TYPE = "module_type";
	// account customization fields
	public static final String WORKFLOW = "workflow";
	public static final String CLINICAL = "clinical";
	public static final String CUSTOMIZED = "customized";
	public static final Map<String, String> CLINICAL_WORKFLOW_TYPE = Map.of(CLINICAL, "clinical", CUSTOMIZED,
			"customized");
	// Site fields
	public static final String ADDRESS_TYPE = "address_type";
	public static final String ADDRESS_USE = "address_use";
	public static final String ADDRESS_1 = "address_1";
	public static final String ADDRESS_2 = "address_2";
	public static final String CITY = "city";
	public static final String OPERATING_UNIT_ID = "operating_unit_id";
	public static final String CULTURE_ID = "culture_id";
	public static final String DOCTOR_NAME = "doctor_name";
	public static final String WORKING_DAYS = "working_days";
	public static final String WORKING_HOURS = "working_hours";
	public static final String POSTAL_CODE = "postal_code";
	public static final String SITE_TYPE = "site_type";
	public static final String SITE_LEVEL = "site_level";
	// Lab Test Result Range fields
	public static final String MINIMUM_VALUE = "minimum_value";
	public static final String MAXIMUM_VALUE = "maximum_value";
	public static final String UNIT = "unit";
	public static final String DISPLAY_NAME = "display_name";
	public static final String UNIT_ID = "unit_id";
	// public static final String LAB_TEST_RESULT_ID = "lab_test_result_id";

	// Program fields
	public static final String OPERATING_UNIT = "operating_unit_id";
	public static final String ACCOUNT_ID = "account_id";
	public static final String ACCOUNT = "account";
	public static final String SITE = "site_id";
	public static final String QUESTION_ID = "question_id";
	public static final String ANSWER_ID = "answer_id";
	public static final String ANSWERS = "answers";
	public static final String SCORE = "score";
	public static final String PHQ4_MENTAL_HEALTH = "phq4_mental_health";
	public static final String PHQ9_MENTAL_HEALTH = "phq9_mental_health";
	public static final String GAD7_MENTAL_HEALTH = "gad7_mental_health";


	// bplog fields
	public static final String PARENT_COMPLIANCE_ID = "parent_compliance_id";
	public static final String IS_CHILD_EXISTS = "is_child_exists";
	public static final String PATIENT_MEDICAL_REVIEW_ID = "patient_medical_review_id";
	public static final String PATIENT_LAB_TEST_ID = "patient_lab_test_id";
	public static final String PRESCRIPTION_ID = "prescription_id";
	public static final String PATIENT_TREATMENTPLAN_ID = "patient_treatementplan_id";
	public static final String VISIT_DATE = "visit_date";
	public static final String IS_PRESCRIPTION = "is_prescription";
	public static final String IS_INVESTIGATION = "is_investigation";
	public static final String IS_MEDICAL_REVIEW = "is_medical_review";
	public static final String CURRENT_MEDICATION_ID = "current_medication_id";
	public static final String PATIENT_VISIT_ID = "patient_visit_id";
	public static final String IS_DRUG_ALLERGIES = "is_drug_allergies";
	public static final String IS_ADHERING_CURRENT_MED = "is_adhering_current_med";
	public static final String ADHERRING_MED_COMMENT = "adhering_med_comment";
	public static final String ALLERGIES_COMMENT =  "allergies_comment";
	public static final String COMORBIDITY_ID = "comorbidity_id";
	public static final String OTHER_COMORBIDITY = "other_comorbidity";
	public static final String COMPLICATION_ID = "complication_id";
	public static final String OTHER_COMPLICATION = "other_complication";
	public static final String DIABETES_DIAGNOSIS = "diabetes_diagnosis";
	public static final String IS_HTN_DIAGNOSIS = "is_htn_diagnosis";
	public static final String IS_DIABETES_DIAGNOSIS = "is_diabetes_diagnosis";
	public static final String DIABETES_DIAG_CONTROLLED_TYPE = "diabetes_diag_controlled_type";
	public static final String HTN_PATIENT_TYPE = "htn_patient_type";	
	public static final String HTN_YEAR_OF_DIAGNOSIS = "htn_year_of_diagnosis";
	public static final String DIABETES_YEAR_OF_DIAGNOSIS = "diabetes_year_of_diagnosis";
	public static final String DIABETES_PATIENT_TYPE = "diabetes_patient_type";
	public static final String ANSWER = "answer";
	public static final String LIFESTYLE_ID = "lifestyle_id";
	public static final String COMMENTS = "comments";
	public static final String PHYSICAL_EXAM_ID = "physical_examination_id";
	public static final String COMPLIANT_ID = "complaint_id";
	public static final String PHYSICAL_EXAM_COMMENTS = "physical_exam_comments";
	public static final String COMPLIANT_COMMENTS = "complaint_comments";

    //Patient Lab Test fields
    public static final String LABTEST_NAME = "labtest_name";
    public static final String RESULT_DATE = "result_date";
    public static final String REFERRED_BY = "referred_by";
    public static final String IS_OTHER_LABTEST = "is_other_labtest";
    public static final String RESULT_UPDATE_BY = "result_update_by";
    public static final String IS_REVIEWED = "is_reviewed";

    //Patient labtest result fields
    public static final String IS_ABNORMAL = "is_abnormal";
    public static final String RESULT_STATUS = "result_status";
    public static final String RESULT_VALUE = "result_value";
    public static final String RESULT_NAME = "result_name";
    public static final String DIAGNOSIS = "diagnosis";
    public static final String IS_ON_TREATMENT = "is_on_treatment";
    public static final String GRAVIDA = "gravida";
    public static final String PREGNANCY_FETUSES_NUMBER = "pregnancy_fetuses_number";
    public static final String PARITY = "parity";
    public static final String DIAGNOSIS_TIME = "diagnosis_time";
    public static final String IS_LABTEST_REFERRAL = "is_labtest_referred";
    public static final String MODULE_VALUE = "module_value";
    public static final String CLINICAL_WORFKLOW_ID = "clinical_workflow_id";
    public static final String CUSTOMIZED_WORFKLOW_ID = "customized_workflow_id";
    public static final String SCREEN_TYPE = "screen_type";
	public static final String LAB_TEST_RESULT_ID = "lab_test_result_id";

	// Prescription fields
	public static final String END_DATE = "end_date";
	public static final String SIGNATURE = "signature";
	public static final String MEDICATION_ID = "medication_id";
	public static final String DOSAGE_FREQUENCY_NAME = "dosage_frequency_name";
	public static final String MEDICATION_NAME = "medication_name";
	public static final String DOSAGE_UNIT_VALUE = "dosage_unit_value";
	public static final String PRESCRIBED_DAYS = "prescribed_days";
	public static final String DOSAGE_FREQUNCY_ID = "dosage_frequency_id";
	public static final String INSTRUCTION_NOTE = "instruction_note";
	public static final String DOSAGE_UNIT_ID = "dosage_unit_id";
	public static final String EXIST_PRESCRIPTION_DURATION = "exist_prescription_duration";
	public static final String PRESCRIPTION_DURATION = "prescription_duration";
	public static final String DISCONTINUED_ON = "discontinued_on";
	public static final String DISCONTINUED_REASON = "discontinued_reason";

	// Prescription history fields
	public static final String REMAINING_PRESCRIPTION_DAYS = "remaining_prescription_days";

	// Fill prescription fields
	public static final String PRESCRIPTION_FILLED_DAYS = "prescription_filled_days";

	// Fill prescription history fields
	public static final String FILL_PRESCRIPTION_ID = "fill_prescription_id";

	public static final String IS_LABTEST_REFERRED = "is_labtest_referred";

    public static final String IS_MEDICATION_PRESCRIBED = "is_medication_prescribed";
    public static final String OTHER_COMPLIANCE = "other_compliance";
    public static final String COMPLIANCE_ID = "compliance_id" ;


    public static final String IS_ANSWER_DEPENDENT = "is_answer_dependent";
    //Patient Nutrition Lifestyle Fields
    public static final String PATIENT_NUTRITION_LIFESTYLE_ID = "patient_nutrition_lifestyle_id";
    public static final String LIFESTYLES = "lifestyles";
    public static final String LIFESTYLE = "lifestyle";
    public static final String LIFESTYLE_ASSESSMENT = "lifestyle_assessment";
    public static final String LIFESTYLE_TYPE = "lifestyle_type";
    public static final String ASSESSED_DATE = "assessed_date";
    public static final String ASSESSED_BY = "assessed_by";
    public static final String REFERRED_DATE = "referred_date";
    // public static final String REFERRED_BY = "referred_by";
    public static final String CLINICAL_NOTE = "clinical_note";
    public static final String OTHER_NOTE = "other_note";
    public static final String IS_VIEWED = "is_viewed";

    public static final String NUTRITION_LIFESTYLE_ID = "nutrition_lifestyle_id";
    public static final String NOTIFICATION_ID = "notificationId";
    public static final String BODY_JSON = "body_json";

    public static final String TEMPLATE_ID = "template_id";
    public static final String FORM_DATA_ID = "form_data_id";
    public static final String IS_PROCESSED = "is_processed";
    public static final String RETRY_ATTEMPTS = "retry_attempts";
    public static final String FORM_NAME = "form_name";
    public static final String TO = "\"to\"";
    public static final String CC = "cc";
    public static final String BCC = "bcc";

    public static final String PARENT_ORGANIZATION_ID = "parent_organization_id";
    public static final String SEQUENCE = "sequence";

    public static final String ADDITIONAL_PARAMS = "additional_params";

    //patient
    public static final String OTHER_ID_TYPE = "other_id_type" ;
    public static final String ETHNICITY = "ethnicity" ;
    public static final String LANGUAGES = "languages" ;
    public static final String ID_TYPE = "id_type" ;
    public static final String OTHER_LANGUAGES = "other_languages" ;
    public static final String ER_VISIT_REASON = "er_visit_reason" ;
    public static final String LOTE = "lote" ;
    public static final String HOME_MEDICAL_DEVICES = "home_medical_devices" ;
    public static final String ER_VISIT_FREQUENCY = "er_visit_frequency" ;
    public static final String EMR_NUMBER = "emr_number" ;
    public static final String IS_ER_VISIT_HISTORY = "is_er_visit_history" ;

    //screeninglog
    public static final String BP_ARM = "bp_arm";
    public static final String BP_POSITION = "bp_position";
    public static final String PHYSICALLY_ACTIVE = "physically_active";
    public static final String IS_BEFORE_GESTATIONAL_DIABETES = "is_before_gestational_diabetes";
    public static final String IS_FAMILY_DIABETES_HISTORY = "is_family_diabetes_history";
    public static final String PREFERRED_NAME = "preferred_name";
    public static final String DEVICE_INFO_ID = "device_info_id";

    //BPLOG
    public static final String NOTES = "notes";
    public static final String COVID_VACC_STATUS = "covid_vacc_status";
    public static final String ASSESSMENT_CATEGORY = "assessment_category";
    public static final String ASSESSMENT_LANDMARK = "assessment_landmark";



}
