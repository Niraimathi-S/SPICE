package com.mdtlabs.coreplatform.authserver.service;

import java.text.ParseException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * <p>
 * This an interface class for user module you can implemented this class in any
 * class.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 */
public interface UserService {

	/**
	 * To generate a new refresh token.
	 *
	 * @param userId - user id
	 * @param authToken - auth token
	 * @return Map of auth token and refresh token
	 * @throws ParseException - parse exception
	 * @throws JsonMappingException - json mapping exception
	 * @throws JsonProcessingException - json processing exception
	 * 
	 */
	Map<String, String> generateRefreshToken(long userId, String authToken)
			throws ParseException, JsonMappingException, JsonProcessingException;

}
