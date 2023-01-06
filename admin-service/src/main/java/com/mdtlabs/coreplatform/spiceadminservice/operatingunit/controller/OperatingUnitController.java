package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.controller;

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
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitDetailsDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;
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
        	SuccessCode.GOT_OU, response.get(Constants.DATA), HttpStatus.OK);
		}
    	return new SuccessResponse<List<OperatingUnitListDTO>>(
    		SuccessCode.GOT_OU, response.get(Constants.DATA), totalCount, HttpStatus.OK);
	}
	
	
	@PostMapping("/operating-unit-list")
	public SuccessResponse<List<OperatingUnitDTO>> getAllOperatingUnits(@RequestBody SearchRequestDTO requestDto) {
//		List<AccountDTO> accountList = accountService.getAllAccounts(requestDto);
		Map<String, Object> response = operatingUnitService.getAllOperatingUnits(requestDto);
		Integer totalCount = (Objects.isNull(response.get(Constants.COUNT))) ? 0
				: Integer.parseInt(response.get(Constants.COUNT).toString());
		if (0 == totalCount) {
			return new SuccessResponse<List<OperatingUnitDTO>>(SuccessCode.GOT_OU, response.get(Constants.DATA),
					HttpStatus.OK);
		}
		return new SuccessResponse<List<OperatingUnitDTO>>(SuccessCode.GOT_OU, response.get(Constants.DATA), totalCount,
				HttpStatus.OK);
	}

	@PostMapping("/details")
	public SuccessResponse<OperatingUnitDetailsDTO> getOUDetails(@RequestBody CommonRequestDTO commonRequestDTO) {
		return new SuccessResponse<OperatingUnitDetailsDTO>(SuccessCode.GOT_OU,
				operatingUnitService.getOUDetails(commonRequestDTO), HttpStatus.OK);
	}
	
	/**
	 * To add operating unit admin user.
	 *
	 * @param user - operating unit admin user details
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
	 * @param requestDto - request data containing user id and tenantId.
	 * @return Boolean
	 * @author Niraimathi S
	 */
	@DeleteMapping(value = "/remove-user")
	public SuccessResponse<User> deleteAccountAdmin(@RequestBody CommonRequestDTO requestDto) {
		operatingUnitService.deleteOUAdmin(requestDto);
        return new SuccessResponse<>(SuccessCode.OU_ADMIN_DELETE, HttpStatus.OK);
	}
	
	/**
	 * Gets  operating unit admin users list.
	 * 
	 * @param requestDTO - request data 
	 * @return List(User) - List of Users
	 * @author Niraimathi S
	 */
	@PostMapping(value = "/admin-users")
	public SuccessResponse<List<UserDTO>> getOUAdminUsers(@RequestBody SearchRequestDTO requestDTO) {
		Map<String, Object> users = operatingUnitService.getOUUsersList(requestDTO);
        return new SuccessResponse<>(SuccessCode.GOT_ADMIN_USERS, users, users.size(), HttpStatus.OK);
	}
	
	@GetMapping("/activate/{id}")
	public SuccessResponse<Operatingunit> activateOUById(@PathVariable("id") long id) {
		operatingUnitService.activateDeactivateOU(id, true);
		return new SuccessResponse<>(SuccessCode.OU_ACTIVATE, HttpStatus.OK);
	}

	/**
	 * To de-activate the account by its id.
	 *
	 * @param id Account id to deactivate an active account
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	@GetMapping("/deactivate/{id}")
	public SuccessResponse<Account> deactivateOUById(@PathVariable("id") long id) {
		operatingUnitService.activateDeactivateOU(id, true);
		return new SuccessResponse<Account>(SuccessCode.OU_DEACTIVATE, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public Operatingunit createOperatingUnit(@RequestBody @Valid Operatingunit operatingUnit) {
		return operatingUnitService.createOperatingUnit(operatingUnit);
	}
	
}
