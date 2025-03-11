package com.yourstore.model;

import java.time.LocalDate;
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

@Entity
@Table(name = "Customer")
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
	private Set<Wishlist> whishListItmes = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<PhoneNumbersCustomers> phoneNumbers = new HashSet<>();

	@OneToMany(mappedBy = "customer")
	private Set<Notification> notifications = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reviews> reviews = new HashSet<>();

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

	public Set<Wishlist> getWhishListItmes() {
		return whishListItmes;
	}

	public void setWhishListItmes(Set<Wishlist> whishListItmes) {
		this.whishListItmes = whishListItmes;
	}

	public Set<PhoneNumbersCustomers> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumbersCustomers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		result = prime * result + ((whishListItmes == null) ? 0 : whishListItmes.hashCode());
		result = prime * result + ((phoneNumbers == null) ? 0 : phoneNumbers.hashCode());
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		if (whishListItmes == null) {
			if (other.whishListItmes != null)
				return false;
		} else if (!whishListItmes.equals(other.whishListItmes))
			return false;
		if (phoneNumbers == null) {
			if (other.phoneNumbers != null)
				return false;
		} else if (!phoneNumbers.equals(other.phoneNumbers))
			return false;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}
}
