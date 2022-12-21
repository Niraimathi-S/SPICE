package com.mdtlabs.coreplatform.spiceservice.metaData.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.controller.GenericTenantController;
import com.mdtlabs.coreplatform.common.model.entity.spice.CountryClassification;

@RestController
@RequestMapping(value = "/country-classification")
public class CountryClassificationController extends GenericTenantController<CountryClassification> {

}
