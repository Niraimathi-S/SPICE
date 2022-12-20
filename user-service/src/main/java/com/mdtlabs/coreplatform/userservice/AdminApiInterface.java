package com.mdtlabs.coreplatform.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mdtlabs.coreplatform.userservice.message.SuccessResponse;

@FeignClient(name = "admin-service")
public interface AdminApiInterface {
	
	@GetMapping("/account/clear")
	public ResponseEntity<Boolean> clearApiPermissions(@RequestHeader("Authorization") String token,
			@RequestHeader("TenantId") long tenantId);
}
