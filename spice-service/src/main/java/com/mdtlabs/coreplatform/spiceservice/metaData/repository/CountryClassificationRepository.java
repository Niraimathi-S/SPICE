package com.mdtlabs.coreplatform.spiceservice.metaData.repository;

import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.spice.CountryClassification;
import com.mdtlabs.coreplatform.common.repository.GenericTenantRepository;

@Repository
public interface CountryClassificationRepository extends GenericTenantRepository<CountryClassification> {

}
