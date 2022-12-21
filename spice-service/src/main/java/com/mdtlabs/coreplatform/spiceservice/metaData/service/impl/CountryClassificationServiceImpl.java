package com.mdtlabs.coreplatform.spiceservice.metaData.service.impl;

import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.model.entity.spice.CountryClassification;
import com.mdtlabs.coreplatform.common.service.Impl.GenericTenantServiceImpl;
import com.mdtlabs.coreplatform.spiceservice.metaData.service.CountryClassificationService;

@Service
public class CountryClassificationServiceImpl extends GenericTenantServiceImpl<CountryClassification>
		implements CountryClassificationService {

}
