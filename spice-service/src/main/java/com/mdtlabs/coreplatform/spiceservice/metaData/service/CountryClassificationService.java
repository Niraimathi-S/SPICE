package com.mdtlabs.coreplatform.spiceservice.metaData.service;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.CountryClassification;
import com.mdtlabs.coreplatform.common.service.GenericTenantService;

public interface CountryClassificationService extends GenericTenantService<CountryClassification> {

	List<CountryClassification> getClassificationsByCountryId(Long countryId);

}
