package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.TABLE_FREQUENCY)
public class Frequency extends BaseEntity {

  @Column(name = FieldConstants.NAME)
  private String name;

  @Column(name = FieldConstants.TYPE)
  private String type;

  @Column(name = FieldConstants.DURATION)
  private Integer duration;

  @Column(name = FieldConstants.PERIOD)
  private String period;

  @Column(name = FieldConstants.RISK_LEVEL)
  private String riskLevel;

  @Column(name = FieldConstants.TITLE)
  private String title;

  @Column(name = FieldConstants.DISPLAY_ORDER)
  private Integer displayOrder;
}
