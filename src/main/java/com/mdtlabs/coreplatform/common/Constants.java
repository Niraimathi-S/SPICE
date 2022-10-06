package com.mdtlabs.coreplatform.common;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * To define the common static parameter used all over the application.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 *
 */
public final class Constants {

	private Constants() {
	};

	public static final String PACKAGE_CORE_PLATFORM = "com.mdtlabs.coreplatform";
	public static final String SPICE_LOGGER = "SpiceLogger";
	public static final int INACTIVE_SESSION_EXPIRE_HOURS = 5;

	// Common Symbols & Strings
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String OPEN_BRACKET = "[";
	public static final String CLOSE_BRACKET = "]";
	public static final String HYPHEN = "-";
	public static final String ASTERISK_SYMBOL = "*";
	public static final String FORWARD_SLASH = "/";
	public static final String COMMA = ",";
	public static final String EQUALS = "=";
	public static final String AND = "and";
	public static final String HOUR_SEPERATOR = ":";
	public static final String DOT = ".";
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	public static final String GENDER_MALE = "Male";
	public static final String GENDER_FEMALE = "Female";

	// Date Formate
	public static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String CURRENT_TIMESTAMP_DATE_FORMAT = "yyyy.MM.dd.HH.mm.ss";
	public static final String DATE = "DATE";
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public static String DATE_FORMAT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSS[XXX]";
	public static String DATE_FORMAT = "dd MMM, yyyy";

	// Fields
	public static final String ID = "id";
	public static final String CREATED_BY = "created_by";
	public static final String CREATED_AT = "created_at";
	public static final String UPDATED_BY = "updated_by";
	public static final String UPDATED_AT = "updated_at";
	public static final String NAME = "name";
	public static final String SITE_ID = "site_id";
	public static final String GENDER = "gender";
	public static final String REGION = "region";
	public static final String NO_DATA_FOUND = "No Data Found";
	public static final List<String> NO_DATA_LIST = Arrays.asList(NO_DATA_FOUND);
	public static final String DESCRIPTION = "description";
	public static final String IS_ACTIVE = "is_active";
	public static final String IS_DELETED = "is_deleted";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String USER_ID = "user_id";
	public static final String ROLE_ID = "role_id";
	public static final String ROLES = "roles";
	public static final String TYPE = "type";
	public static final String STATUS = "status";
	public static final String ADDRESS = "address";
	public static final String MOBILE_NUMBER = "mobile_number";
	public static final String VM_CONTENT = "vm_content";
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
	public static final String TELECOUNSELOR = "Telec0unseL0r";
	public static final String ENTITY = "entity";
	public static final String ACTION = "action";
	public static final String ENTITY_ID = "entity_id";
	public static final String COLUMN_NAME = "column_name";
	public static final String OLD_VALUE = "old_value";
	public static final String NEW_VALUE = "new_value";
	public static final String CREATE = "create";
	public static final String UPDATE = "update";
	public static final String USER_ENTITY = "User";
	public static final String ROLE_ENTITY = "Role";
	public static final String FORGOT_NOTIFICATION_SUBJECT = "Spice Forgot Password";
	public static final String RESET_NOTIFICATION_SUBJECT = "Spice Password Reset";
	public static final String CREATION_NOTIFICATION_SUBJECT = "Spice User Creation";
	public static final String FORGOT_PASSWORD = "Forgot Password";
	public static final String USER_CREATION = "User Creation";
	public static final String APP_URL_EMAIL = "app_url_email";
	public static final String NEW_USER_CREATION = "User_Creation";
	public static final String FORGOT_PASSWORD_USER = "Forgot_Password";
	public static final String NOTIFICAION_STATUS_FAILED = "Notification status failed";
	public static final String NOTIFICAION_STATUS_PROCESSED = "Notification status processed";
	public static final String COUNTY_ID = "county_id";
	public static final String SUBCOUNTY_ID = "sub_county_id";
	public static final String CULTURE_ID = "culture_id";
	public static final String COUNTRY_CODE = "country_code";
	public static final String MAX_NO_OF_USERS = "max_no_of_users";
	public static final String COUNTY = "county";
	public static final String SUBCOUNTY = "sub_county";
	public static final String CULTURE = "culture";
	public static final String COUNTRY = "country";
	public static final String ACCOUNT = "account";
	public static final String ACCOUNT_ID = "account_id";
	public static final String DISPLAY_ORDER = "display_order";
	public static final String CODE = "code";
	public static final String PHONE_NUMBER = "phone_number";
	public static final String POSTAL_CODE = "postal_code";
	public static final String SITE_TYPE = "site_type";
	public static final String SITE_LEVEL = "site_level";
	public static final String ADDRESS_ONE = "address_1";
	public static final String ADDRESS_TYPE = "address_type";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String ADDRESS_USE = "address_use";
	public static final String OPERATING_UNIT_ID = "operating_unit_id";
	public static final String UTC = "UTC";
	public static final String TIMEZONE_ID = "timezone_id";
	public static final String ABBREVIATION = "abbreviation";
	public static final String METHOD = "method";
	public static final String API = "api";

