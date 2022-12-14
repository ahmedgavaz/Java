use `soft_uni1`;

select * from `departments`;

select `name` from `departments`
order by `department_id` asc;

select `first_name`,`last_name`,`salary` from employees
order by `employee_id`;

select `first_name`,`middle_name`,`last_name` from `employees`
order by `employee_id`;

select concat(`first_name`,'.',`last_name`,'@softuni.bg') as 'email_adress'
from `employees`;

select distinct `salary`from `employees`;

select * from `employees`
where job_title = "Sales Representative"
order by `employee_id`;

select `first_name`,`last_name`,`job_title` from `employees`
where salary between 20000 and 30000
order by `employee_id`;

select concat_ws(" ",`first_name`,`middle_name`,`last_name`) as "Full Name"
from `employees`
where salary in (25000,14000,12500,23600);

select `first_name`, `last_name` from `employees`
where `manager_id` is null;

select `first_name`, `last_name`,`salary` from `employees`
where salary>50000
order by salary desc;

select `first_name`,`last_name` from `employees`
order by salary desc
limit 5;

select `first_name`,`last_name` from `employees`
where department_id!=4;

select * from `employees`
order by `salary` desc,
`first_name` asc,
`last_name` desc,
`middle_name` asc;

create view `v_employees_salaries` as
select `first_name`,`last_name`,`salary`
from `employees`;
select * from `v_employees_salaries`;

create view `v_employees_job_titles` as 
select concat_ws(" ",`first_name`,`middle_name`,`last_name`) as full_name,job_title
from `employees`;
select * from `v_employees_job_titles`;

select distinct `job_title` from `employees`
order by job_title;

select * from `projects`
order by `start_date`,
name
limit 10;

select `first_name`,`last_name`,`hire_date` from `employees`
order by hire_date desc
limit 7;

update `employees`
set salary = salary*1.12
where department_id in (1,2,4,11);
select `salary` from `employees`;

use `geography`;

select `peak_name` from `peaks`
order by `peak_name`;

select `country_name`,`population` from `countries`
where continent_code = "EU"
order by population desc,
country_name
limit 30;

select `country_name`,`country_code`,if(currency_code!="EUR","Not Euro","Euro") from `countries`
order by `country_name`;

use `diablo`;

select `name` from `characters`
order by `name`;
