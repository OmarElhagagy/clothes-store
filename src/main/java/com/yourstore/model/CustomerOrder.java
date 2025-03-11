package com.yourstore.model;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_Order")
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_ID")
	private Integer orderId;

	@ManyToOne
	@JoinColumn(name = "Employee_Seller_ID", nullable = false)
	private Employee employeeSellerId;

	@ManyToOne
	@JoinColumn(name = "Customer_ID", nullable = false)
	private Customer customerId;

	@ManyToOne
	@JoinColumn(name = "Payment_Method_ID", nullable = false)
	private PaymentMethods paymentMethodId;

	@ManyToOne
	@JoinColumn(name = "Address_ID", nullable = false)
	private Address addressId;

	@ManyToOne
	@JoinColumn(name = "Promotion_ID", nullable = false)
	private Promotions promotionsId;

	@OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
	private Set<OrderDetails> orderDetails = new HashSet<>();

	@OneToMany(mappedBy = "Return", cascade = CascadeType.ALL)
	private Set<Return> returns = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Shipping shipping;

	// getters and setters
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Employee getEmployeeSellerId() {
		return employeeSellerId;
	}

	public void setEmployeeSellerId(Employee employeeSellerId) {
		this.employeeSellerId = employeeSellerId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public PaymentMethods getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(PaymentMethods paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public Promotions getPromotionsId() {
		return promotionsId;
	}

	public void setPromotionsId(Promotions promotionsId) {
		this.promotionsId = promotionsId;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<Return> getReturns() {
		return returns;
	}

	public void setReturns(Set<Return> returns) {
		this.returns = returns;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((employeeSellerId == null) ? 0 : employeeSellerId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((paymentMethodId == null) ? 0 : paymentMethodId.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((promotionsId == null) ? 0 : promotionsId.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		result = prime * result + ((returns == null) ? 0 : returns.hashCode());
		result = prime * result + ((shipping == null) ? 0 : shipping.hashCode());
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
		CustomerOrder other = (CustomerOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (employeeSellerId == null) {
			if (other.employeeSellerId != null)
				return false;
		} else if (!employeeSellerId.equals(other.employeeSellerId))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (paymentMethodId == null) {
			if (other.paymentMethodId != null)
				return false;
		} else if (!paymentMethodId.equals(other.paymentMethodId))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (promotionsId == null) {
			if (other.promotionsId != null)
				return false;
		} else if (!promotionsId.equals(other.promotionsId))
			return false;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		if (returns == null) {
			if (other.returns != null)
				return false;
		} else if (!returns.equals(other.returns))
			return false;
		if (shipping == null) {
			if (other.shipping != null)
				return false;
		} else if (!shipping.equals(other.shipping))
			return false;
		return true;
	}
}
