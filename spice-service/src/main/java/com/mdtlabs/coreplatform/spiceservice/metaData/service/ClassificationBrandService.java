package com.mdtlabs.coreplatform.spiceservice.metaData.service;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.ClassificationBrand;
import com.mdtlabs.coreplatform.common.service.GenericTenantService;

public interface ClassificationBrandService extends GenericTenantService<ClassificationBrand> {

	List<ClassificationBrand> getByCountryAndClassificationId(Long countryId, Long classificationId);

}
