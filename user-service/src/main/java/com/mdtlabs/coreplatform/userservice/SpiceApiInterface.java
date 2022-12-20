package com.mdtlabs.coreplatform.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "spice-service")
public interface SpiceApiInterface {
	
	@GetMapping("/assessment/clear")
	public ResponseEntity<Boolean> clearApiPermissions(@RequestHeader("Authorization") String token,
			@RequestHeader("TenantId") long tenantId);
}
