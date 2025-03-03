package com.yourstore.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sessions")
public class Sessions {
	@Id
	@Column(name = "Session_ID", length = 128)
	private String sessionId;

	@ManyToOne
	@JoinColumn(name = "User_ID", nullable = false)
	private Users user;

	@Column(name = "Created_At", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "Expires_At", nullable = false)
	private LocalDateTime expiresAt;

	// Getters and Setters
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}
}
