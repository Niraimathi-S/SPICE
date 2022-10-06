package com.mdtlabs.coreplatform.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.Timezone;

@Repository
public interface TimezoneRepository extends JpaRepository<Timezone, Long>{

}
