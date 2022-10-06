package com.mdtlabs.coreplatform.common.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

@Entity
@Data
@Table(name = TableConstants.TABLE_COUNTY)
public class County extends BaseEntity {

  @NotEmpty(message = ErrorConstants.COUNTY_NAME_NOT_NULL)
  @Column(name = FieldConstants.NAME)
  private String name;

  @Min(value = 1, message = ErrorConstants.DISPLAY_ORDER_MIN_VALUE)
  @NotNull(message = ErrorConstants.DISPLAY_ORDER_NOT_NULL)
  @Column(name = FieldConstants.DISPLAY_ORDER)
  private int displayOrder;
  
  @Column(name = FieldConstants.COUNTRY_ID)
  private Long countryId;

}
