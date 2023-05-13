CREATE OR REPLACE FUNCTION special_contract_open(contract_plate varchar(7), contract_start_date date, contract_passport varchar(9), contract_end_date date, contract_pay_method integer, contract_dni varchar(11)) RETURNS void AS $$
BEGIN
	INSERT INTO contract (car_plate, start_date, tourist_passport, end_date, start_km, delivery_date, end_km, pay_method_id, driver_dni) VALUES (
		contract_plate,
		contract_start_date,
		contract_passport,
		contract_end_date,
		(SELECT cant_km FROM car WHERE plate = contract_plate),
		null,
		null,
		contract_pay_method,
		contract_dni
		);
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION special_contract_close(contract_plate varchar(7), contract_start_date date, contract_delivery_date date, contract_end_km integer) RETURNS void AS $$
BEGIN
	UPDATE contract SET
		delivery_date = contract_delivery_date,
		end_km = contract_end_km
	WHERE car_plate = contract_plate AND start_date = contract_start_date;
END; $$
LANGUAGE plpgsql;