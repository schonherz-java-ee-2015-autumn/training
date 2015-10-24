select c.*, lower(c.number_plate) as lower_plate from car c;

select * from car, car_model;
select * from car cross join car_model;

select * from car c join car_model m on c.car_model_id = m.car_model_id;
select * from car c, car_model m where c.car_model_id = m.car_model_id;

select * from car c join car_model m using (car_model_id);
select * from car c natural join car_model m;

