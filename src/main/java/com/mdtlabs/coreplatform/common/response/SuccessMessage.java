package com.mdtlabs.coreplatform.common.response;

import lombok.Data;

import java.util.List;

/**
 * <p>
 * Generic success message object.
 * </p>
 * 
 * @author Vigneshkumar created on Jun 30, 2022
 *
 * @param <T> -
 */
@Data
public class SuccessMessage<T> {
	private String message;
	private Object entity;
	private boolean status;
	private List<T> entityList;
	private Integer responseCode;
	private Integer totalCount;

	/**
	 * <h1>Success message.</h1>
	 * 
	 * @param status       -status is passed in this attribute.
	 * @param message      - Message to be displayed to the user is passed in this
	 *                     attribute.
	 * @param entity       - object is passed in this attribute.
	 * @param entityList   - list is passed in this attribute.
	 * @param responseCode - response code is passed in this attribute.
	 * @param totalCount   - total count is passed in this attribute.
	 */
	public SuccessMessage(boolean status, String message, Object entity, List<T> entityList, Integer responseCode,
			Integer totalCount) {
		this.setMessage(message);
		this.setEntity(entity);
		this.setEntityList(entityList);
		this.setStatus(status);
		this.setResponseCode(responseCode);
		this.setTotalCount(totalCount);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<T> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
