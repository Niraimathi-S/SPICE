package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessCode;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessResponse;
import com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.OperatingUnitService;


/**
 * This controller class handles all the API requests for OperatingUnit entity.
 *
 * @author Niraimathi S
 *
 */
@RestController
@RequestMapping(value = "/operating-unit")
@Validated
public class OperatingUnitController {
	
	@Autowired
	OperatingUnitService operatingUnitService;
	
	/**
	 * To get Operating unit list with its child organization counts.
	 *
	 * @param requestDto - request data containing search term, skip, limit, etc.,
	 * @return List(OperatingUnitListDTO) - List of operating units.
	 * @author Niraimathi S 
	 */
	@PostMapping("/list")
	public SuccessResponse<List<OperatingUnitListDTO>> getOperatingUnitList(
		@RequestBody RequestDTO requestDto) {
    	Map<String, Object> response = operatingUnitService.getOperatingUnitList(requestDto);
    	Integer totalCount = (Objects.isNull(response.get(Constants.COUNT))) 
    		? 0 : Integer.parseInt(response.get(Constants.COUNT).toString());
    	if (0 == totalCount) {
        	return new SuccessResponse<List<OperatingUnitListDTO>>(
        	SuccessCode.GET_COUNTRY, response.get(Constants.DATA), HttpStatus.OK);
		}
    	return new SuccessResponse<List<OperatingUnitListDTO>>(
    		SuccessCode.GET_COUNTRY, response.get(Constants.DATA), totalCount, HttpStatus.OK);
	}
	
	/**
	 * To add operating unit admin user.
	 * 
	 * @param user - account admin user details
	 * @return User - User entity
	 * @author Niraimathi S
	 */
	@PostMapping(value = "/add-user")
	public SuccessResponse<User> addAccountAdmin(@RequestBody @Valid User user) {
		operatingUnitService.addOUAdmin(user);
        return new SuccessResponse<>(SuccessCode.OU_ADMIN_SAVE, HttpStatus.CREATED);
	}
	
	/**
	 * To update operating unit admin user.
	 * 
	 * @param user - updated user details
	 * @return User - user entity
	 * @author Niraimathi S
	 */
	@PutMapping(value = "/update-user")
	public SuccessResponse<User> updateAccountAdmin(@RequestBody @Valid User user) {
		operatingUnitService.updateOUAdmin(user);
        return new SuccessResponse<>(SuccessCode.OU_ADMIN_UPDATE, HttpStatus.OK);
	}
	
	/**
	 * To delete operating unit admin user.
	 * 
	 * @param requestDTO - request data containing user id and tenantId.
	 * @return Boolean
	 * @author Niraimathi S
	 */
	@DeleteMapping(value = "/remove-user")
	public SuccessResponse<User> deleteAccountAdmin(@RequestBody CommonRequestDTO requestDTO) {
		operatingUnitService.deleteOUAdmin(requestDTO);
        return new SuccessResponse<>(SuccessCode.OU_ADMIN_DELETE, HttpStatus.OK);
	}
	
	
}
