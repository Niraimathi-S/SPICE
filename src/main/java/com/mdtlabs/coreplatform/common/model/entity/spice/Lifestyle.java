package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;

import java.util.List;
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


@Data
@Entity
@Table(name = TableConstants.TABLE_LIFESTYLE)
@TypeDef(
	name = "jsonb",
	typeClass = JsonBinaryType.class
)
public class Lifestyle extends BaseEntity {

    @Column(name = FieldConstants.NAME)
    private String name;

    @Column(name = FieldConstants.TYPE)
    private String type;

    @Type(type = "jsonb")
    @Column(name = FieldConstants.ANSWERS, columnDefinition = "jsonb")
    private List<Map<String, Object>> answers;

    @Column(name = FieldConstants.IS_ANSWER_DEPENDENT)
    private boolean isAnswerDependent;

    @Column(name = FieldConstants.DISPLAY_ORDER)
    private int displayOrder;

}
