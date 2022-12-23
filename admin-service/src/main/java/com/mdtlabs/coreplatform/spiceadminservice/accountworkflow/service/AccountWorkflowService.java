package com.mdtlabs.coreplatform.spiceadminservice.accountworkflow.service;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.AccountWorkflow;


/**
 * This interface maintains the CRUD operation for AccountWorkflow Entity.
 *
 * @author Jeyaharini T A
 */
public interface AccountWorkflowService {

	/**
	 * This method is used to add a new account workflow.
	 *
	 * @param accountWorkflow - entity
	 * @return AccountWorkflow - entity
	 * @author Jeyaharini T A
	 */
	public AccountWorkflow addAccountWorkflow(AccountWorkflow accountWorkflow);

	/**
	 * This method is used to get the account workflow details based on country id
	 * and name.
	 *
	 * @param searchRequestDto - search request dto
	 * @return list of AccountWorkflow entity
	 * @author Jeyaharini T A
	 */
	List<AccountWorkflow> getAccountWorkflows(SearchRequestDTO searchRequestDto);

	/**
	 * This method is used to update the account workflow such as view screen.
	 *
	 * @param accountWorkflow - entity
	 * @return AccountWorkflow entity
	 * @author Jeyaharini T A
	 */
	public AccountWorkflow updateAccountWorkflow(AccountWorkflow accountWorkflow);

	/**
	 * This method is used to delete the account workflow by updating isDeleted
	 * column status.
	 *
	 * @param id - workflow id
	 * @return boolean - true or false
	 * @author Jeyaharini T A
	 */
	public boolean removeAccountWorkflow(long id);

	/**
	 * This method is used to get list of account work flows.
	 *
	 * @return List - account workflow list
	 */
	public List<AccountWorkflow> getAllAccountWorkFlows();


}