	// Entity Table names
	public static final String TABLE_ROLE = "role";
	public static final String TABLE_USER = "\"user\"";
	public static final String TABLE_USER_ROLE = "user_role";
	public static final String TABLE_NOTIFICATION = "notification";
	public static final String TABLE_EMAIL_TEMPLATE = "email_template";
	public static final String TABLE_COUNTRY = "country";
	public static final String TABLE_STATE = "state";
	public static final String TABLE_DISTRICT = "district";
	public static final String TABLE_EMAIL_TEMPLATE_VALUE = "email_template_value";
	public static final String TENANT_ID = "tenant_id";
	public static final String TABLE_AUDIT = "audit";
	public static final String TABLE_ACCOUNT = "account";
	public static final String TABLE_OPERATINGUNIT = "operatingunit";
	public static final String TABLE_SITE = "site";
	public static final String TABLE_PROGRAM = "program";
	public static final String TABLE_COUNTY = "county";
	public static final String TABLE_SUBCOUNTY = "subcounty";
	public static final String TABLE_CULTURE = "culture";
	public static final String TABLE_ORGANIZATIONS = "organizations";
	public static final String TABLE_TIMEZONE = "timezone";
	public static final String TABLE_PROGRAM_DETAILS = "program_details";
	public static final String TABLE_USER_FILTER_LOCK = "user_filter_lock";
	public static final String TIMEZONE_OFFSET = "timezone_offset";
	public static final String TABLE_API_ROLE_PERMISSION = "api_role_permission";

	// AESKEY
	public static final String AES_KEY = "Telec0unseL0r";
	public static final String AES_KEY_TOKEN = "te!e(0unsElor@321";

