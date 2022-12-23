package com.mdtlabs.coreplatform.spiceadminservice.labtest.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTest;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResult;

/**
 * <p>
 * This an interface class for lab test module you can implemented this class in any
 * class.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 */
public interface LabTestService {

    /**
     * This method is used to add a new Labtest.
     *
     * @param labTest - lab test entity
     * @return Labtest Entity
     * @author Niraimathi S
     */
    public LabTest addLabTest(LabTest labTest);

    /**
     * Used to retrieve list of all LabTests in a country.
     *
     * @param requestDto - entity
     * @return List of LabTest entities.
     * @author Niraimathi S
     */
    public List<LabTest> getAllLabTests(RequestDTO requestDto);

    /**
     * This method is used to search labtests using labtest name.
     *
     * @param requestDto entity
     * @return list of LabTest entities.
     * @author Niraimathi S
     */
    public List<Map> searchLabTests(RequestDTO requestDto);

    /**
     * This method is used to update the status of a labtest which is soft deleted.
     *
     * @param status - status
     * @param requestDto - entity
     * @return Boolean - true or false
     * @author Karthick M
     */
    public boolean removeLabTest(RequestDTO requestDto, boolean status);

    /**
     * This method is used to update a labTest details like name.
     *
     * @param labTest entity
     * @return labTest Entity
     * @author Karthick M
     */
    public LabTest updateLabTest(LabTest labTest);

    /**
     * This method retrieves a single labtest's details.
     *
     * @param requestDto Request object containing labtest id.
     * @return Medication Entity
     */
    public LabTest getLabTestById(RequestDTO requestDto);

    /**
     * Used to validate labtest details.
     *
     * @param labTest - entity
     * @return boolean - true or false
     * @author Karthick M
     */
    public Boolean validateLabTest(LabTest labTest);

    /**
     * This method retrieves a single labtest results details.
     *
     * @param labTestId - lab test id
     * @return List - lab test result list
     * @author Karthick M
     */
    public List<LabTestResult> getLabTestResultsById(long labTestId);

    /**
     * Returns LabTest based on name and country id and returns a single labtest.
     *
     * @param searchTerm - search term
     * @param countryId - country id
     * @return LabTest entity
     * @author Niraimathi S
     */
    public LabTest getLabTestbyName(String searchTerm, long countryId);

    /**
     * Returns List of labtest found using list of labtest IDs.
     *
     * @param uniqueLabTestIds - set of unique lab test ids
     * @return List of LabTest entities
     * @author Niraimathi S
     */
    public List<LabTest> getLabTestsById(Set<Long> uniqueLabTestIds);

}
