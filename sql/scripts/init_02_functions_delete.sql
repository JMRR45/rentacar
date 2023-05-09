-- DELETE FUNCTIONS
CREATE OR REPLACE FUNCTION remove_situation(text) RETURNS void AS $$
BEGIN
	DELETE FROM situation WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_paymethod(text) RETURNS void AS $$
BEGIN
	DELETE FROM pay_method WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_brand(text) RETURNS void AS $$
BEGIN
	DELETE FROM brand WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_country(text) RETURNS void AS $$
BEGIN
	DELETE FROM country WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_category(text) RETURNS void AS $$
BEGIN
	DELETE FROM category WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_model(text) RETURNS void AS $$
BEGIN
	DELETE FROM situation WHERE name = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_driver(varchar(11)) RETURNS void AS $$
BEGIN
	DELETE FROM driver WHERE dni = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_tourist(varchar(9)) RETURNS void AS $$
BEGIN
	DELETE FROM tourist WHERE passport = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_car(varchar(7)) RETURNS void AS $$
BEGIN
	DELETE FROM car WHERE plate = $1;
END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION remove_contract(integer) RETURNS void AS $$
BEGIN
	DELETE FROM contract WHERE id = $1;
END; $$
LANGUAGE plpgsql;