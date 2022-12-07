package com.mdtlabs.coreplatform.common.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mdtlabs.coreplatform.common.CustomAuthorityDeserializer;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

/**
 * <p>
 * User access permission for an employee is used to authorize to handle read
 * and write.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_USER)
public class User extends BaseEntity implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.FIRST_NAME)
    private String firstName;

    @Column(name = FieldConstants.MIDDLE_NAME)
    private String middleName;

    @Column(name = FieldConstants.LAST_NAME)
    private String lastName;

    @Column(name = FieldConstants.GENDER)
    private String gender;
    
    @Column(name = FieldConstants.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = FieldConstants.ADDRESS)
    private String address;

    @Column(name = FieldConstants.USERNAME)
    private String username;

    @ColumnTransformer(forColumn = FieldConstants.PASSWORD, read = "public.pgp_sym_decrypt(password::bytea, " + "'"
			+ FieldConstants.TELECOUNSELOR + "'"
			+ ")", write = "public.pgp_sym_encrypt(?, " + "'" + FieldConstants.TELECOUNSELOR + "'" + ")")
	@Column(name = FieldConstants.PASSWORD, columnDefinition = "bytea", nullable = false)
    private String password;
    
    @Column(name = FieldConstants.COUNTRY_CODE)
    private String countryCode;

    @Column(name = FieldConstants.IS_BLOCKED)
	private Boolean isBlocked;

    @Column(name = FieldConstants.BLOCKED_DATE, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date blockedDate;

    @Column(name = FieldConstants.FORGET_PASSWORD_TOKEN)
	private String forgetPasswordToken;

    @Column(name = FieldConstants.FORGET_PASSWORD_TIME, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date forgetPasswordTime;

    @Column(name = FieldConstants.FORGET_PASSWORD_COUNT)
	private int forgetPasswordCount;

    @Column(name = FieldConstants.INVALID_LOGIN_TIME, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date invalidLoginTime;

	@Column(name = FieldConstants.INVALID_LOGIN_ATTEMPTS)
	private int invalidLoginAttempts;

    @Column(name = FieldConstants.INVALID_RESET_TIME, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date invalidResetTime;

	@Column(name = FieldConstants.IS_PASSWORD_RESET_ENABLED)
    private Boolean isPasswordResetEnabled;

	@Column(name = FieldConstants.PASSWORD_RESET_ATTEMPTS)
    private int passwordResetAttempts;

	@Column(name = FieldConstants.IS_LICENSE_ACCEPTANCE)
    private boolean isLicenseAcceptance = false;

	@Column(name = FieldConstants.LAST_LOGGED_IN)
    private Date lastLoggedIn;

	@Column(name = FieldConstants.LAST_LOGGED_OUT)
    private Date lastLoggedOut;

    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @ManyToOne
    @JoinColumn(name = FieldConstants.TIMEZONE_ID)
    private Timezone timezoneId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_USER_ROLE, joinColumns = {
			@JoinColumn(name = FieldConstants.USER_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.ROLE_ID) })
	private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_USER_ORGANIZATION, joinColumns = {
			@JoinColumn(name = FieldConstants.USER_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.ORGANIZATION_ID) })
    private Set<Organization>  organizations;

	@Override
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	// @Column(name = FieldConstants.IS_ACTIVE, columnDefinition = "TINYINT(1)")
	// private Boolean isActive;

	@Override
	public boolean isEnabled() {
		return super.isActive();
	}

	public void setEnabled(boolean isActive) {
		super.setActive(isActive);
		// this.isActive = isActive;
	}

	/**
	 * Default Constructor for User Entity
	 */
	public User() {

	}

	@Override
	@Transient
	@JsonDeserialize(using = CustomAuthorityDeserializer.class)
	public Set<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new LinkedHashSet<>();
		authorities.addAll((Collection<? extends GrantedAuthority>) roles);
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

}
