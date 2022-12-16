package com.mdtlabs.coreplatform.spiceservice.deviceDetails.service;

import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.DeviceDetails;

/**
 * This is an interface to perform any actions in deviceDetails related entities
 * 
 * @author Nandhakumar Karthikeyan
 *
 */
public interface DeviceDetailsService {

	/**
	 * This method adds a new Glucose log.
     *
     * @param deviceDetails
     * @return deviceDetails Entity
     * @author Nandhakumar Karthikeyan
     */
    public Map<String, Long> validateDeviceDetails(DeviceDetails deviceDetails); 

}
