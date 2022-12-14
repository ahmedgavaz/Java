delimiter @@
create function ufn_count_employees_by_town(town_name varchar(20))
returns int
deterministic
begin 
declare num int;
set num=(select count(*) from employees 
join towns on town_id=address_if
where name=town_name);
return num;
end@@
delimiter ;
/*Nachalo na zadachite*/

delimiter @@
create procedure usp_get_employees_salary_above_35000()
begin
select first_name,last_name from employees
where salary>35000
order by first_name,last_name,employee_id;
end@@
delimiter ;

delimiter @@
create procedure usp_get_employees_salary_above(money decimal(12,4))
begin
select first_name,last_name from employees 
where salary>=money 
order by first_name,last_name,employee_id;
end@@
delimiter ;

delimiter @@
create procedure usp_get_towns_starting_with(str varchar(20))
begin
select name from towns
where name like concat(str,"%")
order by name;
end@@
delimiter ;

delimiter @@
create procedure usp_get_employees_from_town(town_name varchar(30))
begin
select first_name,last_name from employees as e
join addresses as a on a.address_id = e.address_id 
join towns as t on t.town_id=a.town_id
where town_name=t.name
order by first_name,last_name,employee_id;
end@@
delimiter ;

delimiter @@
create function ufn_get_salary_level(salary int)
returns varchar(7)
deterministic
begin
return(case 
when salary<30000 then "Low"
when salary<=50000 then "Average"
else "High"
end);
end@@
delimiter ;

delimiter @@
create procedure usp_get_employees_by_salary_level(level_salary varchar(7))
begin
select first_name,last_name from employees as e
where ufn_get_salary_level(e.salary)=level_salary
order by first_name desc,last_name desc;
end@@
delimiter ;

delimiter @@
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
returns int
begin
return (select word regexp(concat("^[",set_of_letters,"]+$")));
end@@
delimiter ;

delimiter @@
create procedure usp_get_holders_full_name()
begin
select concat_ws(" ",first_name,last_name) as a from account_holders
order by a,id desc;
end@@
delimiter ;

delimiter @@
create function ufn_calculate_future_value(sum decimal(14,4),yearly_interest_rate double,years int)
returns decimal(14,4)
begin
declare suma decimal(14,4);
set suma=1+yearly_interest_rate;
return sum*pow(suma,years);
end@@
delimiter ;

delimiter @@
create procedure usp_calculate_future_value_for_account(id_to int,rate decimal(14,4))
begin
select a.id,ah.first_name,ah.last_name,a.balance,ufn_calculate_future_value(a.balance,rate, 5) from account_holders as ah
join accounts as a on ah.id=a.account_holder_id 
where a.id=id_to;
end@@
delimiter ;

delimiter @@
create procedure usp_deposit_money(account_id int, money_amount decimal(14,4))
begin
start transaction;
if (money_amount<=0) then 
rollback;
else
update accounts as ac 
set ac.balance=ac.balance+money_amount
where ac.id=account_id;
end if;
end@@
delimiter ;

delimiter @@
CREATE PROCEDURE usp_withdraw_money(id int, money_amount decimal(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0 OR (SELECT `balance` FROM accounts AS a WHERE a.`id` = id) < money_amount) THEN
    ROLLBACK;
    ELSE
        UPDATE accounts as ac SET ac.balance = ac.balance - money_amount
        WHERE ac.id = id;
        COMMIT;
    END IF; 
END@@
delimiter ;

DELIMITER @@
CREATE PROCEDURE usp_transfer_money(fromID int, toID int,money_amount decimal(19,4))
BEGIN
    START TRANSACTION;
    IF(money_amount <= 0 OR (SELECT `balance` from `accounts` where `id` = fromID) < money_amount
    OR fromID = toID 
    OR (SELECT COUNT(id) FROM `accounts` WHERE `id` = fromID) <> 1
    OR (SELECT COUNT(id) FROM `accounts` WHERE `id` = toID) <> 1) 
    THEN ROLLBACK;
    ELSE
        UPDATE `accounts` SET `balance` = `balance` - money_amount
        WHERE `id` = fromID;
        UPDATE `accounts` SET `balance` = `balance` + money_amount
        WHERE `id` = toID;
        COMMIT;
    END IF; 
END@@