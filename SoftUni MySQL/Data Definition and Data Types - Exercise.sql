CREATE DATABASE `minions`;
USE `minions`;

create table `minions`(
id int primary key auto_increment,
name varchar(30),
age int
);

create table `towns`(
town_id int primary key auto_increment,
name varchar(30)
);

alter table `towns`
change column `town_id` `id` int;

alter table `minions`
add column `town_id` int,
add constraint fk_minions_towns
foreign key `minions`(`town_id`) references `towns`(`id`);

insert into `towns`(`id`,`name`)
values
(1,"Sofia"),
(2,"Plovdiv"),
(3,"Varna");

insert into `minions`(`id`,`name`, `age`,`town_id`)
values
(1,"Kevin",22,1),
(2,"Bob",15,3),
(3,"Steward",null,2);

truncate `minions`;

drop table `minions`;
drop table`towns`;

create table `people`(
id int unique primary key auto_increment,
name varchar(200) not null,
picture blob,
height double(5,2),
weight double(5,2),
gender char not null,
birthdate date not null,
biography text
);

Insert into `people` (`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)
values
(1,"Ahmed",null,123.22,88.32,'m',"2002-04-19","samo levski"),
(2,"Ahmed",null,123.22,88.32,'m',"2002-04-19","samo levski"),
(3,"Ahmed",null,123.22,88.32,'m',"2002-04-19","samo levski"),
(4,"Ahmed",null,123.22,88.32,'m',"2002-04-19","samo levski"),
(5,"Ahmed",null,123.22,88.32,'m',"2002-04-19","samo levski");

create table `users`(
id int unique primary key auto_increment,
username varchar(30) not null unique,
password varchar(26) not null,
profile_picture blob,
last_login_time datetime,
is_deleted boolean
);

Insert into `users` (`id`,`username`,`password`,`profile_picture`,`last_login_time`,`is_deleted`)
values
(1,"Ahmed1","Levski",null,"2002-04-19",true),
(2,"Ahmed2","Levski",null,"2002-04-19",true),
(3,"Ahmed3","Levski",null,"2002-04-19",true),
(4,"Ahmed4","Levski",null,"2002-04-19",true),
(5,"Ahmed5","Levski",null,"2002-04-19",true);

alter table `users`
drop primary key,
add constraint pk_users
primary key `users`(`id`,`username`);

alter table `users`
modify column `last_login_time` datetime default now();

alter table `users`
drop primary key,
add constraint pk_users1
primary key `users`(`id`),
modify column `username` varchar(30) unique;

Insert into `users` (`id`,`username`,`password`,`profile_picture`,`last_login_time`,`is_deleted`)
values
(7,null,"Levski",null,"2002-04-19",true);

create database `movies`;
use `movies`;

create table `directors`(
id int primary key auto_increment,
director_name varchar(30) not null,
notes text
);

insert into `directors`(`id`,`director_name`,`notes`)
values
(1,"Ahmed","NZ"),
(2,"Ahmed","NZ"),
(3,"Ahmed","NZ"),
(4,"Ahmed","NZ"),
(5,"Ahmed","NZ");

create table `genres`(
id int primary key auto_increment,
genre_name varchar(30) not null,
notes text
);

insert into `genres`(`id`,`genre_name`,`notes`)
values
(1,"horror","NZ"),
(2,"horror","NZ"),
(3,"horror","NZ"),
(4,"horror","NZ"),
(5,"horror","NZ");
create table `categories`(
id int primary key auto_increment,
category_name varchar(30) not null,
notes text
);

insert into `categories`(`id`,`category_name`,`notes`)
values
(1,"best","NZ"),
(2,"best","NZ"),
(3,"best","NZ"),
(4,"best","NZ"),
(5,"best","NZ");

create table `movies`(
id int primary key auto_increment,
title varchar(50) not null,
director_id int,
copyright_year year,
length int,
genre_id int,
category_id int,
rating double,
notes text
);

insert into `movies` (`title`)
values
("Levski"),
("Levski"),
("Levski"),
("Levski"),
("Levski");

create database `car_rental`;
use `car_rental`;

create table `categories`(
id int primary key auto_increment,
category varchar(30),
daily_rate double,
weekly_rate double,
monthly_rate double,
weekend_rate double
);

insert into `categories` (`id`,`category`)
values 
(1,'horror'),
(2,'horror'),
(3,'horror');

create table `cars`(
id int primary key auto_increment,
plate_number varchar(10),
make varchar(30), 
model varchar(30),
car_year year,
category_id int,
doors int,
picture blob,
car_condition varchar(40),
available boolean
);

insert into `cars`(`id`,`plate_number`)
values
(1,"e1234e"),
(2,"e1234e"),
(3,"e1234e");

create table `employees`(
id int primary key auto_increment,
first_name varchar(30),
last_name varchar(30),
title varchar(30),
notes text
);

insert into `employees`(`id`,`first_name`)
values
(1,"Ahmed"),
(2,"Ahmed"),
(3,"Ahmed");

create table `customers`(
id INT primary key auto_increment,
driver_licence_number varchar(20),
full_name varchar(30), 
address varchar(50), 
city varchar(30),
zip_code varchar(10),
note text
);

insert into `customers`(`id`,`full_name`)
values
(1,"Ahmed"),
(2,"Ahmed"),
(3,"Ahmed");

create table `rental_orders`(
id int primary key auto_increment,
employee_id int,
customer_id int,
car_id int,
car_condition varchar(40),
tank_level varchar(20),
kilometrage_start int,
kilometrage_end int,
total_kilometrage int,
start_date date,
end_date date,
total_days int,
rate_applied double,
tax_rate double,
order_status varchar(20),
notes text
);

insert into `rental_orders`(`id`,`employee_id`)
values
(1,1),
(2,2),
(3,3);

create database `soft_uni`;
use `soft_uni`;

create table `towns`(
id int primary key auto_increment, 
name varchar(40)
);

create table `addresses`(
id int primary key auto_increment,
adresses_text varchar(50),
town_id int
);

create table `departments`(
id int primary key auto_increment,
name varchar(40)
);

create table `employees`(
id int primary key auto_increment,
first_name varchar(20),
middle_name varchar(20),
last_name varchar(20),
job_title varchar(30),
department_id int,
hire_date date,
salary double,
address_id int
);

alter table `adresses`
add constraint `fk_adresses_towns`
foreign key `adresses`(`town_id`) references `towns`(`id`);

alter table `employees`
add constraint `fk_employees_addresses`
foreign key `employees`(`address_id`) references `addresses`(`id`),
add constraint `fk_employees_departments`
foreign key `employees`(`department_id`) references `departments`(`id`);

insert into `towns`(`name`)
values
("Sofia"),
("Plovdiv"),
("Varna"),
("Burgas");

insert into `departments`(`name`)
values
("Engineering"),
("Sales"),
("Marketing"),
("Software Development"),
("Quality Assurance");

insert into `employees`(`first_name`,`middle_name`,`last_name`,`job_title`,`department_id`,`hire_date`,`salary`)
values
("Ivan","Ivanov","Ivanov",".NET Developer",4,"2013-02-01",3500),
("Petar","Petrov","Petrov","Senior Engineer",1,"2004-03-02",4000),
("Maria","Petrova","Ivanova","Intern",5,"2016-08-28",525.25),
("Georgi","Terziev","Ivanov","CEO",2,"2007-12-09",3000),
("Peter","Pan","Pan","Intern",3,"2016-08-28",599.88);

select * from `towns`;
select * from `departments`;
select * from `employees`;

select * from `towns`
order by `name`;
select * from `departments`
order by `name`;
select * from `employees`
order by `salary` desc;

select `name` from `towns`
order by `name`;
select `name` from `departments`
order by `name`;
select `first_name`,`last_name`,`job_title`,`salary` from `employees`
order by `salary` desc;

update `employees`
set `salary`=`salary`*1.1;
select `salary` from `employees`;