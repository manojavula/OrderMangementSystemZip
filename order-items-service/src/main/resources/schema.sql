DROP TABLE IF EXISTS order_items;
 
CREATE TABLE order_items (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_code VARCHAR(250) NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  quantity INT DEFAULT NULL
);
 
