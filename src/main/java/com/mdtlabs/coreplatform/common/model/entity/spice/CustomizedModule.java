package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

@Table(name = TableConstants.TABLE_CUSTOMIZED_MODULES)
@Entity
@Data
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class CustomizedModule extends TenantBaseEntity {
	
    private static final long serialVersionUID = 1L;

	@NotNull
    @Column(name = FieldConstants.MODULE_VALUE, columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Map<String, Object> moduleValue;

    @NotBlank
    @Column(name = FieldConstants.SCREEN_TYPE)
    private String screenType;

    @NotNull
    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    // @Min(1)
    @Column(name = FieldConstants.CLINICAL_WORFKLOW_ID)
    private Long clinicalworkflowId;

}
