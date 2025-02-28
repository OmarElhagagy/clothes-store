package com.yourstore.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "\"Customer\"")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_ID")
	private Integer customerId;

	@Column(name = "F_Name", nullable = false)
	private String firstName;

	@Column(name = "M_Name", nullable = false)
	private String middleName;

	@Column(name = "L_Name", nullable = false)
	private String lastName;

	@Column(name = "Gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "Birth_Date", nullable = false)
	private LocalDate birthDate;

	@Email
	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Users> users = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(mappedBy = "customer")
	private Set<CustomerOrder> orders = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Cart> cartItems = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<WishList> whishListItmes = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<PhoneNumbersCustomers> phoneNumbers = new HashSet<>();

	@OneToMany(mappedBy = "customer")
	private Set<Notifications> notifications = new HashSet<>();

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustomerOrder> orders) {
		this.orders = orders;
	}

	public Set<Cart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<Cart> cartItems) {
		this.cartItems = cartItems;
	}

	public Set<WishList> getWhishListItmes() {
		return whishListItmes;
	}

	public void setWhishListItmes(Set<WishList> whishListItmes) {
		this.whishListItmes = whishListItmes;
	}

	public Set<PhoneNumbersCustomers> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumbersCustomers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notifications> notifications) {
		this.notifications = notifications;
	}
}
