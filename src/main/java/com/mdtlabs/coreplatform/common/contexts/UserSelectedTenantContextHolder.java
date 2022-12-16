package com.mdtlabs.coreplatform.common.contexts;

/**
 * When the end user submits the any request after successful login, the jwe
 * token is required to determine which user currently logged in. This used to
 * capture current user selected tenant object in all service.
 * 
 * <br/>
 * <br/>
 * <b>Explanation:</b> Thread Local can be considered as a scope of access, like
 * a request scope or session scope. It’s a thread scope. You can set any object
 * in Thread Local and this object will be global and local to the specific
 * thread which is accessing this object. Global and local at the same time? :
 * 
 * <ul>
 * <li>Values stored in Thread Local are global to the thread, meaning that they
 * can be accessed from anywhere inside that thread. If a thread calls methods
 * from several classes, then all the methods can see the Thread Local variable
 * set by other methods (because they are executing in same thread). The value
 * need not be passed explicitly. It’s like how you use global variables.</li>
 * <li>Values stored in Thread Local are local to the thread, meaning that each
 * thread will have it’s own Thread Local variable. One thread can not
 * access/modify other thread’s Thread Local variables.</li>
 * </ul>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */

public class UserSelectedTenantContextHolder {

	private static final ThreadLocal<Long> USER_TENANT_CONTEXT = new ThreadLocal<>();

	public static void set(Long tenantId) {
		USER_TENANT_CONTEXT.set(tenantId);
	}

	public static Long get() {
		return USER_TENANT_CONTEXT.get();
	}

	public static void clear() {
		USER_TENANT_CONTEXT.remove();
	}
}