	// Application
	public static final String ISSUER = "SpiceApplication";
	public static final String ROLE_ID_PARAM = "roleId";
	public static final String PAGE_NUMBER = "pageNumber";
	public static final String ERROR_USER_BLOCKED = "User is blocked.";
	public static final String TOKEN_ISSUER = "User";
	public static final String AUTH_TOKEN_SUBJECT = "Auth_Token";
	public static final String REFRESH_TOKEN_SUBJECT = "Auth_Token";
	public static final Object WEB = "Web";
	public static final long EXPIRY_HOURS = 12;
	public static final long THOUSAND = 1000;
	public static final String SAME_PASSWORD = "New password cannot be same as old password";
	public static final String PASSWORD_ERROR = "Password cannot be same as user name";
	public static final String SALT_KEY = "spice_uat";
	public static final String HASHING_CODE = "SHA-512";
	public static final long THREE = 3;
	public static final String GET_CLASS = "getClass";
	public static final int NUMBER_THREE = 3;
	public static final long TWENTY_FOUR = 24;
	public static final String STRING_ZERO = "0";
	public static final String LOG_PREFIX_REQUEST = "|>";
	public static final String LOG_PREFIX_RESPONSE = "|<";
	public static final String SPLIT_CONTENT = "\r\n|\r|\n";
	public static final String BEARER = "Bearer ";
	public static final long AUTH_TOKEN_EXPIRY_MINUTES = 30;
	public static final long REFRESH_TOKEN_EXPIRY_HOURS = 8;
	public static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	public static final String MESSAGE = "message";
	public static final String ERROR_USERNAME_PASSWORD_BLANK = "No Username and / or Password Provided";
	public static final String ERROR_INVALID_USER = "Invalid credentials";
	public static final String ERROR_ACCOUNT_DISABLED = "Disabled Account";
	public static final String ERROR_INVALID_ATTEMPTS = "Account locked due to multiple invalid login attempts.";
	public static final String INFO_USER_NOT_EXIST = "Username does not exist : ";
	public static final String INFO_USER_EXIST = "Login employee isEnabled : ";
	public static final String INFO_USER_PASSWORD_NOT_MATCH = "Password doesn't match for the user : ";
	public static final String CONTENT_TEXT_TYPE = "text/x-json;charset=UTF-8";
	public static final String CACHE_HEADER_NAME = "Cache-Control";
	public static final String CACHE_HEADER_VALUE = "no-cache";
	public static final String RSA = "RSA";
	public static final String EXCEPTION_TOKEN_UTILS = "Exception occured while loading token utills";
	public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	public static final String AUTHORIZATION = "Authorization";
	public static final String INVALID_USER_ERROR = "{ \"error\": \"Invalid User\"}";
	public static final String LOGIN_ERROR = "Login Error ";
	public static final String ERROR_JWE_TOKEN = "Error while creating jwe token ";
	public static final String USER_ID_PARAM = "userId";
	public static final String USER_DATA = "userData";
	public static final String APPLICATION_TYPE = "applicationType";
	public static final String ANONYMOUS_USER = "anonymousUser";
	public static final String HIBERNATE_EJB_INTERCEPTOR = "hibernate.ejb.interceptor";
	public static final String HIBERNATE_SESSION_FACTORY = "hibernate.session_factory.interceptor";
	public static final String AUDIT = "Audit";
	public static final String GET = "get";
	public static final String MASTER_DATA = "master_data";
	public static final String APPLICATION_JSON = "application/json";
	public static final String DOCUMENTATION_SWAGGER = "documentation.swagger";
	public static final String DOCUMENTATION_SWAGGER_SERVICES = "documentation.swagger.services";
	public static final String TOKEN = "token";
	public static final String EMAIL = "email";
	public static final String ROLE_IDS = "roleIds";
	public static final String JWT_TOKEN = "jwtToken";
	public static final String JWT_REFRESH_TOKEN = "jwtRefreshToken";
	public static final String NOTIFICATION_INSTANCE = "NOTIFICATION";
	public static final String LOGGER = "Logger";
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int INT_THREE = 3;
	public static final int FOUR = 4;
	public static final long SIXTY = 60;
	public static final Boolean BOOLEAN_TRUE = Boolean.TRUE;
	public static final Boolean BOOLEAN_FALSE = Boolean.FALSE;
	public static final String TEXT = "text/*";
	public static final String APPLICATION_XML = "application/*+xml";
	public static final String APPLICATIONJSON = "application/*+json";
	public static final String EXP = "exp";
	public static final String TOKEN_EXPIRED = "Token expired";
	public static final String JOSE_EXCEPTION = "JOSE Excpetion ococcured while loading token utills";
	public static final String EXCEPTION_DURING_TOKEN_UTIL = "Exception occured while loading token utills";
	public static final String AUTHORITY = "authority";
	public static final String RESOLVER_ERROR = "Error message construction using resolver Error Message";
	public static final String DATE_TIME_FORMATTER = "d/M/yyyy";
	public static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/YYYY";
	public static final String SEPARATOR = "\\s*,\\s*";
	public static final String LINK_EXPIRED = "Link has expired.";
	public static final String TIMESTAMP = "TIMESTAMP";
	public static final int WEB_NOTIFICATION_LIMIT = 5;
	public static final String NOTIFICATION_ID = "notificationId";
	public static final String TRUE = "true";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String MAIL_SMTP_PORT = "mail.smtp.port";
	public static final String MAIL_SMTP_SSL_TRUST = "mail.smtp.ssl.trust";
	public static final String MAIL_SMTP_SSL_PROTOCALS = "mail.smtp.ssl.protocols";
	public static final String SMTP_GMAIL_COM = "smtp.gmail.com";
	public static final String SMTP_PORT = "587";
	public static final String SMTP_SSL_PROTOCAL = "TLSv1.2";
	public static final String TEXT_HTML_CHARSET = "text/HTML; charset=UTF-8";
	public static final String FORMAT = "format";
	public static final String FLOWED = "flowed";
	public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
	public static final String ENCODING = "8bit";
	public static final String UTF_8 = "UTF-8";
	public static final String NOTIFICATION = "NOTIFICATION";
	public static final String SAVING_EMAIL_NOTIFICATION_ERROR = "Error while saving notification for email";
	public static final String AUTH_API = "Auth API";
	public static final String VERSION = "1.0";
	public static final String DOCUMENTATION_AUTH_API = "Documentation Auth API v1.0";
	public static final String DOCUMENTATION_USER_API = "Documentation User API v1.0";
	public static final String USER_API = "User API";
	public static final String API_ROLES_MAP_CLEARED = "api permission map cleared";

