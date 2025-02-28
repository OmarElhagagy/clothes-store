CREATE TABLE "Store" (
  "Store_ID" SERIAL PRIMARY KEY,
  "Address" VARCHAR(255) NOT NULL,
  "Email" VARCHAR(255) UNIQUE NOT NULL,
  "Min_Stock" INT NOT NULL CHECK ("Min_Stock" >= 0)
);

CREATE TABLE "Supplier" (
  "Supplier_ID" SERIAL PRIMARY KEY,
  "Supplier_Name" VARCHAR(100) NOT NULL,
  "Email" VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE "Customer" (
  "Customer_ID" SERIAL PRIMARY KEY,
  "F_Name" VARCHAR(50) NOT NULL,
  "M_Name" VARCHAR(50),
  "L_Name" VARCHAR(50) NOT NULL,
  "Gender" CHAR(1) NOT NULL CHECK ("Gender" IN ('M', 'F', 'O')),
  "Birth_Date" DATE NOT NULL CHECK ("Birth_Date" <= CURRENT_DATE),
  "Email" VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE "Storage" (
  "Storage_No" SERIAL PRIMARY KEY,
  "Store_ID" INT NOT NULL REFERENCES "Store" ("Store_ID") ON DELETE CASCADE,
  "Location" VARCHAR(100) NOT NULL,
  "Reorder_Level" INT NOT NULL CHECK ("Reorder_Level" >= 0),
  "Max_Stock" INT NOT NULL CHECK ("Max_Stock" > "Reorder_Level"),
  "Min_Stock" INT NOT NULL CHECK ("Min_Stock" <= "Reorder_Level")
);

CREATE TABLE "Employee" (
  "Employee_ID" SERIAL PRIMARY KEY,
  "Store_ID" INT NOT NULL REFERENCES "Store" ("Store_ID") ON DELETE RESTRICT,
  "Storage_No" INT REFERENCES "Storage" ("Storage_No") ON DELETE SET NULL,
  "F_Name" VARCHAR(50) NOT NULL,
  "M_Name" VARCHAR(50),
  "L_Name" VARCHAR(50) NOT NULL,
  "Email" VARCHAR(255) UNIQUE NOT NULL,
  "Gender" CHAR(1) NOT NULL CHECK ("Gender" IN ('M', 'F', 'O')),
  "Role" VARCHAR(50) NOT NULL CHECK ("Role" IN ('Manager', 'Seller', 'Stockkeeper')),
  "Supervisor" INT REFERENCES "Employee" ("Employee_ID") ON DELETE SET NULL
);

CREATE TABLE "Payment_Methods" (
  "Payment_Method_ID" SERIAL PRIMARY KEY,
  "Method_Name" VARCHAR(50) NOT NULL UNIQUE CHECK ("Method_Name" IN ('Cash', 'Credit', 'Debit', 'Online'))
);

CREATE TABLE "Categories" (
  "Category_ID" SERIAL PRIMARY KEY,
  "Category_Name" VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE "Users" (
  "User_ID" SERIAL PRIMARY KEY,
  "Customer_ID" INT NOT NULL REFERENCES "Customer" ("Customer_ID") ON DELETE CASCADE,
  "Email" VARCHAR(255) UNIQUE NOT NULL,
  "Password_Hash" VARCHAR(255) NOT NULL,
  "Role" VARCHAR(20) NOT NULL CHECK ("Role" IN ('Guest', 'Registered', 'Admin')) DEFAULT 'Registered',
  "Failed_Logins" INT NOT NULL DEFAULT 0 CHECK ("Failed_Logins" >= 0), -- Security
  "Locked_Until" TIMESTAMP, -- Lockout after failed attempts
  "Created_At" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "Sessions" ( -- New: Track logged-in users
  "Session_ID" VARCHAR(128) PRIMARY KEY, -- UUID or token
  "User_ID" INT NOT NULL REFERENCES "Users" ("User_ID") ON DELETE CASCADE,
  "Created_At" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "Expires_At" TIMESTAMP NOT NULL
);

CREATE TABLE "Addresses" ( -- New: Shipping info
  "Address_ID" SERIAL PRIMARY KEY,
  "Customer_ID" INT NOT NULL REFERENCES "Customer" ("Customer_ID") ON DELETE CASCADE,
  "Street" VARCHAR(100) NOT NULL,
  "City" VARCHAR(50) NOT NULL,
  "State" VARCHAR(50),
  "Postal_Code" VARCHAR(20) NOT NULL,
  "Country" VARCHAR(50) NOT NULL,
  "Is_Default" BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE "Product" (
  "Product_ID" SERIAL PRIMARY KEY,
  "Supplier_ID" INT REFERENCES "Supplier" ("Supplier_ID") ON DELETE SET NULL,
  "Product_Name" VARCHAR(100) NOT NULL,
  "Size" VARCHAR(10) NOT NULL CHECK ("Size" IN ('XS', 'S', 'M', 'L', 'XL', 'XXL')),
  "Brand" VARCHAR(50) NOT NULL,
  "Price" DECIMAL(10, 2) NOT NULL CHECK ("Price" >= 0),
  "Color" VARCHAR(30) NOT NULL,
  "Launch_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Store_Inventory" (
  "Store_ID" INT NOT NULL REFERENCES "Store" ("Store_ID") ON DELETE CASCADE,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Quantity" INT NOT NULL CHECK ("Quantity" >= 0),
  PRIMARY KEY ("Store_ID", "Product_ID")
);

CREATE TABLE "Reserved_Stock" ( -- New: Prevent overselling
  "Reservation_ID" SERIAL PRIMARY KEY,
  "Store_ID" INT NOT NULL REFERENCES "Store" ("Store_ID") ON DELETE CASCADE,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Quantity" INT NOT NULL CHECK ("Quantity" > 0),
  "Reserved_At" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "Expires_At" TIMESTAMP NOT NULL -- Cart timeout
);

CREATE TABLE "Customer_Order" (
  "Order_ID" SERIAL PRIMARY KEY,
  "Employee_Seller_ID" INT NOT NULL REFERENCES "Employee" ("Employee_ID") ON DELETE RESTRICT,
  "Customer_ID" INT NOT NULL REFERENCES "Customer" ("Customer_ID") ON DELETE RESTRICT,
  "Payment_Method_ID" INT NOT NULL REFERENCES "Payment_Methods" ("Payment_Method_ID") ON DELETE RESTRICT,
  "Address_ID" INT REFERENCES "Addresses" ("Address_ID") ON DELETE SET NULL, -- New: Shipping link
  "Purchase_Date" DATE NOT NULL DEFAULT CURRENT_DATE,
  "Total_Price" DECIMAL(10, 2) NOT NULL CHECK ("Total_Price" >= 0),
  "Status" VARCHAR(20) NOT NULL CHECK ("Status" IN ('Pending', 'Processing', 'Shipped', 'Delivered', 'Cancelled'))
);

CREATE TABLE "Order_Details" (
  "Order_ID" INT NOT NULL REFERENCES "Customer_Order" ("Order_ID") ON DELETE CASCADE,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE RESTRICT,
  "Quantity" INT NOT NULL CHECK ("Quantity" > 0),
  "Original_Price" DECIMAL(10, 2) NOT NULL CHECK ("Original_Price" >= 0),
  "Discount_Amount" DECIMAL(10, 2) NOT NULL CHECK ("Discount_Amount" >= 0),
  "Final_Price" DECIMAL(10, 2) NOT NULL CHECK ("Final_Price" >= 0),
  PRIMARY KEY ("Order_ID", "Product_ID")
);

CREATE TABLE "Return" (
  "Return_ID" SERIAL PRIMARY KEY,
  "Order_ID" INT NOT NULL REFERENCES "Customer_Order" ("Order_ID") ON DELETE RESTRICT,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE RESTRICT,
  "Refunded_Amount" DECIMAL(10, 2) NOT NULL CHECK ("Refunded_Amount" >= 0),
  "Quantity_Returned" INT NOT NULL CHECK ("Quantity_Returned" > 0),
  "Reason" VARCHAR(255) NOT NULL,
  "Return_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Supply_Order" (
  "Supply_Order_ID" SERIAL PRIMARY KEY,
  "Supplier_ID" INT NOT NULL REFERENCES "Supplier" ("Supplier_ID") ON DELETE RESTRICT,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE RESTRICT,
  "Employee_ID" INT REFERENCES "Employee" ("Employee_ID") ON DELETE SET NULL,
  "Quantity_Ordered" INT NOT NULL CHECK ("Quantity_Ordered" > 0),
  "Price" DECIMAL(10, 2) NOT NULL CHECK ("Price" >= 0),
  "Order_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Price_History" (
  "History_ID" SERIAL PRIMARY KEY,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Price" DECIMAL(10, 2) NOT NULL CHECK ("Price" >= 0),
  "Change_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Cart" (
  "Cart_ID" SERIAL PRIMARY KEY,
  "Customer_ID" INT NOT NULL REFERENCES "Customer" ("Customer_ID") ON DELETE CASCADE,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Quantity" INT NOT NULL CHECK ("Quantity" > 0),
  "Added_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Wishlist" (
  "Wishlist_ID" SERIAL PRIMARY KEY,
  "Customer_ID" INT NOT NULL REFERENCES "Customer" ("Customer_ID") ON DELETE CASCADE,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Added_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Phone_Numbers_Employees" (
  "Phone_Number" VARCHAR(20) PRIMARY KEY,
  "Employee_ID" INT NOT NULL REFERENCES "Employee" ("Employee_ID") ON DELETE CASCADE
);

CREATE TABLE "Phone_Numbers_Customers" (
  "Phone_Number" VARCHAR(20) PRIMARY KEY,
  "Customer_ID" INT NOT NULL REFERENCES "Customer" ("Customer_ID") ON DELETE CASCADE
);

CREATE TABLE "Phone_Numbers_Supplier" (
  "Phone_Number" VARCHAR(20) PRIMARY KEY,
  "Supplier_ID" INT NOT NULL REFERENCES "Supplier" ("Supplier_ID") ON DELETE CASCADE
);

CREATE TABLE "Image" (
  "Image_ID" SERIAL PRIMARY KEY,
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Image_URL" TEXT NOT NULL
);

CREATE TABLE "Product_Categories" (
  "Product_ID" INT NOT NULL REFERENCES "Product" ("Product_ID") ON DELETE CASCADE,
  "Category_ID" INT NOT NULL REFERENCES "Categories" ("Category_ID") ON DELETE CASCADE,
  PRIMARY KEY ("Product_ID", "Category_ID")
);

CREATE TABLE "Notification" (
  "Notification_ID" SERIAL PRIMARY KEY,
  "Customer_ID" INT REFERENCES "Customer" ("Customer_ID") ON DELETE SET NULL,
  "Store_ID" INT REFERENCES "Store" ("Store_ID") ON DELETE SET NULL,
  "Product_ID" INT REFERENCES "Product" ("Product_ID") ON DELETE SET NULL,
  "Employee_ID" INT REFERENCES "Employee" ("Employee_ID") ON DELETE SET NULL,
  "Message" VARCHAR(255) NOT NULL,
  "Sent_Date" DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE "Audit_Log" ( -- New: Track actions
  "Log_ID" SERIAL PRIMARY KEY,
  "User_ID" INT REFERENCES "Users" ("User_ID") ON DELETE SET NULL,
  "Employee_ID" INT REFERENCES "Employee" ("Employee_ID") ON DELETE SET NULL,
  "Action" VARCHAR(50) NOT NULL, -- e.g., 'Login', 'Order Placed', 'Price Updated'
  "Table_Name" VARCHAR(50),
  "Record_ID" INT,
  "Timestamp" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_order_customer ON "Customer_Order" ("Customer_ID");
CREATE INDEX idx_order_product ON "Order_Details" ("Product_ID");
CREATE INDEX idx_inventory_store_product ON "Store_Inventory" ("Store_ID", "Product_ID");
CREATE INDEX idx_cart_customer ON "Cart" ("Customer_ID");
CREATE INDEX idx_users_email ON "Users" ("Email");
CREATE INDEX idx_sessions_user ON "Sessions" ("User_ID");
CREATE INDEX idx_reserved_stock ON "Reserved_Stock" ("Store_ID", "Product_ID");
