package com.mdtlabs.coreplatform.userservice.message;

/**
 * <p>
 * Success code to fetch message from property. Property
 * file(application.property) present in resource folder.
 * </p>
 * 
 * @author Vigneshkumar created on Jun 30, 2022
 *
 */
public enum SuccessCode {

	USER_SAVE(1001),
	USER_UPDATE(1002),
	GET_USERS(1003),
	GET_USER(1004),
	USER_DELETE(1005),
	GET_USER_META_DATA(1006),
	USER_NOT_SAVED(1007),
	USER_NOT_FOUND(1008),
	API_PERMISSION_CLEARED(1015),
	ROLE_SAVE_ERROR(2001),
	GET_ROLES_ERROR(2002),
	ROLE_UPDATE_ERROR(2003),
	ROLE_DELETE_ERROR(2004),
	ROLE_SAVE(2005),
	ROLE_UPDATE(2006),
	GET_ROLES(2007),
	GET_ROLE(2008),
	ROLE_DELETE(2009),
	GET_COUNTRY(3001),
	GET_TIMEZONE(3002),
	SEND_EMAIL_USING_SMTP(3003),
	PASSWORD_UPDATED(3004),
	PASSWORD_DOES_NOT_MATCH(3005),
	DISABLED_ACCOUNT(3006),
	GET_ALL_TIMEZONE(3007),
	GET_ALL_COUNTRY(3008),
	ORGANIZATION_SAVE_ERROR(4001),
	GET_ORGANIZATIONS_ERROR(4002),
	ORGANIZATION_UPDATE_ERROR(4003),
	ORGANIZATION_DELETE_ERROR(4004),
	ORGANIZATION_SAVE(4005),
	ORGANIZATION_UPDATE(4006),
	GET_ORGANIZATIONS(4007),
	GET_ORGANIZATION(4008),
	ORGANIZATION_DELETE(4009);

	private int key;

	SuccessCode(int key) {
		this.key = key;
	}

	public int getKey() {
		return this.key;
	}
}