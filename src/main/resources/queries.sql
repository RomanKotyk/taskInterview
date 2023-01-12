CREATE DATABASE MyShop;
USE MyShop;
CREATE TABLE Categories (CategoryID INTEGER NOT NULL AUTO_INCREMENT,
                         CategoryName VARCHAR(50) NOT NULL,
                         Description VARCHAR(100),
                         PRIMARY KEY (CategoryID));

CREATE TABLE Suppliers(SupplierID INTEGER NOT NULL AUTO_INCREMENT,
                         SupplierName VARCHAR(50) NOT NULL,
                         City VARCHAR(20) NOT NULL,
                         Country VARCHAR(20) NOT NULL,
                         PRIMARY KEY (SupplierID));

CREATE TABLE Products (ProductID INTEGER NOT NULL AUTO_INCREMENT,
                       ProductName VARCHAR(40) NOT NULL,
                       SupplierID INTEGER,
                       CategoryID INTEGER,
                       Price DOUBLE NOT NULL CHECK (Price>=0),
                       PRIMARY KEY (ProductID),
                       FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID) ON UPDATE CASCADE ON DELETE CASCADE,
                       FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Suppliers (SupplierName, City, Country) VALUES ('Exotic Liquid', 'London', 'UK');
INSERT INTO Suppliers (SupplierName, City, Country) VALUES ('New Orleans Cajun Delights', 'New Orleans', 'USA');
INSERT INTO Suppliers (SupplierName, City, Country) VALUES ('Grandma Kelly’s Homestead', 'Ann Arbor', 'USA');
INSERT INTO Suppliers (SupplierName, City, Country) VALUES ('Tokyo Traders', 'Tokyo', 'Japan');
INSERT INTO Suppliers (SupplierName, City, Country) VALUES ('Cooperativa de Quesos ‘Las Cabras’', 'Oviedo', 'Spain');

INSERT INTO Categories (CategoryName, Description) VALUES ('Beverages','Soft drinks, coffees, teas, beers, and ales');
INSERT INTO Categories (CategoryName, Description) VALUES ('Condiments',';Sweet and savory sauces, relishes, spreads, and seasonings');
INSERT INTO Categories (CategoryName, Description) VALUES ('Confections','Desserts, candies, and sweet breads');
INSERT INTO Categories (CategoryName, Description) VALUES ('Dairy Products','Cheeses');
INSERT INTO Categories (CategoryName, Description) VALUES ('Grains/Cereals','Breads, crackers, pasta, and cereal');

INSERT INTO Products (ProductName, SupplierID, CategoryID, Price) VALUES ('Chais',1,1,18);
INSERT INTO Products (ProductName, SupplierID, CategoryID, Price) VALUES ('Chang',1,1,19);
INSERT INTO Products (ProductName, SupplierID, CategoryID, Price) VALUES ('Aniseed Syrup',1,2,10.00);
INSERT INTO Products (ProductName, SupplierID, CategoryID, Price) VALUES ('Chef Anton’s Cajun Seasoning',2,2,22);
INSERT INTO Products (ProductName, SupplierID, CategoryID, Price) VALUES ('Chef Anton’s Gumbo Mix',2,2,21.35);

SELECT * FROM Products WHERE ProductName LIKE 'C%';

SELECT * FROM Products WHERE Price = (SELECT MIN(Price) FROM Products);

SELECT Price FROM Products INNER JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID WHERE Suppliers.Country = 'USA';

SELECT DISTINCT Suppliers.SupplierID,Suppliers.SupplierName,Suppliers.City,Suppliers.Country
    FROM Products
    INNER JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
    INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID
    WHERE Categories.CategoryName = 'Condiments';

INSERT INTO Suppliers(suppliername, city, country) VALUES ('Norske Meierier','Lviv','Ukraine');
INSERT INTO Products(ProductName, SupplierID, CategoryID, Price) VALUES ('Green tea',
                                                                         (SELECT SupplierID FROM Suppliers WHERE SupplierName='Norske Meierier'),
                                                                         (SELECT CategoryID FROM Categories WHERE CategoryName='Beverages'),
                                                                         10);

SELECT * FROM Products;
