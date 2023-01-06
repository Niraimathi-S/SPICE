package com.mdtlabs.coreplatform.spiceadminservice.site.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SiteDetailsDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SiteListDTO;
import com.mdtlabs.coreplatform.common.model.entity.Site;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessCode;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessResponse;
import com.mdtlabs.coreplatform.spiceadminservice.site.service.SiteService;


/**
 * This controller class maintains CRUD operation for site data.
 *
 * @author Jeyaharini T A
 */

@RestController
@RequestMapping(value = "/site")
@Validated
public class SiteController {

	@Autowired
	SiteService siteService;

	@PostMapping
	public SuccessResponse<Site> addSite(@RequestBody Site site) {
		return new SuccessResponse<Site>(SuccessCode.SITE_SAVE, siteService.addSite(site), HttpStatus.OK);
	}

	@PutMapping
	public SuccessResponse<Site> updateSite(@RequestBody Site site) {
		return new SuccessResponse<Site>(SuccessCode.SITE_UPDATE, siteService.updateSite(site), HttpStatus.OK);
	}
	
	/**
	 * Gets Sites based on tenant its tenant Ids.
	 *
	 * @param tenants list if tenant IDs
	 * @return List of Site Entities
	 */
	@PostMapping(value = "/get-sites-by-tenants")
	public List<Site> getSitesByTenantIds(@RequestBody List<Long> tenants) {
		return siteService.getSitesByTenantIds(tenants);
	}
	
	/**
	 * Gets Sites based on operating unit Id.
	 *
	 * @param operatingUnitId operating unit Id
	 * @return List of Site Entities
	 */
	@GetMapping(value = "/get-by-ou-id/{operatingUnitId}")
	public List<Site> getSitesByOperatingUnitId(@PathVariable(value = "operatingUnitId") Long operatingUnitId) {
		return siteService.getSitesByOperatingUnitId(operatingUnitId);
	}
	
	
	/**
	 * Gets a site using id and isDeleted fields.
	 *
	 * @param siteId site id
	 * @return Site entity
	 */
	@GetMapping(value = "/{siteId}")
	public Site getSiteById(@PathVariable("siteId") Long siteId) {
		return siteService.getSiteById(siteId);
	}

	@PostMapping(value = "/details")
	public SuccessResponse<SiteDetailsDTO> getSiteDetails(@RequestBody CommonRequestDTO requestDTO) {
		return new SuccessResponse<>(SuccessCode.GOT_OU, siteService.getSiteDetails(requestDTO),HttpStatus.OK);
	}
	
	
	/**
	 * To add site admin user.
	 *
	 * @param user - account admin user details
	 * @return User - User entity
	 * @author Niraimathi S
	 */
	@PostMapping(value = "/add-user")
	public SuccessResponse<User> addAccountAdmin(@RequestBody @Valid User user) {
		siteService.addSiteAdmin(user);
        return new SuccessResponse<>(SuccessCode.SITE_ADMIN_SAVE, HttpStatus.CREATED);
	}

	
	/**
	 * To update site admin user.
	 *
	 * @param user - updated user details
	 * @return User - user entity
	 * @author Niraimathi S
	 */
	@PutMapping(value = "/update-user")
	public SuccessResponse<User> updateAccountAdmin(@RequestBody @Valid User user) {
		siteService.updateSiteAdmin(user);
        return new SuccessResponse<>(SuccessCode.SITE_ADMIN_UPDATE, HttpStatus.OK);
	}
	
	/**
	 * To delete site admin user.
	 *
	 * @param requestDto - request data containing user id and tenantId.
	 * @return Boolean
	 * @author Niraimathi S
	 */
	@DeleteMapping(value = "/remove-user")
	public SuccessResponse<User> deleteAccountAdmin(@RequestBody CommonRequestDTO requestDto) {
		siteService.deleteSiteAdmin(requestDto);
        return new SuccessResponse<>(SuccessCode.SITE_ADMIN_REMOVE, HttpStatus.OK);
	}
	
	@PostMapping(value = "/list")
	public SuccessResponse<List<SiteListDTO>> getSiteList(@RequestBody RequestDTO requestDto) {
		Map<String, Object> response = siteService.getSiteList(requestDto);
		List<SiteListDTO> siteListDTO = response.containsKey(Constants.DATA)
			? (List<SiteListDTO>) response.get(Constants.DATA)
			: new ArrayList<>();
		Integer totalCount = (response.containsKey(Constants.COUNT) && !Objects.isNull(response.get(Constants.COUNT)))
			? Integer.parseInt(response.get(Constants.COUNT).toString())
			: null;
		return new SuccessResponse(SuccessCode.GET_SITE, siteListDTO, totalCount,
			HttpStatus.OK);
	}
}
