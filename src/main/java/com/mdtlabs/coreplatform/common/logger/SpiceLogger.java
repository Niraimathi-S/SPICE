package com.mdtlabs.coreplatform.common.logger;

import java.text.MessageFormat;

import com.mdtlabs.coreplatform.common.util.CommonUtil;

/**
 * <p>
 * Logger level with custom message.
 * </p>
 *
 * @author Vigneshkumar created on Jun 30, 2022
 *
 */
public class SpiceLogger extends BaseLogger {

	private static final String _0_1 = "{0} - {1}";
	private static final String _0_1_2 = "{0} - {1} - {2}";
	private static final String _0_ERROR_1 = "{0} - Error Code : {1}";

	public static void logDebug(String message, Class<?> aClass) {
		logger.debug(MessageFormat.format(_0_1_2, new Object[] { getPrefix(), message, aClass.getSimpleName() }));
	}

	private static String getPrefix() {
		return MessageFormat.format(_0_1, new Object[] { CommonUtil.getLoggedInEmployeeLog() });
	}

	public static void logDebug(String message) {
		logger.debug(MessageFormat.format(_0_1, new Object[] { getPrefix(), message }));
	}

//	public static void logEntry() {
//		logger.traceEntry();
//	}

	public static void logError(String message) {
		logger.error(MessageFormat.format(_0_1_2,
				new Object[] { getPrefix(), CommonUtil.getLoggedInEmployeeLog(), message }));
	}

	public static void logError(String Status_code, String message) {
		logger.error(MessageFormat.format(_0_ERROR_1, new Object[] { getPrefix(), Status_code }));
		logger.error(message);
	}

//	public static void logExit() {
//		logger.traceExit();
//	}

	public static void logInfo(String message, Class<?> aClass) {
		logger.info(MessageFormat.format(_0_1_2, new Object[] { getPrefix(), message, aClass.getSimpleName() }));
	}

	public static void logInfo(String message) {
		logger.info(MessageFormat.format(_0_1, new Object[] { getPrefix(), message }));
	}

	public static void logWarn(String message) {
		logger.warn(MessageFormat.format(_0_1, new Object[] { getPrefix(), message }));
	}

	public static void logTrace(String message) {
		logger.trace(MessageFormat.format(_0_1, new Object[] { getPrefix(), message }));
	}

	public static void logError(Exception e) {
		logger.error(MessageFormat.format(_0_1, new Object[] { getPrefix(), e.getMessage() }), e);
	}

	public static void logError(String message, Exception e) {
		logger.error(MessageFormat.format(_0_1, new Object[] { getPrefix(), message }), e);
	}
}
