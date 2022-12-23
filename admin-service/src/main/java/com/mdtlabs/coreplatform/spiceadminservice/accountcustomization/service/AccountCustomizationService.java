package com.mdtlabs.coreplatform.spiceadminservice.accountcustomization.service;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.dto.spice.CustomizationRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.AccountCustomization;

/**
 * This interface maintains the CRUD operations for account customization.
 *
 * @author Jeyaharini T A
 *
 */
public interface AccountCustomizationService {

	/**
	 * To add a new account customization data.
	 *
	 * @param accountCustomization - entity
	 * @return AccountCustomization - entity
	 * @author Jeyaharini T A
	 */
	public AccountCustomization addAccountCustomization(AccountCustomization accountCustomization);

	/**
	 * To get account customization data like screening, enrollment forms and
	 * consent data based on conditions such as account id, country id etc.
	 *
	 * @param customizationRequestDto - entity
	 * @return AccountCustomization - entity
	 * @author Jeyaharini T A
	 */
	public AccountCustomization getCustomization(CustomizationRequestDTO customizationRequestDto);

	/**
	 * Update account customization data like screening, enrollment forms and
	 * consent data based on account id and region customization id.
	 *
	 * @param accountCustomization - entity
	 * @return accountCustomization - entity
	 * @author Jeyaharini T A
	 */
	public AccountCustomization updateCustomization(AccountCustomization accountCustomization);

	/**
	 * To remove the account customization by updating is_deleted field based on id.
	 *
	 * @param requestMap - map
	 * @return boolean - true or false
	 * @author Jeyaharini T A
	 */
	public boolean removeCustomization(Map<String, Object> requestMap);

	/**
	 * To get account customization list.
	 *
	 * @param requestData request data
	 * @return List(AccountCustomization) List of AccountCustomization 
	 */
	public List<AccountCustomization> getAccountCustomizations(Map<String, Object> requestData);

}
