package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_SITE)
public class Site extends TenantBaseEntity{
    
	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.NAME)
    private String name;

    @Column(name = FieldConstants.EMAIL)
    private String email;
 
    @Column(name = FieldConstants.ADDRESS_TYPE)
    private String addressType;

    @Column(name = FieldConstants.ADDRESS_USE)
    private String addressUse;
    
    @Column(name = FieldConstants.ADDRESS_1)
    private String address1;

    @Column(name = FieldConstants.ADDRESS_2)
    private String address2;

    @Column(name = FieldConstants.LATITUDE)
    private String latitude;

    @Column(name = FieldConstants.LONGITUDE)
    private String longitude;

    @Column(name = FieldConstants.CITY)
    private String city;

    @Column(name = FieldConstants.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = FieldConstants.WORKING_HOURS)
    private float workingHours;

    @Column(name = FieldConstants.POSTAL_CODE)
    private int postalCode;

    @Column(name = FieldConstants.SITE_LEVEL)
    private String siteLevel;

    @Column(name = FieldConstants.SITE_TYPE)
    private String siteType;

    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @Column(name = FieldConstants.COUNTY_ID)
    private Long countyId;

    @Column(name = FieldConstants.SUB_COUNTY_ID)
    private Long subCountyId;

    @Column(name = FieldConstants.ACCOUNT_ID)
    private Long accountId;

    @JoinColumn(name = FieldConstants.OPERATING_UNIT_ID)
    @ManyToOne
    private Operatingunit operatingUnit;

    @Column(name = FieldConstants.CULTURE_ID)
    private Long cultureId;

}
