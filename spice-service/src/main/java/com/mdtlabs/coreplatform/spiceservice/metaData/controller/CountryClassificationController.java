package com.mdtlabs.coreplatform.spiceservice.metaData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.controller.GenericTenantController;
import com.mdtlabs.coreplatform.common.model.entity.spice.CountryClassification;
import com.mdtlabs.coreplatform.spiceservice.metaData.service.CountryClassificationService;

@RestController
@RequestMapping(value = "/country-classification")
public class CountryClassificationController extends GenericTenantController<CountryClassification> {
//	filters: `paginate=false&country=${countryId}

	@Autowired
	CountryClassificationService countryClassificationService;
	
	@GetMapping(value = "/list")
	public List<CountryClassification> getClassificationsByCountryId(@RequestParam("countryId") Long countryId) {
		return countryClassificationService.getClassificationsByCountryId(countryId);
	}

}
