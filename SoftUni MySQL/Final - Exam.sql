/*create schema restaurant_db;*/
create table products(
id int primary key auto_increment,
`name` varchar(30) not null unique,
type varchar(30) not null,
price decimal(10,2) not null);

create table clients(
id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
birthdate date not null,
card varchar(50),
review text);

create table tables(
id int primary key auto_increment,
floor int not null,
reserved boolean,
capacity int not null);

create table waiters(
id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(50) not null,
phone varchar(50),
salary decimal(10,2));

create table orders(
id int primary key auto_increment,
table_id int not null,
waiter_id int not null,
order_time time not null,
payed_status boolean,
constraint `fk_this_tables`
foreign key (`table_id`)
references `tables`(`id`),
constraint `fk_this_waiters`
foreign key (`waiter_id`)
references `waiters`(`id`));

create table orders_clients(
order_id int,
client_id int,
constraint `fk_this_order`
foreign key (`order_id`)
references `orders`(`id`),
constraint `fk_this_clients`
foreign key (`client_id`)
references `clients`(`id`));

create table orders_products(
order_id int,
product_id int,
constraint `fk_this_orders`
foreign key (`order_id`)
references `orders`(`id`),
constraint `fk_this_products`
foreign key (`product_id`)
references `products`(`id`));

insert into `products`(name,type,price)
(select concat(last_name," specialty"),"Cocktail",(case 
when ceiling(salary*0.01)is null then 0
else ceiling(salary*0.01)
end) from waiters);

insert into `products`(name,type,price)
(select concat(last_name," specialty"),"Cocktail",ceil(salary*0.01) from waiters
where id>6);

update orders
set table_id = table_id-1
where id between 12 and 23;

delete from waiters as w
where w.id not in (select waiter_id from orders);

select id , first_name,last_name,birthdate,card,review from clients
order by birthdate desc,id desc;

select first_name,last_name,birthdate,review from clients
where card is null and year(birthdate) between 1978 and 1993
order by last_name desc,id
limit 5;

select concat(last_name,first_name,char_length(first_name),"Restaurant") as username,reverse(concat(substring(email,2,12))) as password
from waiters
where salary is not null
order by password desc;

select p.id,p.name,count(op.product_id) as count from products as p
join orders_products as op on p.id=op.product_id
group by op.product_id
having count(p.name) >=5
order by count desc,p.name asc;

select o.table_id,t.capacity,count(oc.client_id) as counta,(
case 
when t.capacity>count(oc.client_id) then "Free seats"
when t.capacity=count(oc.client_id) then "Full"
else "Extra seats"
end) as counta1 from tables as t
join orders as o on o.table_id=t.id
join orders_clients as oc on o.id=oc.order_id
where t.floor=1
group by table_id
order by o.table_id desc;

select c.first_name,c.last_name,sum(p.price) from clients as c
left join orders_clients as oc on c.id=oc.client_id 
left join orders as o on o.id=oc.order_id
left join orders_products as op on o.id=op.product_id 
left join products as p on p.id=op.product_id
where concat(c.first_name," ",c.last_name)="Silvio Blyth";

select c.first_name,c.last_name,sum(p.price) as sum from products as p
right join orders_products as op on p.id=op.product_id 
right join orders as o on o.id=op.order_id
right join orders_clients as oc on o.id=oc.order_id 
right join clients as c on c.id=oc.client_id
where concat(c.first_name," ",c.last_name)="Silvio Blyth"
group by sum;

delimiter $$
create function  udf_client_bill(full_name VARCHAR(50)) 
returns decimal(19,2)
deterministic
begin
declare suma decimal(19,2);
set suma = (select sum(p.price) from products as p
right join orders_products as op on p.id=op.product_id 
right join orders as o on o.id=op.order_id
right join orders_clients as oc on o.id=oc.order_id 
right join clients as c on c.id=oc.client_id
where concat(c.first_name," ",c.last_name)=full_name);
return suma;
end;$$
delimiter ;
select sum(p.price) from products as p
right join orders_products as op on p.id=op.product_id 
right join orders as o on o.id=op.order_id
right join orders_clients as oc on o.id=oc.order_id 
right join clients as c on c.id=oc.client_id
where concat(c.first_name," ",c.last_name)="Silvio Blyth";

delimiter ;
delimiter $$
create procedure udp_happy_hour(type VARCHAR(50))
begin
select id,name,type,price from products as p
where p.type=type;
update products as p
set price = price*0.8 
where price>=10;
end;$$
delimiter ;
CALL udp_happy_hour ('Cognac');

SELECT * FROM products p
WHERE p.type = 'Cognac' OR p.type = 'Beer'
ORDER BY p.id;
select id,name,type,(case 
when price >=10 then price*0.8
else price
end)) from products;

SELECT o.table_id,
    t.capacity,
    COUNT(oc.client_id) AS clount_clients,
    CASE
    WHEN t.capacity > COUNT(oc.order_id) THEN 'Free seats'
    WHEN t.capacity = COUNT(oc.order_id) THEN 'Full'
    ELSE 'Extra seats'
    END
    AS availability
    FROM tables t
    JOIN orders o
    ON o.table_id = t.id
    JOIN orders_clients oc
    ON o.id = oc.order_id
    WHERE t.floor = 1
    GROUP BY o.table_id
    ORDER BY o.table_id DESC;
    