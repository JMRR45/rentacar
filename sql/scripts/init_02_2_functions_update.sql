-- UPDATE FUNCTIONS
CREATE OR REPLACE FUNCTION update_driver(driver_dni varchar(11), driver_name text, driver_category integer, driver_address text) RETURNS void AS $$
BEGIN
	UPDATE driver SET
		name = driver_name,
		category_id = driver_category,
		address = driver_address
	WHERE dni = driver_dni;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_tourist(tourist_passport varchar(9), tourist_name text, tourist_age integer, tourist_sex char, tourist_contact text, tourist_country integer) RETURNS void AS $$
BEGIN
	UPDATE tourist SET
		name = tourist_name,
		age = tourist_age,
		sex = tourist_sex,
		contact = tourist_contact,
		country_id = tourist_country
	WHERE passport = tourist_passport;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_car(car_plate varchar(7), car_model integer, car_cant_km integer, car_color text, car_situation integer) RETURNS void AS $$
BEGIN
	UPDATE car SET
		model_id = car_model,
		cant_km = car_cant_km,
		color = car_color,
		situation_id = car_situation
	WHERE plate = car_plate;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_contract(contract_plate varchar(7), contract_start_date date, contract_passport varchar(9), contract_end_date date, contract_delivery_date date, contract_pay_method integer, contract_dni varchar(11)) RETURNS void AS $$
BEGIN
	UPDATE contract SET
		tourist_passport = contract_passport,
		end_date = contract_end_date,
		delivery_date = contract_delivery_date,
		pay_mehtod = contract_pay_method,
		driver_dni = contract_driver
	WHERE car_plate = contract_plate AND start_date = contract_start_date;
END; $$
LANGUAGE plpgsql;