	// Tenant
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String BEARER_SCHEMA = "Bearer ";
	public static final String TENANT_IDS_CLAIM = "tenantId";
	public static final String ROLE_ID_CLAIM = "roleId";
	public static final String ROLE_NAME_CLAIM = "roleName";

	public static final String TENANT_FILTER_NAME = "tenantFilter";
	public static final String TENANT_PARAMETER_NAME = "tenantId";
	public static final String TENANT_PARAMETER_TYPE = "int";
	public static final String TENANT_COLUMN_NAME = "tenant_id";

	public static final int SUPER_ADMIN_ROLE_ID = 0;
	public static final String SUPER_ADMIN_ROLE_NAME = "ROLE_SUPER_ADMIN";
	public static final String ADMIN_ROLE_NAME = "ROLE_ADMIN";
	public static final String USER_ROLE_NAME = "ROLE_USER";

	public static final int SUPER_TENANT_ADMINISTRATOR_ID = 0;
	public static final String USER_SELECTED_TENANT = "userTenant";

	// Spring Components and warning
	public static final String SERIAL = "serial";
	public static final String ERROR_MESSAGE_PROPERTY = "classpath:error_messages.properties";
	public static final String RAWTYPES = "rawtypes";
	public static final String UNCHECKED = "unchecked";
	public static final String UNUSED = "unused";
	public static final String PASSWORDENCODER = "passwordEncoder";
	public static final String TEMPLATE_MESSAGE_PROPERTY = "classpath:template_message.properties";

	// Date Formate
	public static final String TEN_DIGITS_DECIMAL_FORMAT = "#.##########";
	public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";
	public static final String WEEK = "WEEK";
	public static final String DATE_COLUMN = "date";
	public static final String DAY = "DAY";
	public static final String MONTH = "MONTH";
	public static final String YEARS = "YEARS";
	public static final String END = "End";
	public static final String BEGIN = "Begin";
	public static final String MMM_YY_FORMAT = "MMM-yy";
	public static final String DD_MM_YYYY = "dd-mm-yyyy";
	public static final String TIMEZONE_UTC = "UTC";
	public static final String ACTIVE = "active";

	public static final String NONE = "NONE";
	public static final String ENROLLED = "ENROLLED";
	public static final String SCREENED = "SCREENED";
	public static final String OBSERVATION = "OBSERVATION";

	public static final String HIGH = "High";
	public static final String LOW = "Low";
	public static final String MODERATE = "Moderate";
	public static final String HIGHER_MODERATE = "Higher Moderate";
	public static final String BOTH_MODERATE = "Both Moderate";
	public static final String BOTH_HIGHER_MODERATE = "Both Higher Moderate";
	public static final String GLUCOSE_MODERATE = "Glucose Moderate";

	public static final String SCREENING = "screening";
	public static final String ASSESSMENT = "assessment";
	public static final String ENROLLMENT = "enrollment";
	public static final String MEDICAL_REVIEW = "medicalreview";

