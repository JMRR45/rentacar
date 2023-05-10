-- INSERT INITIAL DATA
SELECT public.add_situation('available');
SELECT public.add_situation('rented');
SELECT public.add_situation('workshop');

SELECT public.add_paymethod('cash');
SELECT public.add_paymethod('credit');
SELECT public.add_paymethod('check');

SELECT public.add_brand('Audi');
SELECT public.add_brand('Kia');
SELECT public.add_brand('Ford');
SELECT public.add_brand('Chevrolet');

SELECT public.add_category('B');
SELECT public.add_category('C');
SELECT public.add_category('D');
SELECT public.add_category('E');

SELECT public.add_country('Canadá');
SELECT public.add_country('Estados Unidos');
SELECT public.add_country('Rusia');
SELECT public.add_country('Francia');
SELECT public.add_country('España');

SELECT public.add_model('A4',       (SELECT id FROM brand WHERE name = 'Audi'));
SELECT public.add_model('A3',       (SELECT id FROM brand WHERE name = 'Audi'));
SELECT public.add_model('A6',       (SELECT id FROM brand WHERE name = 'Audi'));
SELECT public.add_model('Picanto',  (SELECT id FROM brand WHERE name = 'Kia'));
SELECT public.add_model('Rio',      (SELECT id FROM brand WHERE name = 'Kia'));
SELECT public.add_model('Sportage', (SELECT id FROM brand WHERE name = 'Kia'));
SELECT public.add_model('Fiesta',   (SELECT id FROM brand WHERE name = 'Ford'));
SELECT public.add_model('Focus',    (SELECT id FROM brand WHERE name = 'Ford'));
SELECT public.add_model('Mustang',  (SELECT id FROM brand WHERE name = 'Ford'));
SELECT public.add_model('Camaro',   (SELECT id FROM brand WHERE name = 'Chevrolet'));
SELECT public.add_model('Corvette', (SELECT id FROM brand WHERE name = 'Chevrolet'));
SELECT public.add_model('Malibu',   (SELECT id FROM brand WHERE name = 'Chevrolet'));

-- Drivers
SELECT public.add_driver(
	'99030467856',
	'Marcos Pérez',
	(SELECT id FROM category WHERE name = 'B'),
	'23 e/ A y B, Plaza de la Revolución'
);
SELECT public.add_driver(
	'80112745301',
	'Alberto Prado',
	(SELECT id FROM category WHERE name = 'E'),
	'Espada e/ Escudo y Armadura, Centro Habana'
);
SELECT public.add_driver(
	'79092345678',
	'Luis Serio',
	(SELECT id FROM category WHERE name = 'C'),
	'10 de Octubre e/ Santa Catalina y Juan Delgado, 10 de Octubre'
);
SELECT public.add_driver(
	'95071834205',
	'Ulises Martínez',
	(SELECT id FROM category WHERE name = 'B'),
	'41 e/ 42 y 44, Playa'
);


-- Tourists
SELECT public.add_tourist(
	'ABC090807',
	'Peter Smith',
	34,
	'M',
	'+1345234098',
	(SELECT id FROM country WHERE name = 'Estados Unidos')
);
SELECT public.add_tourist(
	'ART090807',
	'Daniel Smith',
	34,
	'M',
	'+1345234098',
	(SELECT id FROM country WHERE name = 'Estados Unidos')
);
SELECT public.add_tourist(
	'ABC070807',
	'Lidia Oropesa',
	25,
	'F',
	'+34345234098',
	(SELECT id FROM country WHERE name = 'España')
);
SELECT public.add_tourist(
	'ABC230789',
	'Peter Mollineux',
	22,
	'M',
	'+09345234098',
	(SELECT id FROM country WHERE name = 'Canadá')
);
SELECT public.add_tourist(
	'AEC070789',
	'Ivanka Putina',
	43,
	'F',
	'+56345234098',
	(SELECT id FROM country WHERE name = 'Rusia')
);
SELECT public.add_tourist(
	'AEC071239',
	'Inna Vladimirova',
	43,
	'F',
	'+56345234098',
	(SELECT id FROM country WHERE name = 'Rusia')
);
SELECT public.add_tourist(
	'FEC340789',
	'Karina Kalashkinova',
	19,
	'F',
	'+5678900898',
	(SELECT id FROM country WHERE name = 'Rusia')
);

-- Cars
SELECT public.add_car(
	'B890123',
	(SELECT id FROM model WHERE name = 'Picanto'),
	32456,
	'Rojo',
	(SELECT id FROM situation WHERE name = 'available')
);
SELECT public.add_car(
	'B895690',
	(SELECT id FROM model WHERE name = 'Camaro'),
	32456,
	'Negro',
	(SELECT id FROM situation WHERE name = 'available')
);
SELECT public.add_car(
	'B123456',
	(SELECT id FROM model WHERE name = 'Fiesta'),
	32456,
	'Blanco',
	(SELECT id FROM situation WHERE name = 'rented')
);

-- Contracts
SELECT public.add_contract(
	'B123456',
	'AEC071239',
	'2023/02/13',
	'2023/03/13',
	'2023/03/13',
	(SELECT id FROM pay_method WHERE name = 'cash'),
	'79092345678'
);
SELECT public.add_contract(
	'B895690',
	'ABC070807',
	'2023/01/27',
	'2023/04/15',
	'2023/05/03',
	(SELECT id FROM pay_method WHERE name = 'check'),
	null
);