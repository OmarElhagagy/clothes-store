package com.yourstore.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private Integer userId;

	@ManyToOne
	@JoinColumn(name = "Customer_ID", nullable = false)
	private Customer customer;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@Column(name = "Password_Hash", nullable = false)
	private String passwordHash;

	@Column(name = "Role", nullable = false)
	private String role;

	@Column(name = "Failed_Logins", nullable = false)
	private Integer failedLogins;

	@Column(name = "Locked_Until")
	private LocalDateTime lockedUntil;

	@Column(name = "Created_At", nullable = false)
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Sessions> sessions = new HashSet<>();

	@OneToMany(mappedBy = "user")
	private Set<AuditLog> auditLogs = new HashSet<>();

	// getters and setters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getFailedLogins() {
		return failedLogins;
	}

	public void setFailedLogins(Integer failedLogins) {
		this.failedLogins = failedLogins;
	}

	public LocalDateTime getLockedUntil() {
		return lockedUntil;
	}

	public void setLockedUntil(LocalDateTime lockedUntil) {
		this.lockedUntil = lockedUntil;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Sessions> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Sessions> sessions) {
		this.sessions = sessions;
	}

	public Set<AuditLog> getAuditLogs() {
		return auditLogs;
	}

	public void setAuditLogs(Set<AuditLog> auditLogs) {
		this.auditLogs = auditLogs;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((failedLogins == null) ? 0 : failedLogins.hashCode());
		result = prime * result + ((lockedUntil == null) ? 0 : lockedUntil.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((auditLogs == null) ? 0 : auditLogs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (passwordHash == null) {
			if (other.passwordHash != null)
				return false;
		} else if (!passwordHash.equals(other.passwordHash))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (failedLogins == null) {
			if (other.failedLogins != null)
				return false;
		} else if (!failedLogins.equals(other.failedLogins))
			return false;
		if (lockedUntil == null) {
			if (other.lockedUntil != null)
				return false;
		} else if (!lockedUntil.equals(other.lockedUntil))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (auditLogs == null) {
			if (other.auditLogs != null)
				return false;
		} else if (!auditLogs.equals(other.auditLogs))
			return false;
		return true;
	}
}
