CREATE TABLE category(

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR (255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)


);

INSERT INTO category(name, description, image_url, is_active) VALUES ('Laptop', 'Description pour la category Laptop', 'CAT_1.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Télévision', 'Description pour la category Télévision', 'CAT_2.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Mobile', 'Description pour la category Mobile', 'CAT_3.png', true);

CREATE TABLE user_detail (

	id IDENTITY,
	first_name VARCHAR (50),
	last_name VARCHAR (50),
	role VARCHAR (50),
	enable BOOLEAN,
	password VARCHAR (50),
	email VARCHAR (50),
	contact_number VARCHAR (15),
	CONSTRAINT pk_user_id PRIMARY KEY (id),

);

INSERT INTO user_detail (first_name, last_name, role, enable ,password, email, contact_number) 
VALUES ('Kassa', 'Camara', 'ADMIN', true, 'admin', 'camara@gmail.com', '776048008');

INSERT INTO user_detail (first_name, last_name, role, enable ,password, email, contact_number) 
VALUES ('Yahya', 'Sow', 'FOURNISSEUR', true,'12345', 'sow@gmail.com', '786975643');

INSERT INTO user_detail (first_name, last_name, role, enable ,password, email, contact_number) 
VALUES ('Abdou', 'Ly', 'FOURNISSEUR', true, '12345', 'abdou@gmail.com', '786770643');


CREATE TABLE product (
	
	id IDENTITY,
	code VARCHAR (20),
	name VARCHAR (50),
	marque VARCHAR (50),
	description VARCHAR (255),
	unit_price DECIMAL (10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	fournisseur_id INT,
	achats INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_fournisseur_id FOREIGN KEY (fournisseur_id) REFERENCES user_detail (id),
);


INSERT INTO product (code, name, marque, description, unit_price, quantity, is_active, category_id, fournisseur_id, achats, views) 
VALUES ('PRDABC123DEFX', 'iPhone S5', 'apple', 'This is one of the best phone available in the market right now!', 320000, 4, true, 3, 2, 0, 0);



INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );


INSERT INTO product (code, name, marque, description, unit_price, quantity, is_active, category_id, fournisseur_id, achats, views) 
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'Google', 'This is one of the best android smart phone available in the market right now!', 90000, 10, true, 3, 2, 0, 0 );



INSERT INTO product (code, name, marque, description, unit_price, quantity, is_active, category_id, fournisseur_id, achats, views) 
VALUES ('PRDMNO123PQRX', 'Macbook pro', 'apple', 'This is one of the best laptops available in the market right now!', 790000, 4, true,  1, 2, 0, 0);



INSERT INTO product (code, name, marque, description, unit_price, quantity, is_active, category_id, fournisseur_id, achats, views) 
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 170000, 4, true,1, 3, 0, 0);





