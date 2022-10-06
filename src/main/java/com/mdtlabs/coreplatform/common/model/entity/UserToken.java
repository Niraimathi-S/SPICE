package com.mdtlabs.coreplatform.common.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * User access permission for an employee is used to authorize to handle read
 * and write.
 * </p>
 * 
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_USER_TOKEN)
public class UserToken extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.USER_ID)
	private Long userId;

	@Column(name = FieldConstants.AUTH_TOKEN)
	private String authToken;

	@Column(name = FieldConstants.REFRESH_TOKEN)
	private String refreshToken;

	// @Column(name = FieldConstants.LAST_SESSION_TIME, columnDefinition = "TIMESTAMP")
	// @UpdateTimestamp
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonSerialize(using = CustomDateSerializer.class)
	// private Date lastSessionTime;
}