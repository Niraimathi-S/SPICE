package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_CULTURE)
public class Culture extends BaseEntity {
    
    @Column(name = FieldConstants.NAME)
    private String name;

    @Column(name = FieldConstants.CODE)
    private String code;
}
