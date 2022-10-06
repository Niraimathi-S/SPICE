package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;


@Data
@Entity
@Table(name = TableConstants.TABLE_NUTRITION_LIFESTYLE)
public class NutritionLifestyle extends BaseEntity {

    @Column(name = FieldConstants.NAME)
    private String name;

    @Column(name = FieldConstants.DISPLAY_ORDER)
    private Integer displayOrder;
}