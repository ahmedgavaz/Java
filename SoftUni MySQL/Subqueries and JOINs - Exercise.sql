select e.employee_id,e.job_title,a.address_id,a.address_text from employees as e
join addresses as a
on e.address_id=a.address_id
order by a.address_id
limit 5;

select e.first_name,e.last_name,t.name,a.address_text from employees as e
join addresses as a on e.address_id=a.address_id
join towns as t on t.town_id=a.town_id
order by first_name,last_name
limit 5;

select e.employee_id,e.first_name,e.last_name,d.name from employees as e
join departments as d on e.department_id=d.department_id
where d.name="Sales"
order by employee_id desc;

select employee_id,first_name,salary,d.name from  employees as e
join departments as d on d.department_id=e.department_id
where e.salary>15000
order by d.department_id desc
limit 5;

select e.employee_id,e.first_name from employees as e
left join employees_projects as ep on ep.employee_id=e.employee_id
left join projects as p on ep.project_id=p.project_id 
where p.project_id is NULL
order by employee_id desc
limit 3;

select first_name,last_name,hire_date,d.name from employees as e
join departments as d on e.department_id=d.department_id
where hire_date>"1999-01-01" and d.name in ("Sales","Finance")
order by hire_date;

select e.employee_id,e.first_name,p.name from employees as e
join employees_projects as ep on e.employee_id=ep.employee_id
join projects as p on p.project_id=ep.project_id
where DATE(p.start_date)>"2002-08-13" and p.end_date is NULL
order by first_name,p.name
limit 5;

select e.employee_id,e.first_name,if(YEAR(p.start_date)>=2005,NULL,p.name) from employees as e
join employees_projects as ep on e.employee_id=ep.employee_id
join projects as p on p.project_id=ep.project_id
where e.employee_id=24
order by p.name;

select e.employee_id,e.first_name,e.manager_id,e1.first_name from employees as e
join employees as e1 on e.manager_id=e1.employee_id
where e.manager_id in (3,7)
order by e.first_name;

select e.employee_id,concat(e.first_name," ",e.last_name),concat(e1.first_name," ",e1.last_name),d.name from employees as e
join employees as e1 on e.manager_id=e1.employee_id
join departments as d on e.department_id=d.department_id
order by employee_id
limit 5;

select avg(salary) as min from employees as e
group by department_id
order by min 
limit 1;

select c.country_code,m.mountain_range,p.peak_name,p.elevation from countries as c
join mountains_countries as mc on mc.country_code=c.country_code
join mountains as m on m.id=mc.mountain_id
join peaks as p on p.mountain_id=m.id
where c.country_code="BG" and p.elevation>2835
order by p.elevation desc;

select c.country_code,count(m.mountain_range) as s from countries as c
join mountains_countries as mc on mc.country_code=c.country_code
join mountains as m on m.id=mc.mountain_id
where c.country_code in ("BG","RU","US")
group by c.country_code
order by s desc;

select c.country_name,r.river_name from countries as c 
left join countries_rivers as cr on c.country_code=cr.country_code
left join rivers as r on r.id=cr.river_id
where c.continent_code="AF"
order by country_name
limit 5;

select continent_code,currency_code,count(*) as cu from countries as c 
group by c.continent_code,c.currency_code
having cu>1 and (cu) = (select 
count(*) as mu 
from countries as c1 
where c1.continent_code=c.continent_code 
group by c1.currency_code 
order by mu desc 
limit 1)
order by c.continent_code,c.currency_code;

select count(c.country_code) from countries as c
left join mountains_countries as mc on mc.country_code=c.country_code
left join mountains as m on m.id=mc.mountain_id
where m.id is NULL;

select c.country_name,max(p.elevation) as me,max(r.length) as ml from countries as c
left join mountains_countries as mc on c.country_code=mc.country_code
left join peaks as p on p.mountain_id=mc.mountain_id
left join countries_rivers as cr on cr.country_code=c.country_code
left join rivers as r on r.id=cr.river_id
group by c.country_name
order by me desc,ml desc, country_name
limit 5;
