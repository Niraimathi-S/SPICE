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
public class Logger extends BaseLogger {

	private static final String LOGGER_01 = "{0} - {1}";
	private static final String LOGGER_012 = "{0} - {1} - {2}";
	private static final String LOGGER_ERROR_01 = "{0} - Error Code : {1}";

	/**
	 * This method is used to log debug part
	 * 
	 * @param message - content of log
	 * @param aClass  - entity class
	 */
	public static void logDebug(String message, Class<?> aClass) {
		logger.debug(MessageFormat.format(LOGGER_012, new Object[] { getPrefix(), message, aClass.getSimpleName() }));
	}

	/**
	 * This method is used to get the prefix part of log
	 * 
	 * @return String - prefix log
	 */
	private static String getPrefix() {
		return MessageFormat.format(LOGGER_01, CommonUtil.getLoggedInEmployeeLog());
	}

	/**
	 * This method is used to log debug part
	 * 
	 * @param message - content of log
	 */
	public static void logDebug(String message) {
		logger.debug(MessageFormat.format(LOGGER_01, new Object[] { getPrefix(), message }));
	}

	/**
	 * This method is used to log error part
	 * 
	 * @param message - content of log
	 */
	public static void logError(String message) {
		logger.error(
				MessageFormat.format(LOGGER_012, new Object[] { getPrefix(), CommonUtil.getLoggedInEmployeeLog(), message }));
	}

	/**
	 * This method is used to log error part with code
	 * 
	 * @param Status_code - code of error on status
	 * @param message     - content of log
	 */
	public static void logError(String Status_code, String message) {
		logger.error(MessageFormat.format(LOGGER_ERROR_01, getPrefix(), Status_code));
		logger.error(message);
	}

	/**
	 * This method is used to log info part
	 * 
	 * @param message - content of log
	 * @param aClass  - class entity
	 */
	public static void logInfo(String message, Class<?> aClass) {
		logger.info(MessageFormat.format(LOGGER_012, new Object[] { getPrefix(), message, aClass.getSimpleName() }));
	}

	/**
	 * This method is used to get log info part
	 * 
	 * @param message - content of log
	 */
	public static void logInfo(String message) {
		logger.info(MessageFormat.format(LOGGER_01, new Object[] { getPrefix(), message }));
	}

	/**
	 * This method is used to log warning part
	 * 
	 * @param message - content of log
	 */
	public static void logWarn(String message) {
		logger.warn(MessageFormat.format(LOGGER_01, new Object[] { getPrefix(), message }));
	}

	/**
	 * This method is used to log trace part
	 * 
	 * @param message - content of log
	 */
	public static void logTrace(String message) {
		logger.trace(MessageFormat.format(LOGGER_01, new Object[] { getPrefix(), message }));
	}

	/**
	 * This method is used to log error part
	 * 
	 * @param exception - trace of exception
	 */
	public static void logError(Exception exception) {
		logger.error(MessageFormat.format(LOGGER_01, new Object[] { getPrefix(), exception.getMessage() }), exception);
	}

	/**
	 * This method is used to log error part with message
	 * 
	 * @param message   - content of log
	 * @param exception - trace of exception
	 */
	public static void logError(String message, Exception exception) {
		logger.error(MessageFormat.format(LOGGER_01, new Object[] { getPrefix(), message }), exception);
	}
}
