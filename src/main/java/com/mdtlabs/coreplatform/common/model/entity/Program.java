package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PROGRAM)
public class Program extends BaseEntity {

	@NotEmpty(message = ErrorConstants.PROGRAM_NAME_NOT_EMPTY)
	@Column(name = FieldConstants.NAME)
	private String name;

    @NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @NotNull(message = ErrorConstants.TENANT_ID_NOT_NULL)
    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

}
