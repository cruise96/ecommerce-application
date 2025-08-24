-- Category Table (Tree Structure)
CREATE TABLE Category (
id INT PRIMARY KEY,
name VARCHAR(255),
parent_id INT NULL,
FOREIGN KEY (parent_id) REFERENCES Category(id)
);


-- Product Table
CREATE TABLE Product (
id INT PRIMARY KEY,
name VARCHAR(255),
price DECIMAL(10, 2),
availability_qty INT,
category_id INT,
FOREIGN KEY (category_id) REFERENCES Category(id)
);


-- Cart Table
CREATE TABLE Cart (
id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
product_id INT,
quantity INT,
FOREIGN KEY (product_id) REFERENCES Product(id)
);



CREATE PROCEDURE GetSubCategories
    @CategoryId INT
AS
BEGIN
    WITH CategoryCTE AS (
        SELECT id, name, parent_id
        FROM Category
        WHERE id = @CategoryId

        UNION ALL

        -- Recursive member to get children
        SELECT c.id, c.name, c.parent_id
        FROM Category c
        INNER JOIN CategoryCTE ct ON c.parent_id = ct.id
    )
    SELECT id
    FROM CategoryCTE
END