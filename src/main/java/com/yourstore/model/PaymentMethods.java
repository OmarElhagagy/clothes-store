package com.yourstore.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Payment_Methods")
public class PaymentMethods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Payment_Method_ID")
	private Integer paymentMethodId;

	@Column(name = "Method_Name", nullable = false, unique = true)
	private String methodName;

	@OneToMany(mappedBy = "paymentMethod")
	private Set<CustomerOrder> orders = new HashSet<>();

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Set<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustomerOrder> orders) {
		this.orders = orders;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentMethodId == null) ? 0 : paymentMethodId.hashCode());
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
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
		PaymentMethods other = (PaymentMethods) obj;
		if (paymentMethodId == null) {
			if (other.paymentMethodId != null)
				return false;
		} else if (!paymentMethodId.equals(other.paymentMethodId))
			return false;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		return true;
	}
}
