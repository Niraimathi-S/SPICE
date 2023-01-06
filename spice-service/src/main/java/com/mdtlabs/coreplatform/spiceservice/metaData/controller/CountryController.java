package com.mdtlabs.coreplatform.spiceservice.metaData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.controller.GenericTenantController;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.spiceservice.metaData.service.CountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController extends GenericTenantController<Country> {
//	@Autowired
//	CountryService countryService;
//	
//	@GetMapping(value = "/{id}")
//	public Country findCountrybyId(@PathVariable("id") Long id) {
//		return countryService.findCountrybyId(id);
//	}
}
