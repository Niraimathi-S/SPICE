package com.mdtlabs.coreplatform.spiceservice.metaData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.controller.GenericTenantController;
import com.mdtlabs.coreplatform.common.model.entity.spice.ClassificationBrand;
import com.mdtlabs.coreplatform.spiceservice.metaData.service.ClassificationBrandService;

@RestController
@RequestMapping(value = "/classification-brand")
public class ClassificationBrandController extends GenericTenantController<ClassificationBrand> {
	
	@Autowired
	ClassificationBrandService classificationBrandService;
	
	@GetMapping("/list")
	public List<ClassificationBrand> getByCountryAndClassificationId(
		@RequestParam("countryId") Long countryId, @RequestParam("classificationId") Long classificationId) {
		return classificationBrandService.getByCountryAndClassificationId(countryId, classificationId);
	}
}
