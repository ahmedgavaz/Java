create table `people`(
`person_id` int auto_increment unique primary key,
`first_name` varchar(20),
`salary` decimal(10,2),
`passport_id` int unique
);
create table `passports`(
`passport_id` int auto_increment unique primary key,
`passport_number` varchar(10) unique
)auto_increment=101;

alter table `people`
add constraint `fk_people_passports`
foreign key (`passport_id`)
references `passports`(`passport_id`);

insert into `passports`(`passport_number`)
values("N34FG21B"),
("K65LO4R7"),
("ZE657QP2");

insert into `people`(`first_name`,`salary`,`passport_id`)
values("Roberto",43300,102),
("Tom",56100,103),
("Yana",60200,101);
--------------------------------------------------
create table `manufacturers`(
`manufacturer_id` int auto_increment unique primary key,
`name` varchar(20),
`established_on` date
);

create table `models`(
`model_id` int auto_increment unique primary key,
`name` varchar(20),
`manufacturer_id` int
)auto_increment=101;

alter table `models`
add constraint `fk_models_manufacturers`
foreign key (`manufacturer_id`)
references `manufacturers`(`manufacturer_id`);

insert into `manufacturers`(`name`,`established_on`)
values ("BMW","1916-03-01"),
("Tesla","2003-01-01"),
("Lada","1966-05-01");

insert into `models`(`name`,`manufacturer_id`)
values ("X1",1),
("i6",1),
("Model S",2),
("Model X",2),
("Model 3",2),
("Nova",3);
-----------------------------------------------------
create table `students`(
`student_id` int auto_increment unique primary key,
`name` varchar(20)
);

create table `exams`(
`exam_id` int auto_increment unique primary key,
`name` varchar(20)
)auto_increment=101;

create table `students_exams`(
`student_id` int,
`exam_id` int, 
constraint `pk_st_ex`
primary key (`student_id`,`exam_id`),
constraint `fk_students`
foreign key (`student_id`)
references `students`(`student_id`),
constraint `fk_exams`
foreign key (`exam_id`)
references `exams`(`exam_id`)
);

insert into `students`(`name`)
values ("Mila"),
("Toni"),
("Ron");

insert into `exams`(`name`)
values ("Spring MVC"),
("Neo4j"),
("Oracle 11g");

insert into `students_exams`(`student_id`,`exam_id`)
values (1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);
------------------------------------------------------------
create table `teachers`(
`teacher_id` int auto_increment unique primary key,
`name` varchar(20),
`manager_id` int 
)auto_increment=101;

insert into `teachers`(`name`,`manager_id`)
values ("John",NULL),
("Maya",106),
("Silvia",106),
("Ted",105),
("Mark",101),
("Greta",101);

alter table `teachers`
add constraint `fk_teachers`
foreign key (`manager_id`)
references `teachers`(`teacher_id`);
----------------------------------------------
create table `cities`(
`city_id` int auto_increment primary key  unique,
`name` varchar(50)
);

create table `customers`(
`customer_id` int auto_increment unique primary key,
`name` varchar(50),
`birthday` date,
`city_id` int,
constraint `fk_customers_cities`
foreign key (`city_id`)
references `cities`(`city_id`)
);

create table `orders`(
`order_id` int auto_increment unique primary key,
`customer_id` int,
constraint `fk_orders_customers`
foreign key (`customer_id`)
references `customers`(`customer_id`)
);

create table `item_types`(
`item_type_id` int primary key unique auto_increment,
`name` varchar(50)
);

create table `items`(
`item_id` int auto_increment unique primary key,
`name` varchar(50),
`item_type_id` int,
constraint `fk_items_item_types`
foreign key (`item_type_id`)
references `item_types`(`item_type_id`)
);

create table `order_items`(
`order_id` int, 
`item_id` int,
constraint `pk_order_items`
primary key(`order_id`,`item_id`),
constraint `fk_order_items_orders`
foreign key (`order_id`)
references `orders`(`order_id`),
constraint `fk_order_items_items`
foreign key (`item_id`)
references `items`(`item_id`)
);
-------------------------------------------------
create table `subjects`(
`subject_id` int auto_increment unique primary key,
`subject_name` varchar(50)
);

create table `majors`(
`major_id` int auto_increment unique primary key,
`name` varchar(50)
);

create table `students`(
`student_id` int auto_increment unique primary key,
`student_number` varchar(12),
`student_name` varchar(50),
`major_id` int,
constraint `fk_students_majors`
foreign key (`major_id`)
references `majors`(`major_id`)
);


create table `payments`(
`payment_id` int auto_increment unique primary key,
`payment_date` date,
`payment_amount` decimal(8,2),
`student_id` int,
constraint `fk_payments_students`
foreign key (`student_id`)
references `students`(`student_id`)
);

 create table `agenda`(
 `student_id` int,
 `subject_id` int,
 constraint `pk_agenda`
 primary key (`student_id`,`subject_id`),
 constraint `fk_agenda_subjects`
 foreign key (`subject_id`)
 references  `subjects`(`subject_id`),
 constraint `fk_agenda_students`
 foreign key (`student_id`)
 references `students`(`student_id`)
 );

select m.mountain_range,p.peak_name,p.elevation
from peaks as p join (mountains as m) on m.id = p.mountain_id
where m.id=17
order by p.elevation desc;