package com.yourstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_ID")
	private Integer productId;

	@ManyToOne
	@JoinColumn(name = "Supplier_ID")
	private Supplier supplier;

	@Column(name = "Product_Name", nullable = false)
	private String productName;

	@Column(name = "Size", nullable = false, length = 10)
	private String size;

	@Column(name = "Brand", nullable = false)
	private String brand;

	@Column(name = "Price", nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(name = "Color", nullable = false)
	private String color;

	@Column(name = "Launch_Date", nullable = false)
	private LocalDate launchDate;

	@Column(name = "Description", nullable = false)
	private String description;

	@Column(name = "Is_Active", nullable = false)
	private Boolean isActive;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<StoreInventory> inventory = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ReservedStock> reservedStocks = new HashSet<>();

	@OneToMany(mappedBy = "product")
	private Set<OrderDetails> orderDetails = new HashSet<>();

	@OneToMany(mappedBy = "product")
	private Set<Return> returns = new HashSet<>();

	@OneToMany(mappedBy = "product")
	private Set<SupplyOrder> supplyOrders = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<PriceHistory> priceHistory = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Cart> cartItems = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Wishlist> wishlistItems = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Image> images = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductCategories> productCategories = new HashSet<>();

	@OneToMany(mappedBy = "product")
	private Set<Notification> notifications = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reviews> reviews = new HashSet<>();

	// getters and setters
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<StoreInventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<StoreInventory> inventory) {
		this.inventory = inventory;
	}

	public Set<ReservedStock> getReservedStocks() {
		return reservedStocks;
	}

	public void setReservedStocks(Set<ReservedStock> reservedStocks) {
		this.reservedStocks = reservedStocks;
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

	public Set<SupplyOrder> getSupplyOrders() {
		return supplyOrders;
	}

	public void setSupplyOrders(Set<SupplyOrder> supplyOrders) {
		this.supplyOrders = supplyOrders;
	}

	public Set<PriceHistory> getPriceHistory() {
		return priceHistory;
	}

	public void setPriceHistory(Set<PriceHistory> priceHistory) {
		this.priceHistory = priceHistory;
	}

	public Set<Cart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<Cart> cartItems) {
		this.cartItems = cartItems;
	}

	public Set<Wishlist> getWishlistItems() {
		return wishlistItems;
	}

	public void setWishlistItems(Set<Wishlist> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Set<ProductCategories> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(Set<ProductCategories> productCategories) {
		this.productCategories = productCategories;
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

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((launchDate == null) ? 0 : launchDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((reservedStocks == null) ? 0 : reservedStocks.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		result = prime * result + ((returns == null) ? 0 : returns.hashCode());
		result = prime * result + ((supplyOrders == null) ? 0 : supplyOrders.hashCode());
		result = prime * result + ((priceHistory == null) ? 0 : priceHistory.hashCode());
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		result = prime * result + ((wishlistItems == null) ? 0 : wishlistItems.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((productCategories == null) ? 0 : productCategories.hashCode());
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
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (launchDate == null) {
			if (other.launchDate != null)
				return false;
		} else if (!launchDate.equals(other.launchDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (reservedStocks == null) {
			if (other.reservedStocks != null)
				return false;
		} else if (!reservedStocks.equals(other.reservedStocks))
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
		if (supplyOrders == null) {
			if (other.supplyOrders != null)
				return false;
		} else if (!supplyOrders.equals(other.supplyOrders))
			return false;
		if (priceHistory == null) {
			if (other.priceHistory != null)
				return false;
		} else if (!priceHistory.equals(other.priceHistory))
			return false;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		if (wishlistItems == null) {
			if (other.wishlistItems != null)
				return false;
		} else if (!wishlistItems.equals(other.wishlistItems))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (productCategories == null) {
			if (other.productCategories != null)
				return false;
		} else if (!productCategories.equals(other.productCategories))
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
