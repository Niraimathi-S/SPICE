package com.mdtlabs.coreplatform.spiceadminservice.lab.test.result.ranges.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataNotAcceptableException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.logger.SpiceLogger;
import com.mdtlabs.coreplatform.common.model.dto.spice.LabTestResultRangeDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.LabTestResultRangeRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResult;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResultRange;
import com.mdtlabs.coreplatform.spiceadminservice.lab.test.repository.LabTestResultRepository;
import com.mdtlabs.coreplatform.spiceadminservice.lab.test.result.ranges.repository.LabTestResultRangesRepository;
import com.mdtlabs.coreplatform.spiceadminservice.lab.test.result.ranges.service.LabTestResultRangesService;


/**
 * This service maintains the CRUD operations for Lab test result range.
 *
 * @author Jeyaharini T A
 */
@Service
public class LabTestResultRangesServiceImpl implements LabTestResultRangesService {

	@Autowired
	private LabTestResultRangesRepository repository;

	@Autowired
	private LabTestResultRepository resultRepository;

	ModelMapper modelMapper = new ModelMapper();

	/**
	 * {@inheritDoc}
	 */
	public List<LabTestResultRange> addLabTestResultRanges(
		LabTestResultRangeRequestDTO labTestResultRangeRequestDto) {

		if (Objects.isNull(labTestResultRangeRequestDto)
			|| labTestResultRangeRequestDto.getLabTestResultRanges().isEmpty()) {
			throw new BadRequestException(12006);
		}

		if (Objects.isNull(labTestResultRangeRequestDto.getLabTestResultId())) {
			throw new BadRequestException(28008);
		}

		LabTestResult labTestResult = resultRepository
			.findByIdAndIsDeleted(labTestResultRangeRequestDto.getLabTestResultId(), false);

		if (Objects.isNull(labTestResult)) {
			throw new DataNotAcceptableException(28010);
		}

		List<LabTestResultRange> listOfLabTestResultRangesToSave = new ArrayList<>();

		List<LabTestResultRangeDTO> labTestResultRanges = labTestResultRangeRequestDto
			.getLabTestResultRanges();
		SpiceLogger.logInfo("labTestResultRanges: " + labTestResultRanges);
		for (int i = 0; i < labTestResultRanges.size(); i++) {
			LabTestResultRange labTestResultRangeEntity = new LabTestResultRange();
			labTestResultRangeEntity.setTenantId(labTestResultRangeRequestDto.getTenantId());
			labTestResultRangeEntity.setLabTestId(labTestResult.getLabTestId());
			labTestResultRangeEntity.setLabTestResultId(labTestResult.getId());
			LabTestResultRangeDTO labTestResultRangeDto = labTestResultRanges.get(i);
			if (!Objects.isNull(labTestResultRangeDto.getMinimumValue())) {
				labTestResultRangeEntity.setMinimumValue(labTestResultRangeDto.getMinimumValue());
			}
			if (!Objects.isNull(labTestResultRangeDto.getMaximumValue())) {
				labTestResultRangeEntity.setMaximumValue(labTestResultRangeDto.getMaximumValue());
			}
			if (!Objects.isNull(labTestResultRangeDto.getDisplayName())) {
				labTestResultRangeEntity.setDisplayName(labTestResultRangeDto.getDisplayName());
			}
			if (!Objects.isNull(labTestResultRangeDto.getDisplayOrder())) {
				labTestResultRangeEntity.setDisplayOrder(labTestResultRangeDto.getDisplayOrder());
			}
			if (!Objects.isNull(labTestResultRangeDto.getUnit())) {
				labTestResultRangeEntity.setUnit(labTestResultRangeDto.getUnit());
			}
			if (!Objects.isNull(labTestResultRangeDto.getUnitId())) {
				labTestResultRangeEntity.setUnitId(labTestResultRangeDto.getUnitId());
			}
			listOfLabTestResultRangesToSave.add(labTestResultRangeEntity);
		}
		return repository.saveAll(listOfLabTestResultRangesToSave);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<LabTestResultRange> updateLabTestResultRanges(
		LabTestResultRangeRequestDTO labTestResultRangeRequestDto) {

		if (Objects.isNull(labTestResultRangeRequestDto)) {
			throw new BadRequestException(12006);
		}

		SpiceLogger.logInfo(
			"Updating lab test result ranges for result id: " 
			+ labTestResultRangeRequestDto.getLabTestResultId());

		List<LabTestResultRangeDTO> labTestResultRangeList = labTestResultRangeRequestDto
			.getLabTestResultRanges();

		if (Objects.isNull(labTestResultRangeList) || labTestResultRangeList.isEmpty()) {
			throw new BadRequestException(12006);
		}

		List<Long> labTestResultRangeIds = labTestResultRangeList.stream()
			.map(labTestResultRange -> labTestResultRange.getId()).collect(Collectors.toList());

		List<LabTestResultRange> existingLabTestResultRangesList = repository
			.findByIdsAndIsDeleted(labTestResultRangeIds, false);

		List<LabTestResultRange> labTestResultRangesToUpdate = new ArrayList<>();

		if (Objects.isNull(existingLabTestResultRangesList) || existingLabTestResultRangesList.isEmpty()
			|| existingLabTestResultRangesList.size() != labTestResultRangeList.size()) {
			throw new DataNotFoundException(28006);
		}

		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		long labTestId = 0;
		long labTestResultId = 0;
		for (int i = 0; i < labTestResultRangeList.size(); i++) {
			LabTestResultRangeDTO labTestResultRangeDto = labTestResultRangeList.get(i);
			LabTestResultRange existingLabTestResultRangeEntity = existingLabTestResultRangesList
				.stream().filter(existingLabTestResultRange -> (existingLabTestResultRange.getId() 
				== labTestResultRangeDto.getId())).findFirst().orElseThrow(() -> 
			new DataNotFoundException(28006));
			if (i == 0) {
				labTestId = existingLabTestResultRangeEntity.getLabTestId();
				labTestResultId = existingLabTestResultRangeEntity.getLabTestResultId();
			}
			modelMapper.map(labTestResultRangeDto, existingLabTestResultRangeEntity);
			existingLabTestResultRangeEntity.setLabTestId(labTestId);
			existingLabTestResultRangeEntity.setLabTestResultId(labTestResultId);
			existingLabTestResultRangeEntity.setId(labTestResultRangeDto.getId());
			labTestResultRangesToUpdate.add(existingLabTestResultRangeEntity);
		}

		return repository.saveAll(labTestResultRangesToUpdate);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean removeLabTestResultRange(long id) {
		repository.removeLabTestResultRange(id, true);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<LabTestResultRange> getLabTestResultRange(long labTestResultId) {

		List<LabTestResultRange> labTestResultRangeList = repository
			.findByLabTestResultIdAndIsDeleted(labTestResultId, false);
		return labTestResultRangeList;
	}
}
