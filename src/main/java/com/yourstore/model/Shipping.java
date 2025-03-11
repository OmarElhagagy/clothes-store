package com.yourstore.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Shipping")
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Shipping_ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "Order_ID", nullable = false)
	private CustomerOrder order;

	@Column(name = "Tracking_Number")
	private String trackingNumber;

	@Column(name = "Shipping_Provider")
	private String shippingProvider;

	@Column(name = "Shipped_Date")
	private LocalDateTime shippedDate;

	@Column(name = "Delivered_Date")
	private LocalDateTime deliveredDate;

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getShippingProvider() {
		return shippingProvider;
	}

	public void setShippingProvider(String shippingProvider) {
		this.shippingProvider = shippingProvider;
	}

	public LocalDateTime getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDateTime shippedDate) {
		this.shippedDate = shippedDate;
	}

	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((trackingNumber == null) ? 0 : trackingNumber.hashCode());
		result = prime * result + ((shippingProvider == null) ? 0 : shippingProvider.hashCode());
		result = prime * result + ((shippedDate == null) ? 0 : shippedDate.hashCode());
		result = prime * result + ((deliveredDate == null) ? 0 : deliveredDate.hashCode());
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
		Shipping other = (Shipping) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (trackingNumber == null) {
			if (other.trackingNumber != null)
				return false;
		} else if (!trackingNumber.equals(other.trackingNumber))
			return false;
		if (shippingProvider == null) {
			if (other.shippingProvider != null)
				return false;
		} else if (!shippingProvider.equals(other.shippingProvider))
			return false;
		if (shippedDate == null) {
			if (other.shippedDate != null)
				return false;
		} else if (!shippedDate.equals(other.shippedDate))
			return false;
		if (deliveredDate == null) {
			if (other.deliveredDate != null)
				return false;
		} else if (!deliveredDate.equals(other.deliveredDate))
			return false;
		return true;
	}
}
