package com.mdtlabs.coreplatform.spiceadminservice.data.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataConflictException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.UserOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.County;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.Subcounty;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.data.repository.CountryRepository;
import com.mdtlabs.coreplatform.spiceadminservice.data.repository.CountyRepository;
import com.mdtlabs.coreplatform.spiceadminservice.data.repository.SubCountyRepository;
import com.mdtlabs.coreplatform.spiceadminservice.data.service.DataService;

/**
 * This class is responsible for performing operations on Country, county and
 * sub-county entities.
 *
 * @author Niraimathi S
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	CountyRepository countyRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	SubCountyRepository subCountyRepository;

	@Autowired
	UserApiInterface userApiInterface;

	ModelMapper modelMapper = new ModelMapper();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Country createCountry(CountryOrganizationDTO countryDTO) {
		if (Objects.isNull(countryDTO)) {
			throw new BadRequestException(12006);
		} else {
			String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
			List<Country> existingCountryByCodeOrName = countryRepository
					.findByCountryCodeOrName(countryDTO.getCountryCode(), countryDTO.getName());
			if (!existingCountryByCodeOrName.isEmpty()) {
				throw new DataConflictException(19001);
			}
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			Country country = modelMapper.map(countryDTO, new TypeToken<Country>() {
			}.getType());
			Country countryResponse = countryRepository.save(country);

			Organization organization = new Organization();
			organization.setFormName(Constants.COUNTRY);
			organization.setName(countryResponse.getName());
			organization.setFormDataId(countryResponse.getId());
			OrganizationDTO organizationDTO = new OrganizationDTO();
			organizationDTO.setOrganization(organization);
			organizationDTO.setRoles(List.of(Constants.ROLE_REGION_ADMIN));
			organizationDTO.setSiteOrganization(Constants.BOOLEAN_FALSE);
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			List<User> users = modelMapper.map(countryDTO.getUsers(), new TypeToken<List<User>>() {
			}.getType());
			organizationDTO.setUsers(users);
			ResponseEntity<Organization> response = userApiInterface.createOrganization(token,
					UserSelectedTenantContextHolder.get(), organizationDTO);
			countryResponse.setTenantId(response.getBody().getId());
			countryResponse = countryRepository.save(countryResponse);
			return countryResponse;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Country updateCountry(Country country) {
		if (Objects.isNull(country)) {
			throw new BadRequestException(12006);
		} else {
			Country countryById = countryRepository.findByIdAndIsDeleted(country.getId(), false);
			if (Objects.isNull(countryById)) {
				throw new DataNotFoundException(19004);
			}
			List<Country> existingCountryByCodeOrName = countryRepository
					.findByCountryCodeOrName(country.getCountryCode(), country.getName());
			Map<String, Long> nameMap = new HashMap<>();
			Map<String, Long> codeMap = new HashMap<>();
			for (Country element : existingCountryByCodeOrName) {
				nameMap.put(element.getName(), element.getId());
				codeMap.put(element.getCountryCode(), element.getId());
			}
			if (nameMap.keySet().contains(country.getName()) && nameMap.get(country.getName()) != country.getId()) {
				throw new DataConflictException(19001);
			}
			if (codeMap.keySet().contains(country.getCountryCode())
					&& codeMap.get(country.getCountryCode()) != country.getId()) {
				throw new DataConflictException(19007);
			}
			String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
			Organization organization = new Organization();
			organization.setId(country.getTenantId());
			organization.setName(country.getName());
			userApiInterface.updateOrganization(token, UserSelectedTenantContextHolder.get(), organization);
			return countryRepository.save(country);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Country> getAllCountries(RequestDTO requestObject) {
		int pageNumber = 0 != requestObject.getPageNumber() ? requestObject.getPageNumber() : 0;
		int limit = 0 != requestObject.getLimit() ? requestObject.getLimit() : 10;
		Pageable pageable = PageRequest.of(pageNumber, limit, Sort.by(FieldConstants.NAME).ascending());
		Page<Country> countries;
		if (!Objects.isNull(requestObject.getSearchTerm()) && 0 < requestObject.getSearchTerm().length()) {
			String formattedSearchTerm = requestObject.getSearchTerm().replaceAll("[^a-zA-Z0-9]*", "");
			countries = countryRepository.searchCountries(formattedSearchTerm, pageable);
			return countries.stream().collect(Collectors.toList());
		}
		countries = countryRepository.getAllCountries(pageable);
		return countries.stream().collect(Collectors.toList());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public County addCounty(County county) {
		if (Objects.isNull(county)) {
			throw new BadRequestException(12006);
		}
		County existingCounty = countyRepository.findByCountryIdAndName(county.getCountryId(), county.getName());
		if (!Objects.isNull(existingCounty)) {
			throw new DataConflictException(19002);
		}
		return countyRepository.save(county);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public County getCountyById(long id) {
		County county = countyRepository.findByIdAndIsDeleted(id, false);
		if (Objects.isNull(county)) {
			throw new DataNotFoundException(19005);
		}
		return county;
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public List<County> getAllCountyByCountryId(long id) {
		return countyRepository.findByCountryId(id);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public CountryOrganizationDTO getCountryById(long countryId) {
		UserDTO userDTO = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDTO.getAuthorization();
		Country country = countryRepository.findByIdAndIsDeleted(countryId, false);
		if (Objects.isNull(country)) {
			throw new DataNotFoundException(19004);
		}
		CountryOrganizationDTO countryOrganizationDTO = new CountryOrganizationDTO();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		countryOrganizationDTO = modelMapper.map(country, new TypeToken<CountryOrganizationDTO>() {
		}.getType());
		System.out.println("UserSelectedTenantContextHolder.get()" + UserSelectedTenantContextHolder.get());
		List<User> users = userApiInterface.getUsersByTenantIds(token, UserSelectedTenantContextHolder.get(),
				List.of(country.getId()));
		countryOrganizationDTO.setUsers(modelMapper.map(users, new TypeToken<List<UserOrganizationDTO>>() {
		}.getType()));
		return countryOrganizationDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public County updateCounty(County county) {
		getCountyById(county.getId());
		County countyDetails = countyRepository.findByCountryIdAndName(county.getCountryId(), county.getName());
		if (!Objects.isNull(countyDetails) && county.getId() != countyDetails.getId()) {
			throw new DataConflictException(19002);
		}
		return countyRepository.save(county);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Subcounty createSubCounty(Subcounty subCounty) {
		if (Objects.isNull(subCounty)) {
			throw new BadRequestException(12006);
		} else {
			Subcounty existingSubCounty = subCountyRepository.findByName(subCounty.getName());
			if (!Objects.isNull(existingSubCounty)) {
				throw new DataConflictException(19003);
			}
			Subcounty subCountyResponse = subCountyRepository.save(subCounty);
			return subCountyResponse;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Subcounty updateSubCounty(Subcounty subCounty) {
		getSubCountyById(subCounty.getId());
		Subcounty subCountyDetails = subCountyRepository.findByCountryIdAndCountyIdAndName(subCounty.getCountryId(),
				subCounty.getCountyId(), subCounty.getName());
		if (!Objects.isNull(subCountyDetails) && subCountyDetails.getId() != subCounty.getId()) {
			throw new DataConflictException(19003);
		}
		return subCountyRepository.save(subCounty);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Subcounty getSubCountyById(long id) {
		Subcounty subCounty = subCountyRepository.findByIdAndIsDeleted(id, false);
		if (Objects.isNull(subCounty)) {
			throw new DataNotFoundException(19006);
		}
		return subCounty;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Subcounty> getAllSubCounty(long countryId, long countyId) {
		return subCountyRepository.getAllSubCounty(countryId, countyId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Subcounty> getAllSubCountyByCountryId(Long countryId) {
		return subCountyRepository.findByCountryId(countryId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getCountryList(RequestDTO requestDTO) {
		String searchTerm = requestDTO.getSearchTerm();
		int totalCount = 0;
		if (0 == requestDTO.getSkip()) {
			totalCount = countryRepository.countByIsDeletedFalse();
		}
		Pageable pageable = Pagination.setPagination(requestDTO.getSkip(), requestDTO.getLimit(), Constants.CREATED_AT,
				Constants.BOOLEAN_FALSE);
		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		List<Country> countries = countryRepository.searchCountries(searchTerm, pageable).stream()
				.collect(Collectors.toList());
		List<CountryListDTO> countryListDTOs = new ArrayList<>();
		UserDTO userDto = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDto.getAuthorization();

		System.out.println("UserSelectedTenantContextHolder.get()" + UserSelectedTenantContextHolder.get());
		if (!countries.isEmpty()) {
			for (Country country : countries) {
				CountryListDTO countryListDTO = new CountryListDTO();
				countryListDTO.setId(country.getId());
				countryListDTO.setName(country.getName());
				countryListDTO.setTenantId(country.getTenantId());
				Map<String, List<Long>> childOrgList = userApiInterface.getChildOrganizations(token,
						UserSelectedTenantContextHolder.get(), UserSelectedTenantContextHolder.get(),
						Constants.COUNTRY);
				countryListDTO.setAccountsCount(childOrgList.get("accountIds").size());
				countryListDTO.setOUCount(childOrgList.get("operatingUnitIds").size());
				countryListDTO.setSiteCount(childOrgList.get("siteIds").size());
				countryListDTOs.add(countryListDTO);
			}
		}
		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, countryListDTOs);
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public Country findCountryById(Long countryId) {
		Country country = countryRepository.findByIdAndIsDeleted(countryId, false);
		if (Objects.isNull(country)) {
			throw new DataNotFoundException(19004);
		}
		return country;
	}

	/**
	 * {@inheritDoc}
	 */
	public User addRegionAdmin(User user) {
		System.out.println("user in data impl" + user);
		Role role = new Role();
		role.setName(Constants.ROLE_REGION_ADMIN);
		user.setRoles(Set.of(role));
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<User> response = userApiInterface.addAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public User updateRegionAdmin(User user) {
		System.out.println("user in data impl" + user);
		UserDTO userDTO = UserContextHolder.getUserDto();
		System.out.println("userDTO____________" + userDTO);
		String token = Constants.BEARER + userDTO.getAuthorization();
		ResponseEntity<User> response = userApiInterface.updateAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean deleteRegionAdmin(CommonRequestDTO requestDTO) {
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<Boolean> response = userApiInterface.deleteAdminUser(token,
				UserSelectedTenantContextHolder.get(), requestDTO);
		return true;
	}
}