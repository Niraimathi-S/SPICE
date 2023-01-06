package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.Country;

import lombok.Data;

@Data
public class SiteDetailsDTO {
    private Long id;
    private String name;
    private String email;
    private String addressType;
    private String addressUse;
    private String address1;
    private String address2;
    private String latitude;
    private String longitude;
    private Map<String, Object> city;
    private String phoneNumber;
    private int postalCode;
    private Map<String, Object> siteLevel;
    private String siteType;
    private ParentOrganizationDTO country;
    private ParentOrganizationDTO county;
    private ParentOrganizationDTO subCounty;
    private ParentOrganizationDTO account;
    private ParentOrganizationDTO operatingUnit;
    private ParentOrganizationDTO culture;
    private Long tenantId;
}
