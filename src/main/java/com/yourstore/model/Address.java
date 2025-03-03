package com.yourstore.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Address_ID")
	private Integer addressId;

	@ManyToOne
	@JoinColumn(name = "Customer_ID", nullable = false)
	private Customer customer;

	@Column(name = "Street", nullable = false)
	private String street;

	@Column(name = "City", nullable = false)
	private String city;

	@Column(name = "State")
	private String state;

	@Column(name = "Postal_Code", nullable = false)
	private String postalCode;

	@Column(name = "Country", nullable = false)
	private String country;

	@Column(name = "Is_Default", nullable = false)
	private Boolean isDefault;

	@OneToMany(mappedBy = "address")
	private Set<CustomerOrder> orders = new HashSet<>();

	// Getters and Setters
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Set<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustomerOrder> orders) {
		this.orders = orders;
	}
}
