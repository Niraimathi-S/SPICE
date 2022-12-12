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
@Table(name = TableConstants.TABLE_RISK_ALGORITHM)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class RiskAlgorithm extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.RISK_ALGORITHM, columnDefinition = "jsonb")
	@Type(type = "jsonb")
	private Map<String, Object> riskAlgorithm;

	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

}
