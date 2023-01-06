package com.mdtlabs.coreplatform.spiceadminservice.site.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataNotAcceptableException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.exception.SpiceValidation;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.ParentOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SiteDetailsDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SiteListDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.County;
import com.mdtlabs.coreplatform.common.model.entity.Culture;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.Site;
import com.mdtlabs.coreplatform.common.model.entity.Subcounty;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.common.repository.DataRepository;
import com.mdtlabs.coreplatform.common.util.CommonUtil;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.site.repository.SiteRepository;
import com.mdtlabs.coreplatform.spiceadminservice.site.service.SiteService;

/**
 * <p>
 * This service class contain all the business logic for user module and perform
 * all the user operation here.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 */
@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	SiteRepository siteRepository;

	@Autowired
	UserApiInterface userApiInterface;
	
	@Autowired
	DataRepository dataRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	/**
	 * {@inheritDoc}
	 */
	public Site addSite(Site site) {

		if (Objects.isNull(site)) {
			throw new SpiceValidation(12006);
		}

		if (!Objects.isNull(site.getEmail()) && !CommonUtil.validateEmail(site.getEmail())) {
			throw new SpiceValidation(00001);
		}

		if (!Objects.isNull(site.getPhoneNumber()) 
			&& !CommonUtil.validatePhoneNumber(site.getPhoneNumber())) {
			throw new SpiceValidation(00002);
		}

		return siteRepository.save(site);
	}

	/**
	 * {@inheritDoc}
	 */
	public Site updateSite(Site site) {
		if (Objects.isNull(site)) {
			throw new BadRequestException(12006);
		}
		if (!Objects.isNull(site.getEmail()) && !CommonUtil.validateEmail(site.getEmail())) {
			throw new DataNotAcceptableException(10003);
		}
		if (!Objects.isNull(site.getPhoneNumber()) 
			&& !CommonUtil.validatePhoneNumber(site.getPhoneNumber())) {
			throw new SpiceValidation(10004);
		}
		Site existingSite = siteRepository.findByIdAndIsDeletedFalse(site.getId());
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(site, existingSite);
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		Organization organization = new Organization();
		organization.setId(site.getTenantId());
		organization.setName(site.getName());
		userApiInterface.updateOrganization(token, UserSelectedTenantContextHolder.get(), organization);
		return siteRepository.save(existingSite);
	}

	/**
	 * {@inheritDoc}
	 */
	public Site activateDeactivateSite(long id, boolean isActiveStatus) {

		Site siteToUpdate = siteRepository.findById(id).get();
		if (Objects.isNull(siteToUpdate)) {
			throw new SpiceValidation(27007);
		}
		siteToUpdate.setActive(isActiveStatus);
		return siteRepository.save(siteToUpdate);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Site> getSitesByTenantIds(List<Long> tenants) {
		return siteRepository.findByIsDeletedFalseAndTenantIdIn(tenants);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Site> getSitesByOperatingUnitId(Long operatingUnitId) {
		return siteRepository.findByOperatingUnitIdAndIsDeletedFalse(operatingUnitId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Site getSiteById(Long siteId) {
		return siteRepository.findByIdAndIsDeletedFalse(siteId);
	}

	/**
	 * {@inheritDoc}
	 */
    public List<Long> activateDeactivateSiteList(Long countryId, Long accountId, 
    	    Long operatingUnitId, boolean isActive) {
    	List<Site> sites = siteRepository.findSite(countryId, accountId, operatingUnitId, !isActive);
    	List<Long> tenantIds = new ArrayList<>();
    	System.out.println("sites-----"+sites);
    	if (!sites.isEmpty()) {
    		sites.stream().forEach(site ->
    		{
    			site.setActive(isActive);
    			tenantIds.add(site.getTenantId());
    		});
    		siteRepository.saveAll(sites);
		}
    	System.out.println("site tenantIds----"+tenantIds);
//        siteRepository.activateInactivateSites(siteIds, isActive);
        return tenantIds;
    }
    
	/**
	 * {@inheritDoc}
	 */
	public Integer getCount(Long countryId, Long accountId, Long operatingUnitId, boolean isActive) {
		return siteRepository.getCount(countryId, accountId, operatingUnitId,isActive);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public User addSiteAdmin(User user) {
		Role role = new Role();
//		role.setName(Constants.ROLE_ACCOUNT_ADMIN);
//		user.setRoles(Set.of(role));
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<User> response = userApiInterface.addAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public User updateSiteAdmin(User user) {
		UserDTO userDto = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDto.getAuthorization();
		ResponseEntity<User> response = userApiInterface.updateAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean deleteSiteAdmin(CommonRequestDTO requestDto) {
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<Boolean> response = userApiInterface.deleteAdminUser(token,
				UserSelectedTenantContextHolder.get(), requestDto);
		return response.getBody();
	}
	
//	public SiteDetailsDTO getSiteDetails(CommonRequestDTO requestDTO) {
//		Site site = siteRepository.findByIdAndIsDeletedFalseAndTenantId(requestDTO.getId(), 
//			requestDTO.getTenantId());
//		if (Objects.isNull(site)) {
//			throw new DataNotFoundException(27007);
//		}
//		return null;
//	}
	
	/**
	 * {@inheritDoc}
	 */
    public SiteDetailsDTO getSiteDetails(CommonRequestDTO requestData) {
        if (Objects.isNull(requestData.getId()) || Objects.isNull(requestData.getTenantId())) {
            throw new DataNotAcceptableException(12012);
        }
        Site site = siteRepository.findByIdAndIsDeletedFalseAndTenantId(requestData.getId(),
                requestData.getTenantId());
        
		if (Objects.isNull(site)) {
			throw new DataNotFoundException(27007);
		}
        
        SiteDetailsDTO siteDetails = modelMapper.map(site, new TypeToken<SiteDetailsDTO>() {
        }.getType());

        siteDetails = constructSiteDetailsResponse(siteDetails, site);
        System.out.println("site with base org ou " + siteDetails);
        return siteDetails;
    }

    /**
     * To construct site details data.
     * 
     * @param siteDetailsDTO - object containing site details
     * @param site - Site object
     * @return SiteDetailsDTO - object containing site details
     */
    private SiteDetailsDTO constructSiteDetailsResponse(SiteDetailsDTO siteDetailsDTO, Site site) {
        System.out.println("site details after mapper " + siteDetailsDTO);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        siteDetailsDTO.setOperatingUnit(modelMapper.map(site.getOperatingUnit(), ParentOrganizationDTO.class));        Account account = dataRepository.getAccountById(site.getAccountId());
        siteDetailsDTO.setAccount(modelMapper.map(account, ParentOrganizationDTO.class));
        Country country = dataRepository.getCountryByIdAndIsDeleted(site.getCountryId());
        siteDetailsDTO.setCountry(modelMapper.map(country, ParentOrganizationDTO.class));
        County county = dataRepository.getCountyById(site.getCountyId());
        siteDetailsDTO.setCounty(modelMapper.map(county, ParentOrganizationDTO.class));
        Subcounty subCounty = dataRepository.getSubCountyById(site.getSubCountyId());
        siteDetailsDTO.setSubCounty(modelMapper.map(subCounty, ParentOrganizationDTO.class));
        Culture culture = dataRepository.getCultureById(site.getCultureId());
        siteDetailsDTO.setCulture(modelMapper.map(culture, ParentOrganizationDTO.class));
        siteDetailsDTO.setCity(Map.of("label",site.getCity(),"value", Map.of("Latitude", site.getLatitude(), "Longitude", site.getLongitude())));
        siteDetailsDTO.setSiteLevel((Map.of("label", site.getSiteLevel(), "value", site.getSiteLevel())));
        return siteDetailsDTO;
    }

    public Map<String, Object> getSiteList(RequestDTO requestDto) {
        String searchTerm = null;
        Pageable pageable = Pagination.setPagination(requestDto.getSkip(), requestDto.getLimit(), Constants.UPDATED_AT,
                Constants.BOOLEAN_FALSE);
        if (!Objects.isNull(requestDto.getSearchTerm())) {
            searchTerm = requestDto.getSearchTerm().replaceAll(Constants.SEARCH_TERM, "");
        }
        List<Site> sites = new ArrayList<>();
        Long countryId = null;
        Long accountId = null;
        Long opreatingUnitId = null;
        Organization organizationResponse = userApiInterface.getOrganizationById(CommonUtil.getAuthToken(),
                UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
        if (!Objects.isNull(organizationResponse)) {
            if (Constants.COUNTRY.equals(organizationResponse.getFormName())) {
                countryId = organizationResponse.getFormDataId();
                organizationResponse.getFormDataId();
            } else if (Constants.ACCOUNT.equals(organizationResponse.getFormName())) {
                accountId = organizationResponse.getFormDataId();
                organizationResponse.getFormDataId();
            } else if (Constants.OPERATING_UNIT.equals(organizationResponse.getFormName())) {
                opreatingUnitId = organizationResponse.getFormDataId();
                organizationResponse.getFormDataId();
            }
            sites = siteRepository.getAllSite(searchTerm, countryId, accountId, opreatingUnitId, pageable);
        }
        int count = siteRepository.getAllSiteCount(searchTerm, countryId, accountId, opreatingUnitId);
        List<SiteListDTO> siteListDTOs = new ArrayList<>();
        if (!Objects.isNull(sites)) {
            siteListDTOs = modelMapper.map(sites, new TypeToken<List<SiteListDTO>>() {
            }.getType());
        }
        Map<String, Object> response = Map.of(Constants.COUNT, count, Constants.DATA, siteListDTOs);
        return response;
    }


}
