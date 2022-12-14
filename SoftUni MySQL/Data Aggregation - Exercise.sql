select count(*) from `wizzard_deposits`;

select max(`magic_wand_size`) from wizzard_deposits;

select `deposit_group`, max(`magic_wand_size`) as e from `wizzard_deposits`
group by `deposit_group`
order by e,deposit_group;

select `deposit_group` from `wizzard_deposits`
group by `deposit_group`
order by avg(magic_wand_size)
limit 1;

select `deposit_group`, sum(`deposit_amount`) as e from `wizzard_deposits`
group by `deposit_group`
order by e;

select `deposit_group`,sum(`deposit_amount`) as e from `wizzard_deposits`
where `magic_wand_creator`="Ollivander family"
group by `deposit_group`
order by `deposit_group`;

select `deposit_group`,sum(`deposit_amount`) as e from `wizzard_deposits`
where `magic_wand_creator`="Ollivander family"
group by `deposit_group`
having e<150000
order by e desc;

select `deposit_group`,`magic_wand_creator`,min(`deposit_charge`) as e from `wizzard_deposits`
group by `deposit_group`, `magic_wand_creator`
order by `magic_wand_creator`,`deposit_group`;

SELECT 
    CASE
        WHEN age <= 10 THEN '[0-10]'
        WHEN age <= 20 THEN '[11-20]'
        WHEN age <= 30 THEN '[21-30]'
        WHEN age <= 40 THEN '[31-40]'
        WHEN age <= 50 THEN '[41-50]'
        WHEN age <= 60 THEN '[51-60]'
        ELSE '[61+]'
    END AS e,
    COUNT(*) AS e1
FROM
    `wizzard_deposits`
GROUP BY e
order by e1;

select left(`first_name`,1) as e from `wizzard_deposits`
where `deposit_group`="Troll Chest"
group by e
order by e;

select `deposit_group`,`is_deposit_expired`,avg(`deposit_interest`) from `wizzard_deposits`
where `deposit_start_date`>"1985-01-01"
group by `deposit_group`,`is_deposit_expired`
order by `deposit_group` desc,
`is_deposit_expired`;

select `department_id`,min(salary) from `employees`
where `department_id` in (2,5,7)
and `hire_date`>"2000-01-01"
group by `department_id`
order by `department_id`;

select `department_id`,if(`department_id`=1,avg(salary)+5000,avg(salary)) from `employees`
where salary>30000 and `manager_id`!=42
group by `department_id`
order by `department_id`;

select `department_id`,max(`salary`) as e from `employees`
group by `department_id`
having e not between 30000 and 70000
order by `department_id`;

select count(salary) from `employees`
where `manager_id` is null;

SELECT 
    `department_id`,
    (SELECT distinct
            `salary`
        FROM
            `employees` AS e2
            where e1.department_id=e2.department_id
            order by salary desc
            limit 2,1) as "third"
FROM
    `employees` AS e1
    group by department_id
    having third is not null
    order by department_id;

select e1.first_name,e1.last_name,e1.department_id from `employees` as e1
join(
select e2.department_id,avg(`salary`) as e
from `employees` as e2
group by `department_id`) as average on e1.department_id=average.department_id
where e1.salary>average.e
order by e1.department_id,e1.employee_id
limit 10;

select `department_id`,sum(salary) from `employees`
group by department_id
order by department_id;

select * from `employees`  
