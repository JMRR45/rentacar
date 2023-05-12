-- DELETE FUNCTIONS
CREATE OR REPLACE FUNCTION delete_situation(text) RETURNS void AS $$
BEGIN
	DELETE FROM situation WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_paymethod(text) RETURNS void AS $$
BEGIN
	DELETE FROM pay_method WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_brand(text) RETURNS void AS $$
BEGIN
	DELETE FROM brand WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_country(text) RETURNS void AS $$
BEGIN
	DELETE FROM country WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_category(text) RETURNS void AS $$
BEGIN
	DELETE FROM category WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_model(text) RETURNS void AS $$
BEGIN
	DELETE FROM situation WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_driver(varchar(11)) RETURNS void AS $$
BEGIN
	DELETE FROM driver WHERE dni = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_tourist(varchar(9)) RETURNS void AS $$
BEGIN
	DELETE FROM tourist WHERE passport = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_car(varchar(7)) RETURNS void AS $$
BEGIN
	DELETE FROM car WHERE plate = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_contract(varchar(7), date) RETURNS void AS $$
BEGIN
	DELETE FROM contract WHERE car_plate = $1 AND start_date = date;
END; $$
LANGUAGE plpgsql;