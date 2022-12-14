/*create database instd;*/

create table users(
id int primary key,
username varchar(30) not null unique,
password varchar(30) not null,
email varchar(50) not null,
gender char not null,
age int not null,
job_title varchar(40) not null,
ip varchar(30) not null);


create table addresses(
id int primary key auto_increment,
address varchar(30) not null,
town varchar(30) not null,
country varchar(30) not null,
user_id int not null,
constraint `fk_users_addresses`
foreign key (`user_id`)
references `users`(`id`));

create table photos(
id int primary key auto_increment,
description text not null,
`date` datetime not null,
views int not null default 0);

create table comments(
id int primary key auto_increment,
comment varchar(255) not null,
`date` datetime not null,
photo_id int not null,
constraint `fk_photos_comments`
foreign key (`photo_id`)
references `photos`(`id`));

create table `users_photos`(
user_id int not null,
photo_id int not null,
constraint `fk_users_this`
foreign key (`user_id`)
references `users`(`id`),
constraint `fk_photos_this`
foreign key (`photo_id`)
references `photos`(`id`));

create table likes(
id int primary key auto_increment,
photo_id int,
user_id int,
constraint `fk_photos_likes`
foreign key (`photo_id`)
references `photos`(`id`),
constraint `fk_users_likes`
foreign key (`user_id`)
references `users`(`id`));

insert into `addresses`(`address`,`town`,`country`,`user_id`)
select username,password,ip,age from `users`
where users.gender="M" || users.gender="m";

update addresses as a
set a.country = "Blocked"
where substr(a.country,1,1)="B";
update addresses as a
set a.country = "Test"
where substr(a.country,1,1)="t";
update addresses as a
set a.country = "In Progress"
where substr(a.country,1,1)="P";

delete from addresses as a
where id %3=0;

select username,gender,age from users
order by age desc,username;

select p.id , p.date, p.description, Count(*) as count from comments as c
join photos as p on photo_id=p.id
group by photo_id
order by count desc,p.id
limit 5;

select concat_ws(" ",u.id,u.username), u.email from users as u
join users_photos as up on u.id=up.user_id
join photos as p on p.id=up.photo_id 
where u.id=p.id;

select p.id , count(distinct l.id) as c1,count(distinct c.id) as c2 from photos as p
left join likes as l on p.id=l.photo_id
left join comments as c on p.id=c.photo_id
group by p.id
order by c1 desc,c2 desc,p.id;

select concat(substr(p.description,1,30),"..."),p.date from photos as p
where day(p.date)=10 and length(p.description)>30
order by p.date desc;

create function udf_users_photos_count(username VARCHAR(30))
returns int
begin
return (select count(u.id) from users as u
join users_photos as up on user_id=u.id
where u.username=username);
end;

create procedure udp_modify_user (address VARCHAR(30), town VARCHAR(30))
begin
update users as u
join addresses as a on u.id=a.user_id
set age=(if (a.address=address && a.town=town,u.age+10,age));
/*select username, email, gender, age, job_title from  users as u 
join addresses as a on u.id=a.user_id
where a.address=address and a.town=town;*/
end;

update users as u
set age=(if (u.address=address && u.town=town,u.age+10,0))