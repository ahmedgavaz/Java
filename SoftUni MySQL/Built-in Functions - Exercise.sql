select `first_name`,`last_name` from `employees`
where substring(`first_name`,1,2)="Sa"
order by `employee_id`;

select `first_name`,`last_name` from `employees`
where `last_name` Like '%ei%'
order by `employee_id`;

select `first_name` from `employees`
where `department_id` in (3,10) and extract(year from `hire_date`) between 1995 and 2005
order by `employee_id`;

select `first_name`,`last_name` from `employees`
where `job_title` not like '%engineer%'
order by `employee_id`;

select `name` from `towns`
where char_length(`name`) in (5,6)
order by `name`;

select * from `towns`
where substring(`name`,1,1) in ('M','K','B','E')
order by `name`;

select * from `towns`
where substring(`name`,1,1) not in ('R','B','D')
order by `name`;

create view `v_employees_hired_after_2000` as
select `first_name`,`last_name` from `employees`
where extract(year from `hire_date`)>2000;
select * from `v_employees_hired_after_2000`; 

select `first_name`,`last_name` from `employees`
where char_length(`last_name`)=5;

select `country_name`,`iso_code` from `countries`
where `country_name` like '%a%a%a%'
order by  `iso_code`;

select `peak_name`,`river_name`,lower(concat(`peak_name`,substring(`river_name`,2,char_length(`river_name`)))) as 'e'
from `peaks`,`rivers`
where substring(`peak_name`,char_length(`peak_name`))=substring(`river_name`,1,1)
order by e;

select `name`,date_format(`start`,'%Y-%m-%d') from `games`
where extract(year from `start`) in (2011,2012)
order by `start`,`name`
limit 50;

select `user_name`,substring(`email`,locate('@',`email`)+1) as e
from `users`
order by e,`user_name`;

select `user_name`,`ip_address` from `users`
where `ip_address` like "___.1%.%.___"
order by `user_name`;

select `name`,case
when hour(`start`) between 0 and 11 then "Morning"
when  hour(`start`) between 12 and 17 then "Afternoon"
else "Evening"
end as "Part of the day",case
when `duration`<=3 then "Extra Short"
when `duration` <=6 then "Short"
when `duration` <=10 then "Long"
else "Extra Long" end as "Duration"
from `games`;

select `product_name`,`order_date`,adddate(`order_date`, interval 3 day),adddate(`order_date`,interval 1 month) from `orders`;