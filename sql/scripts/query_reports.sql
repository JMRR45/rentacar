-- Report #2
SELECT plate, brand.name, model.name, color, cant_km FROM car
JOIN model ON car.model_id = model.id
JOIN brand ON model.brand_id = brand.id;

-- Report #4
SELECT dni, name, address, category.name, count(contract.id) FROM driver
JOIN category ON driver.category_id = category.id
JOIN contract ON contract.driver_dni = driver.dni;

-- Report #5
SELECT plate, brand.name, situation.name, contract.end_date FROM car
JOIN brand ON car.brand_id = brand.id
JOIN situation ON car.situation_id = situation.id
IF 