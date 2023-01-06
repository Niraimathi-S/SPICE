package com.mdtlabs.coreplatform.spiceservice.metaData.service;

import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.service.GenericTenantService;

public interface CountryService extends GenericTenantService<Country> {

	Country findCountrybyId(Long id);

}
