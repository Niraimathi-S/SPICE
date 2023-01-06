package com.mdtlabs.coreplatform.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mdtlabs.coreplatform.common.model.dto.spice.AccountWorkflowDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;
import com.mdtlabs.coreplatform.common.model.entity.Site;
import com.mdtlabs.coreplatform.userservice.message.SuccessResponse;

/**
 * This interface is used for admin service feign.
 *
 * @author Prabu
 *
 */
@FeignClient(name = "admin-service")
public interface AdminApiInterface {
	
	@GetMapping("/account/clear")
	public ResponseEntity<Boolean> clearApiPermissions(@RequestHeader("Authorization") String token,
		@RequestHeader("TenantId") long tenantId);
	
	@PostMapping("/data/country")
	public Country createCountry(@RequestHeader("Authorization") String token,
			@RequestHeader("TenantId") long tenantId, @RequestBody Country country);

	@PostMapping("/account/create")
	public Account createAccount(@RequestHeader("Authorization") String token,
			@RequestHeader("TenantId") long tenantId, @RequestBody AccountWorkflowDTO account);

	@PostMapping("/operating-unit/create")
	public Operatingunit createOperatingUnit(@RequestHeader("Authorization") String token,
			@RequestHeader("TenantId") long tenantId, @RequestBody Operatingunit operatingunit);

	@PostMapping("/site")
	public Site createSite(@RequestHeader("Authorization") String token,
			@RequestHeader("TenantId") long tenantId, @RequestBody Site site);
	
}
