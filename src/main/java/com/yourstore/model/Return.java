package com.yourstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Return")
public class Return {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Return_ID")
	private Integer returnId;

	@ManyToOne
	@JoinColumn(name = "Order_ID", nullable = false)
	private CustomerOrder order; 

	@ManyToOne
	@JoinColumn(name = "Product_ID", nullable = false)
	private Product product;

	@Column(name = "Refunded_Amount", nullable = false)
	private BigDecimal refundedAmount;

	@Column(name = "Quantity_Returned", nullable = false)
	private Integer quantityReturned;

	@Column(name = "Reason", nullable = false)
	private String reason;

	@Column(name = "Return_Date", nullable = false)
	private LocalDate returnDate;

	// Getters and Setters
	public Integer getReturnId() {
		return returnId;
	}

	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getRefundedAmount() {
		return refundedAmount;
	}

	public void setRefundedAmount(BigDecimal refundedAmount) {
		this.refundedAmount = refundedAmount;
	}

	public Integer getQuantityReturned() {
		return quantityReturned;
	}

	public void setQuantityReturned(Integer quantityReturned) {
		this.quantityReturned = quantityReturned;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((returnId == null) ? 0 : returnId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((refundedAmount == null) ? 0 : refundedAmount.hashCode());
		result = prime * result + ((quantityReturned == null) ? 0 : quantityReturned.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
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
		Return other = (Return) obj;
		if (returnId == null) {
			if (other.returnId != null)
				return false;
		} else if (!returnId.equals(other.returnId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (refundedAmount == null) {
			if (other.refundedAmount != null)
				return false;
		} else if (!refundedAmount.equals(other.refundedAmount))
			return false;
		if (quantityReturned == null) {
			if (other.quantityReturned != null)
				return false;
		} else if (!quantityReturned.equals(other.quantityReturned))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}
}
