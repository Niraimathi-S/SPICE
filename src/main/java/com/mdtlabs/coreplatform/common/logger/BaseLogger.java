package com.mdtlabs.coreplatform.common.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdtlabs.coreplatform.common.Constants;

/**
 * <p>
 * Logger information
 * </p>
 * 
 * @author Vigneshkumar created on Jun 30, 2022
 *
 */
public abstract class BaseLogger {

	protected static Logger logger = LoggerFactory.getLogger(Constants.LOGGER);
}
