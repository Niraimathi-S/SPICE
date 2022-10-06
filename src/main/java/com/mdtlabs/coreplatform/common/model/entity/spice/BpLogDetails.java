package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
// @Table(name = TableConstants.TABLE_BP_LOG_DETAILS)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BpLogDetails implements Serializable{
    
    @NotNull
    private Integer systolic;

    @NotNull
    private Integer diastolic;

    private Integer pulse;

    public BpLogDetails(@NotNull Integer systolic, @NotNull Integer diastolic, Integer pulse) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
    }

    public BpLogDetails() {}



}
