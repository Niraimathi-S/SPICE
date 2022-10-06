package com.mdtlabs.coreplatform.common.telecounselor;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * To define the common static parameter used all over the application for
 * patient profile.
 * </p>
 *
 * @author AkashGopinath created on Sep 23, 2022
 */
public final class PatientProfileConstants {

	private PatientProfileConstants() {
	}

	// questions with category
	public static final String QUESTION_CATEGORY = "question_category";
	public static final String CATEGORY_NAME = "category_name";
	public static final String QUESTION_GROUP = "question_group";
	public static final String DISPLAY_ORDER = "display_order";
	public static final String QUESTION_ID = "question_id";

	// lists of questions
	public static final String CALL_SCRIPT_QUESTION_DATA = "call_script_question_data";
	public static final String QUESTION = "question";
	public static final String DESCRIPTION = "description";

	// list of answers
	public static final String CALL_SCRIPT_ANSWER_DATA = "call_script_answer_data";
	public static final String ANSWER = "answer";

	// call register details
	public static final String PATIENT_CALL_REGISTER = "patient_call_register";
	public static final String PATIENT_CHASELIST_ID = "patient_chaselist_id";
	public static final String DAY = "day";
	public static final String START_TIME = "start_time";
	public static final String END_TIME = "end_time";
	public static final String CALL_DURATION = "call_duration";
	public static final String CALL_STATUS = "call_status";
	public static final String CALL_REASON = "call_reason";

	// call script question
	public static final String PATIENT_CALL_SCRIPT_QUESTION = "patient_call_script_question";
	public static final String PATIENT_CALL_REGISTER_ID = "patient_call_register_id";
	public static final String PATIENT_CALL_SCRIPT_QUESTION_ID = "patient_call_script_question_id";

	// call script answer
	public static final String PATIENT_CALL_SCRIPT_ANSWER = "patient_call_script_answer";
	public static final String ANSWER_ID = "answer_id";
	public static final String FACILITY_ID = "facility_id";

	public static final String PATIENT_HISTROY_NOT_FOUND = "No Patient History Found";
	public static final List<String> NO_PATIENT_HISTORY_FOUND_LIST = Arrays.asList(PATIENT_HISTROY_NOT_FOUND);

	// list of answers
	public static final String QUESTION_ANSWERS = "question_answers";

	// list of field names
	public static final String ID = "id";
	public static final String DISPLAY_ORDER_FIELD = "displayOrder";
	public static final String QUESTION_GROUP_FIELD = "questionGroup";

}