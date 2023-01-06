package com.mdtlabs.coreplatform.spiceservice.metaData.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.model.entity.spice.ClassificationBrand;
import com.mdtlabs.coreplatform.common.service.Impl.GenericTenantServiceImpl;
import com.mdtlabs.coreplatform.spiceservice.metaData.repository.ClassificationBrandRepository;
import com.mdtlabs.coreplatform.spiceservice.metaData.service.ClassificationBrandService;

@Service
public class ClassificationBrandServiceImpl extends GenericTenantServiceImpl<ClassificationBrand> implements ClassificationBrandService {

	@Autowired
	ClassificationBrandRepository classificationBrandRepository;
	
	public List<ClassificationBrand> getByCountryAndClassificationId(Long countryId, Long classificationId) {
		return classificationBrandRepository.findByCountryIdAndClassificationIdAndIsDeletedFalse(countryId, classificationId);
	}

}
