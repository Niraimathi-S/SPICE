package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class ReviewerDetailsDTO {
    
    private String firstName;

    private String lastName;

    private String userName;

    public ReviewerDetailsDTO(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public ReviewerDetailsDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ReviewerDetailsDTO() {
    }

    
    

}
