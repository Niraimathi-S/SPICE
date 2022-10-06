package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Table(name = TableConstants.TABLE_CUSTOMIZED_MODULES)
@Entity
@Data
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class CustomizedModule extends BaseEntity {
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

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

}
