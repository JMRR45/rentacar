DROP TABLE IF EXISTS driver;
CREATE TABLE driver ( 
	dni VARCHAR(11) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	category VARCHAR(63) NOT NULL,
	address VARCHAR(255) NOT NULL,
	PRIMARY KEY ( `dni` ) 
);
DROP TABLE IF EXISTS tourist;
CREATE TABLE tourist (
	passport VARCHAR(11) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	age SMALLINT NOT NULL,
	sex BINARY NOT NULL,
	country VARCHAR(63) NOT NULL,
	contact VARCHAR(15) NOT NULL,
	PRIMARY KEY ( passport ) 
);
DROP TABLE IF EXISTS car;
CREATE TABLE car (
	plate VARCHAR(7) NOT NULL,
	brand VARCHAR(31) NOT NULL,
	model VARCHAR(31) NOT NULL,
	color VARCHAR(15) NOT NULL,
	cant_km SMALLINT NOT NULL,
	state VARCHAR(15) NOT NULL,
	PRIMARY KEY ( plate ) 
);
DROP TABLE IF EXISTS contract;
CREATE TABLE contract (
	car__plate VARCHAR(7) NOT NULL,
	tourist__passport VARCHAR(11) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	pay_method VARCHAR(15) NOT NULL,
	extension SMALLINT NOT NULL,
	driver__dni VARCHAR(11),
	PRIMARY KEY ( car__plate, tourist__passport, start_date ) 
);
ALTER TABLE contract ADD CONSTRAINT fk_contract_car FOREIGN KEY ( car__plate ) REFERENCES car ( plate );
ALTER TABLE contract ADD CONSTRAINT fk_contract_tourist FOREIGN KEY ( tourist__passport ) REFERENCES tourist ( passport );
ALTER TABLE contract ADD CONSTRAINT fk_contract_driver FOREIGN KEY ( driver__dni ) REFERENCES driver ( dni );