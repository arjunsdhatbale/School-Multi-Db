IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'products' AND xtype = 'U')
BEGIN
    CREATE TABLE products
    (
        product_Id INT PRIMARY KEY, 
        title VARCHAR(200),
        description VARCHAR(200),
        price DECIMAL(10, 2),    -- Price with two decimal places
        discount DECIMAL(5, 2),  -- Discount as a decimal value (e.g., 10.50% discount)
        discounted_price DECIMAL(10, 2) -- Discounted price (calculated based on price and discount)
    );
END
