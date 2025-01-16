USE product_db;

CREATE TABLE IF NOT EXISTS Product (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
    );

INSERT INTO Product (name, description, price, stock) VALUES
                                                          ('Laptop', 'High-performance laptop', 1500.00, 50),
                                                          ('Smartphone', 'Latest model smartphone', 800.00, 100),
                                                          ('Headphones', 'Noise-cancelling headphones', 200.00, 75);
