package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_OUTBOUND_EMAIL)
public class OutBoundEmail implements Serializable {
    
    private static final long serialVersionUID = 4174505913611242103L;

	@Id
	@Column(name = FieldConstants.ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
	@Column(name = FieldConstants.CREATED_AT, columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = FieldConstants.MODIFIED_AT, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.FORM_DATA_ID)
    private Long formDataId;

    @Column(name = FieldConstants.IS_PROCESSED)
    private boolean isProcessed;

    @Column(name = FieldConstants.RETRY_ATTEMPTS)
    private int retryAttempts;

    @Column(name = FieldConstants.FORM_NAME)
    private String formName;

    @Column(name = FieldConstants.TO)
    private String to;

    @Column(name = FieldConstants.TYPE)
    private String type;

    @Column(name = FieldConstants.SUBJECT)
    private String subject;

    @Column(name = FieldConstants.BODY)
    private String body;

    @Column(name = FieldConstants.CC)
    private String cc;

    @Column(name = FieldConstants.BCC)
    private String bcc;
}

/* "_id", 
        "is_deleted", 
        "expires", 
       
       
     
        
        */