	public static final String SYSTOLIC = "systolic";
	public static final String DIASTOLIC = "diastolic";

	public static final String RBS = "rbs";
	public static final String FBS = "fbs";

	public static final String DBM_GLUCOSE_MODERATE = "Take your prescribed medication and come back in 3 days for a BP recheck. Your doctor may ask you to come for medical review";
	public static final String DBM_BOTH_MODERATE = "Take your prescribed medication and come back in 3 days for a BP recheck. Your doctor may ask you to come for medical review.";
	public static final String DBM_HIGHER_MODERATE = "Take your prescribed medication and come back in 3 days for a BP recheck. Your doctor may ask you to come for medical review";
	public static final String DBM_MODERATE = "Take your prescribed medication and come back in 3 days for a BP recheck. Your doctor may ask you to come for medical review";
	public static final String DBM_HIGH = "Go to the hospital or clinic for further evaluation";
	public static final String DBM_LOW = "Great job! Continue to check blood pressure and take prescribed medications";

	public static final int BP_THRESHOLD_SYSTOLIC = 140;
	public static final int BP_THRESHOLD_DIASTOLIC = 90;
	public static final String BG_PROVISIONAL_FREQUENCY_NAME = "Physician Approval Pending";
	public static final String FREQUENCY_BP_CHECK = "BP Check";
	public static final String FREQUENCY_BG_CHECK = "BG Check";
	public static final String FREQUENCY_MEDICAL_REVIEW = "Medical Review";
	public static final String FREQUENCY_HBA1C_CHECK = "Hba1c Check";
	public static final String MEDICAL_REVIEW_FREQUENCY = "Medical Review Frequency";
	public static final String BP_CHECK_FREQUENCY = "Blood Pressure Check Frequency";
	public static final String BG_CHECK_FREQUENCY = "Blood Glucose Check Frequency";
	public static final String HBA1C_CHECK_FREQUENCY = "Hba1c Check Frequency";

	public static final String LABEL = "label";
	public static final String VALUE = "value";
	public static final String FREQUENCY_KEY = "frequencyKey";
	public static final String DIABETES_UNCONTROLLED_OR_POORLY_CONTROLLED = "Diabetes: Uncontrolled/Poorly controlled";
	public static final String DIABETES_WELL_CONTROLLED = "Diabetes: Well-controlled";
	public static final String PRE_DIABETES = "Pre-Diabetic";

	public static final String KNOWN_DIABETES_PATIENT = "known";
	public static final String GLUCOSE_UNIT_MG_DL = "mg/dL";
	public static final String GLUCOSE_UNIT_MMOL_L = "mmol/L";
	public static final String OTHER = "other";
	public static final String ROLE_LAB_TECHNICIAN = "LAB_TECHNICIAN";
	public static final String UNIT = "unit";

	public static final String NEW = "NEW";
	public static final String MEDICAL_REVIEW_COMPLETED = "MEDICAL_REVIEW_COMPLETED";

	public static final String HYPERTENSION = "Hypertension";
	public static final String DIABETES = "Diabetes";
	public static final String DEFAULT = "default";

	public static final String IS_PRESCRIPTION = "is_prescription";
	public static final String IS_INVESTIGATION = "is_investigation";
	public static final String IS_MEDICAL_REVIEW = "is_medical_review";

	public static final String MG_DL = "mg/dL";
	public static final String MMOL_L = "mmol/L";
	public static final String WORKFLOW_SCREENING = "Screening";
	public static final String WORKFLOW_ENROLLMENT = "Enrollment";
	public static final String WORKFLOW_ASSESSMENT = "Assessment";
	public static String SIGNATURE_DATE_FORMAT = "yyyyMMddHHmmssSSS";

	public static final String PHQ4 = "PHQ4";
	public static final String PHQ9 = "PHQ9";
	public static final String GAD7 = "GAD7";
	public static final Integer FBS_MMOL_L = 7;
	public static final Integer RBS_MMOL_L = 11;
	public static final Integer FBS_MG_DL = 126;
	public static final Integer RBS_MG_DL = 198;

}