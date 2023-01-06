package com.mdtlabs.coreplatform.spiceservice.metaData.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.model.entity.spice.CountryClassification;
import com.mdtlabs.coreplatform.common.service.Impl.GenericTenantServiceImpl;
import com.mdtlabs.coreplatform.spiceservice.metaData.repository.CountryClassificationRepository;
import com.mdtlabs.coreplatform.spiceservice.metaData.service.CountryClassificationService;

@Service
public class CountryClassificationServiceImpl extends GenericTenantServiceImpl<CountryClassification>
		implements CountryClassificationService {
	
	@Autowired
	CountryClassificationRepository countryClassificationRepository;
	
	public List<CountryClassification> getClassificationsByCountryId(Long countryId) {
		return countryClassificationRepository.findByCountryIdAndIsDeletedFalse(countryId);
	}
}
