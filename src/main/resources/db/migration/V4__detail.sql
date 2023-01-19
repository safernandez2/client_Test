CREATE TABLE IF NOT EXISTS detail(
	id SERIAL,
	quantity INT NOT NULL,
	PRIMARY KEY (id),
	invoice_id INT NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice (id),
    product_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id)
);