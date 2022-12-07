package com.mdtlabs.coreplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.filter.CorsFilter;

import com.mdtlabs.coreplatform.common.Constants;

/**
 * Used to access common service based operations
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
@SpringBootApplication
@ComponentScan(value = Constants.PACKAGE_CORE_PLATFORM)
@EnableDiscoveryClient
@EnableCaching
public class CommonServiceMain {

	/**
	 * The main method where the execution starts
	 * 
	 * @param args - argument array to be passed
	 */
	public static void main(String[] args) {
		SpringApplication.run(CommonServiceMain.class, args);
	}

	/**
	 * Enable cors filter. Configuration for enabling Cross Origin Requests
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(Boolean.TRUE);
		config.addAllowedOriginPattern(Constants.ASTERISK_SYMBOL);
		config.addAllowedHeader(Constants.ASTERISK_SYMBOL);
		config.addAllowedMethod(HttpMethod.HEAD);
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.PUT);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.PATCH);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		source.registerCorsConfiguration(
				Constants.FORWARD_SLASH + Constants.ASTERISK_SYMBOL + Constants.ASTERISK_SYMBOL, config);
		return new CorsFilter(source);
	}
}
