-- New Types Declaration
DROP TYPE IF EXISTS situation CASCADE;
CREATE TYPE situation AS ENUM ('available', 'rented', 'workshop');
DROP TYPE IF EXISTS pay_method CASCADE;
CREATE TYPE pay_method AS ENUM ('cash', 'check', 'credit');

-- Tables Creation
DROP TABLE IF EXISTS tourist CASCADE;
CREATE TABLE tourist (
	passport VARCHAR(11) NOT NULL,
	name TEXT NOT NULL,
	age SMALLINT NOT NULL,
	sex BOOLEAN NOT NULL,
	country_id INTEGER NOT NULL,
	contact TEXT NOT NULL,
	PRIMARY KEY ( passport ) 
);

DROP TABLE IF EXISTS car CASCADE;
CREATE TABLE car (
	plate VARCHAR(7) NOT NULL,
	model_id INTEGER NOT NULL,
	color TEXT NOT NULL,
	cant_km INTEGER NOT NULL,
	situation SITUATION NOT NULL,
	PRIMARY KEY ( plate ) 
);

DROP TABLE IF EXISTS driver CASCADE;
CREATE TABLE driver ( 
	dni VARCHAR(11) NOT NULL,
	name TEXT NOT NULL,
	category_id INTEGER NOT NULL,
	address TEXT NOT NULL,
	PRIMARY KEY ( dni ) 
);

DROP TABLE IF EXISTS contract CASCADE;
CREATE TABLE contract (
	id INTEGER NOT NULL,
	car_plate VARCHAR(7) NOT NULL,
	tourist_passport VARCHAR(11) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	pay_method PAY_METHOD NOT NULL,
	extension SMALLINT NOT NULL,
	driver_dni VARCHAR(11),
	PRIMARY KEY ( id ) 
);

DROP TABLE IF EXISTS country CASCADE;
CREATE TABLE country (
	id INTEGER NOT NULL,
	country TEXT NOT NULL,
	PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS model CASCADE;
CREATE TABLE model (
	id INTEGER NOT NULL,
	model TEXT NOT NULL,
	brand_id INTEGER NOT NULL,
	PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS brand CASCADE;
CREATE TABLE brand (
	id INTEGER NOT NULL,
	brand TEXT NOT NULL,
	PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category (
	id INTEGER NOT NULL,
	category TEXT NOT NULL,
	PRIMARY KEY ( id )
);

-- Foreing Keys Definition
ALTER TABLE tourist ADD CONSTRAINT fk_tourist_country FOREIGN KEY ( country_id ) REFERENCES country ( id );
ALTER TABLE car ADD CONSTRAINT fk_car_model FOREIGN KEY ( model_id ) REFERENCES model ( id );
ALTER TABLE driver ADD CONSTRAINT fk_driver_category FOREIGN KEY ( category_id ) REFERENCES category ( id );
ALTER TABLE model ADD CONSTRAINT fk_model_brand FOREIGN KEY ( brand_id ) REFERENCES brand ( id );
ALTER TABLE contract ADD CONSTRAINT fk_contract_car FOREIGN KEY ( car_plate ) REFERENCES car ( plate );
ALTER TABLE contract ADD CONSTRAINT fk_contract_tourist FOREIGN KEY ( tourist_passport ) REFERENCES tourist ( passport );
ALTER TABLE contract ADD CONSTRAINT fk_contract_driver FOREIGN KEY ( driver_dni ) REFERENCES driver ( dni );