DROP TYPE IF EXISTS situation CASCADE;
CREATE TYPE situation AS ENUM ('available', 'rented', 'workshop');
DROP TYPE IF EXISTS pay_method CASCADE;
CREATE TYPE pay_method AS ENUM ('cash', 'check', 'credit');

DROP TABLE IF EXISTS driver CASCADE;
CREATE TABLE driver ( 
	dni VARCHAR(11) NOT NULL,
	name TEXT NOT NULL,
	category TEXT NOT NULL,
	address TEXT NOT NULL,
	PRIMARY KEY ( dni ) 
);

DROP TABLE IF EXISTS tourist CASCADE;
CREATE TABLE tourist (
	passport VARCHAR(11) NOT NULL,
	name TEXT NOT NULL,
	age SMALLINT NOT NULL,
	sex BOOLEAN NOT NULL,
	country TEXT NOT NULL,
	contact TEXT NOT NULL,
	PRIMARY KEY ( passport ) 
);

DROP TABLE IF EXISTS car CASCADE;
CREATE TABLE car (
	plate VARCHAR(7) NOT NULL,
	brand TEXT NOT NULL,
	model TEXT NOT NULL,
	color TEXT NOT NULL,
	cant_km INTEGER NOT NULL,
	situation SITUATION NOT NULL,
	PRIMARY KEY ( plate ) 
);

DROP TABLE IF EXISTS contract CASCADE;
CREATE TABLE contract (
	car__plate TEXT NOT NULL,
	tourist__passport TEXT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	pay_method PAY_METHOD NOT NULL,
	extension SMALLINT NOT NULL,
	driver__dni TEXT,
	PRIMARY KEY ( car__plate, tourist__passport, start_date ) 
);

ALTER TABLE contract ADD CONSTRAINT fk_contract_car FOREIGN KEY ( car__plate ) REFERENCES car ( plate );
ALTER TABLE contract ADD CONSTRAINT fk_contract_tourist FOREIGN KEY ( tourist__passport ) REFERENCES tourist ( passport );
ALTER TABLE contract ADD CONSTRAINT fk_contract_driver FOREIGN KEY ( driver__dni ) REFERENCES driver ( dni );