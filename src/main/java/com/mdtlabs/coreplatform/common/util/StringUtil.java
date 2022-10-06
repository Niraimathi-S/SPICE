package com.mdtlabs.coreplatform.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdtlabs.coreplatform.common.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;


/**
 * <p>
 * String utils for string validation etc.
 * </p>
 * 
 * @author Prabu created on Nov 02, 2022
 *
 */
public class StringUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	/**
	 * Used to convert the date to string format.
	 *
	 * @param date - date to be converted to string
	 * @return String - string converted date
	 */
	public static String convertToDateString(Date date) {
		String dateString = null;
		logger.debug("Before Conversion of date {}", date);
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT_DD_MM_YYYY);
			dateString = format.format(date);
			logger.debug("After Conversion of date {}", dateString);
		}

		return dateString;
	}
	
	/**
	 * This method is used to get date string
	 * 
	 * @param date      - input date
	 * @param formatStr - format type of string
	 * @return String - date string
	 */
	public static String getDateString(Date date, String formatStr) {
		String dateStr = null;
		DateFormat df = null;
		try {
			if (!CommonUtil.isNull(date, formatStr)) {
				df = new SimpleDateFormat(formatStr);
				dateStr = df.format(date);
			}
		} catch (Exception ex) {
			return null;
		}
		return dateStr;
	}

	/**
	 * Used to get the date string using specific format
	 * 
	 * @param date      - input date
	 * @param formatStr - format type
	 * @return String - formatted date string
	 */
	public static String getFormattedDateString(String date, String formatStr) {
		Date formattedDate = null;
		DateFormat df = null;
		try {
			if (!CommonUtil.isNull(date, formatStr)) {
				df = new SimpleDateFormat(formatStr);
				formattedDate = df.parse(date);
			}
		} catch (Exception ex) {
			return null;
		}
		return getDateString(formattedDate, formatStr);
	}

	/**
	 * This method is used to get date string
	 * 
	 * @param date - input date
	 * @return String - date string
	 */
	public static String getDateString(Date date) {
		return getDateString(date, Constants.JSON_DATE_FORMAT);
	}
	
	/**
	 * Used to get list of comma separeted values.
	 *
	 * @param listOfValues - input list
	 * @return String - comman separated value
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getCommaSepratedValues(List listOfValues) {
		return !CommonUtil.isNull(listOfValues)
				? (String) listOfValues.stream().map(Object::toString).collect(Collectors.joining(Constants.COMMA))
				: Constants.EMPTY;
	}

	/**
	 * Used to get the object value as a string
	 * 
	 * @param object - input object
	 * @return String - string converted from object value
	 */
	public static String getObjectValueAsString(Object object) {
		String value = Constants.EMPTY;
		try {
			if (!CommonUtil.isNull(object)) {
				if (object instanceof String) {
					value = (String) object;
				} else if (object instanceof Integer) {
					value = Constants.EMPTY + (Integer) object;
				} else if (object instanceof Long) {
					value = Constants.EMPTY + (Long) object;
				} else if (object instanceof Double) {
					value = Constants.EMPTY + (Double) object;
				} else if (object instanceof Float) {
					value = Constants.EMPTY + (Float) object;
				} else if (object instanceof Boolean) {
					value = Constants.EMPTY + (((Boolean) object).booleanValue() ? "1" : Constants.STRING_ZERO);
				} else {
					value = object.toString();
				}

			}
		} catch (Exception ex) {
			logger.error("getObjectValueAsString ", ex);
		}
		return value;
	}


	/**
	 * <p>
	 * Common method to append string using the ${@code StringJoiner} and return as
	 * combine string.
	 * </p>
	 *
	 * @param args - Get list of string.
	 * @return String - Combine the string using String Joiner and return as string.
	 */
	public static String constructString(String... args) {
		StringJoiner buildString = new StringJoiner(Constants.SPACE);
		for (String arg : args) {
			buildString.add(arg);
		}
		return buildString.toString();
	}
	
	/**
	 * <p>
	 * Common method to append string using the ${@code StringJoiner} and return as
	 * combine string.
	 * </p>
	 *
	 * @param args - Get list of string.
	 * @return String - Combine the string using String Joiner and return as string.
	 */
	public static String concatString(String... args) {
		StringJoiner buildString = new StringJoiner(Constants.EMPTY);
		for (String arg : args) {
			buildString.add(arg);
		}
		return buildString.toString();
	}
	

	/**
	 * <p>
	 * Used to construct a list from group strings.
	 * </p>
	 * 
	 * @param args - input arguments
	 * @return List<String> - converted list of string
	 */
	public static List<String> constructListFromGroupOfString(String... args) {
		List<String> buildList = new ArrayList<>();
		for (String arg : args) {
			Collections.addAll(buildList, arg);
		}
		return buildList;
	}

	/**
	 * Used to convert time from double to string
	 * 
	 * @param time - input time
	 * @return String - converted time
	 */
	public static String convertTimeDoubleToString(Double time) {
		String timeString = time.toString().replace(".5", ":30").replace(".0", ":00");
		if (timeString.split(":")[Constants.ZERO].length() == Constants.ONE)
			timeString = Constants.STRING_ZERO + timeString;
		return timeString;
	}


}
