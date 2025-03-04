package com.yourstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
}
