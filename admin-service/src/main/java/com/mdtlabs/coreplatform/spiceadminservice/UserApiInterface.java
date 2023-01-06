package com.mdtlabs.coreplatform.spiceadminservice;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.User;

/**
 * This interface is used to access User service APIs.
 *
 * @author Niraimathi S
 *
 */
@FeignClient(name = "user-service")
public interface UserApiInterface {
	@PostMapping("/organization/create")
	public ResponseEntity<Organization> createOrganization(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long headerTenantId,
		@RequestBody OrganizationDTO organizationDto);

	@PostMapping("/organization/get-child-organizations/{tenantId}")
	public Map<String, List<Long>> getChildOrganizations(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long headerTenantId, @PathVariable("tenantId") Long tenantId,
		@RequestBody String formName);

	@PostMapping("/user/get-by-tenants")
	public List<User> getUsersByTenantIds(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, @RequestBody List<Long> tenantIds);

	@PostMapping("/organization/add-admin-user")
	public ResponseEntity<User> addAdminUser(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long tenantId, @RequestBody User user);

	@PutMapping("/organization")
	public ResponseEntity<Organization> updateOrganization(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, @RequestBody Organization organization);

	@PutMapping("/organization/update-admin-user")
	public ResponseEntity<User> updateAdminUser(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, @RequestBody User user);

	@DeleteMapping("/organization/delete-admin-user")
	public ResponseEntity<Boolean> deleteAdminUser(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, @RequestBody CommonRequestDTO requestDto);

	@PostMapping("/organization/activate-deactivate")
	public Boolean activateDeactivateOrg(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId,
		@RequestBody List<Long> tenantIds, @RequestParam Boolean isActive);

	@GetMapping(value = "/organization/{id}")
	public ResponseEntity<Organization> getOrganizationById(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, @PathVariable("id") Long id);
	
	@PostMapping("/user/update-active-status")
	public ResponseEntity<Boolean> activateDeactivateUser(@RequestHeader("Authorization") String token,
		@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, @RequestBody List<Long> tenantIds, 
		@RequestParam("isActive") boolean isActive);
	
	@PostMapping("/user/search")
	public ResponseEntity<Map> searchUser(@RequestHeader("Authorization") String token,
			@RequestHeader(Constants.HEADER_TENANT_ID) Long userTenantId, 
			@RequestBody SearchRequestDTO requestDTO);
}
