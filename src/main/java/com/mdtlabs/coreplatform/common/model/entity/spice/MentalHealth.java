package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_MENTAL_HEALTH)
@TypeDef(
	name = "jsonb",
	typeClass = JsonBinaryType.class
)
public class MentalHealth extends TenantBaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.IS_LATEST)
    private boolean isLatest;

    @Column(name = FieldConstants.PHQ9_RISK_LEVEL)
    private String phq9RiskLevel;

    @Column(name = FieldConstants.PHQ9_SCORE)
    private int phq9Score;

    @Column(name = FieldConstants.GAD7_RISK_LEVEL)
    private String gad7RiskLevel;

    // @JsonIgnore
    @Column(name = FieldConstants.GAD7_SCORE)
    private int gad7Score;

    @Column(name = FieldConstants.PHQ4_RISK_LEVEL)
    private String phq4RiskLevel;

    @Column(name = FieldConstants.PHQ4_SCORE)
    private int phq4Score;
    
    @Column(name = FieldConstants.PHQ4_FIRST_SCORE)
    private int phq4FirstScore;

    @Column(name = FieldConstants.PHQ4_SECOND_SCORE)
    private int phq4SecondScore;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Type(type = "jsonb")
    @Column(name = FieldConstants.PHQ9_MENTAL_HEALTH, columnDefinition = "jsonb")
    private List<MentalHealthDetails> phq9MentalHealth;

    @Type(type = "jsonb")
    @Column(name = FieldConstants.GAD7_MENTAL_HEALTH, columnDefinition = "jsonb")
    private List<MentalHealthDetails> gad7MentalHealth;

    @Type(type = "jsonb")
    @Column(name = FieldConstants.PHQ4_MENTAL_HEALTH, columnDefinition = "jsonb")
    private List<MentalHealthDetails> phq4MentalHealth;

}
