package com.yourstore.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Wishlist")
public class Wishlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Wishlist_ID")
	private Integer wishlistId;

	@ManyToOne
	@JoinColumn(name = "Customer_ID", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "Product_ID", nullable = false)
	private Product product;

	@Column(name = "Added_Date", nullable = false)
	private LocalDate addedDate;

	// getters and setters
	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wishlistId == null) ? 0 : wishlistId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((addedDate == null) ? 0 : addedDate.hashCode());
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
		Wishlist other = (Wishlist) obj;
		if (wishlistId == null) {
			if (other.wishlistId != null)
				return false;
		} else if (!wishlistId.equals(other.wishlistId))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (addedDate == null) {
			if (other.addedDate != null)
				return false;
		} else if (!addedDate.equals(other.addedDate))
			return false;
		return true;
	}
}
