SELECT country.name, tourist.name, tourist.passport, count(contract.tourist_passport) AS cars_count FROM tourist
JOIN contract ON contract.tourist_passport = tourist.passport
JOIN country ON country.id = tourist.country_id
GROUP BY country.name, tourist.name, tourist.passport;

CREATE OR REPLACE FUNCTION special_contract_value(contract_plate varchar(7), contract_start_date date) RETURNS double AS $$
DECLARE 
	return_value double;
	local_regular_days integer;
	local_extended_days integer;
	local_end_date date;
	local_delivery_date date;
	local_regular_fee double;
	local_extended_fee double;
BEGIN
	local_end_date := SELECT end_date FROM contract WHERE car_plate = contract_plate AND start_date = contract_start_date;
	local_regular_days := local_end_date - contract_start_date;
	
	local_delivery_date := SELECT delivery_date FROM contract WHERE car_plate = contract_plate AND start_date = contract_start_date;
	local_extended_days := local_delivery_date - contract_end_date;

	local_regular_fee := SELECT day_cost FROM fee WHERE name = 'regular';
	local_extended_fee := SELECT day_cost FROM fee WHERE name = 'prórroga';
	
	return_value := local_regular_days * local_regular_fee + local_extended_days * local_extended_days;
	RETURN return_value;
END; $$
LANGUAGE 'plpgsql';