package com.yourstore.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reserved_Stock")
public class ReservedStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Reservation_ID")
	private Integer reservationId;

	@ManyToOne
	@JoinColumn(name = "Store_ID", nullable = false)
	private Integer storeId;

	@ManyToOne
	@JoinColumn(name = "Product_ID", nullable = false)
	private Integer productId;

	@Column(name = "Quantity", nullable = false)
	private Integer quantity;

	@Column(name = "Reserved_At", nullable = false)
	private Integer reservedAt;

	@Column(name = "Expires_At", nullable = false)
	private LocalDateTime expiresAt;

	//Getters and Setters
	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReservedAt() {
		return reservedAt;
	}

	public void setReservedAt(Integer reservedAt) {
		this.reservedAt = reservedAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reservationId == null) ? 0 : reservationId.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((reservedAt == null) ? 0 : reservedAt.hashCode());
		result = prime * result + ((expiresAt == null) ? 0 : expiresAt.hashCode());
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
		ReservedStock other = (ReservedStock) obj;
		if (reservationId == null) {
			if (other.reservationId != null)
				return false;
		} else if (!reservationId.equals(other.reservationId))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (reservedAt == null) {
			if (other.reservedAt != null)
				return false;
		} else if (!reservedAt.equals(other.reservedAt))
			return false;
		if (expiresAt == null) {
			if (other.expiresAt != null)
				return false;
		} else if (!expiresAt.equals(other.expiresAt))
			return false;
		return true;
	}
}
