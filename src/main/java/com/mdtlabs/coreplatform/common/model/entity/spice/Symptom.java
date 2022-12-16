package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_SYMPTOM)
@TypeDef(
	name = "jsonb",
	typeClass = JsonBinaryType.class
)
public class Symptom extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.NAME)
    private String name;

    @Column(name = FieldConstants.DESCRIPTION)
    private String description;

    @Column(name = FieldConstants.TYPE)
    private String type;

    @Column(name = FieldConstants.DISPLAY_ORDER)
    private int displayOrder;
    
    @Column(name = FieldConstants.CATEGORIES, columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Map<String, Boolean> categories;
}
