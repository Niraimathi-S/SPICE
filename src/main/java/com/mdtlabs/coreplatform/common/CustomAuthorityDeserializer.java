package com.mdtlabs.coreplatform.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Deserialize the granted authority values in user service.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 * 
 */
public class CustomAuthorityDeserializer extends JsonDeserializer {

	@Override
	public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
		JsonNode jsonNode = mapper.readTree(jsonParser);
		List<GrantedAuthority> grantedAuthorities = new LinkedList<>();

		Iterator<JsonNode> elements = jsonNode.elements();
		while (elements.hasNext()) {
			JsonNode next = elements.next();
			JsonNode authority = next.get(Constants.AUTHORITY);
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.asText()));
		}
		return grantedAuthorities;
	}

}
