package com.yourstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Promotions")
public class Promotions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Promotion_ID")
	private Integer promotionId;

	@Column(name = "Code", unique = true)
	private String code;

	@Column(name = "Description", nullable = false)
	private String description;

	@Column(name = "Discount_Percentage", precision = 5, scale = 2)
	private BigDecimal discountPercentage;

	@Column(name = "Discount_Amount", precision = 10, scale = 2)
	private BigDecimal discountAmount;

	@Column(name = "Start_Date", nullable = false)
	private LocalDate startDate;

	@Column(name = "End_Date", nullable = false)
	private LocalDate endDate;

	@Column(name = "Is_Active", nullable = false)
	private boolean isActive = true;

	@Column(name = "Max_Uses")
	private Integer maxUses;

	// getters and setters
	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getMaxUses() {
		return maxUses;
	}

	public void setMaxUses(Integer maxUses) {
		this.maxUses = maxUses;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((promotionId == null) ? 0 : promotionId.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((discountPercentage == null) ? 0 : discountPercentage.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((maxUses == null) ? 0 : maxUses.hashCode());
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
		Promotions other = (Promotions) obj;
		if (promotionId == null) {
			if (other.promotionId != null)
				return false;
		} else if (!promotionId.equals(other.promotionId))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountPercentage == null) {
			if (other.discountPercentage != null)
				return false;
		} else if (!discountPercentage.equals(other.discountPercentage))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (isActive != other.isActive)
			return false;
		if (maxUses == null) {
			if (other.maxUses != null)
				return false;
		} else if (!maxUses.equals(other.maxUses))
			return false;
		return true;
	}
}
