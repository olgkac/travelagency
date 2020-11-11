-- zad1 v1- ile rezerwacji na dany cel podrozy
select d.name
from destination d join trip t on t.destination_id = d.id
join reservation r on r.trip_id = t.id
where extract(year from t.start_date) = 2020
group by (d.name)
order by count(*) desc limit 1;

-- zad1 v2- ile roznych klientow na dany cel podrozy
select place
from (select distinct r.client_id as cliente, d.name as place
from reservation r
join trip t on r.trip_id = t.id
join destination d on d.id = t.destination_id) as client_place
group by place
order by count(*) desc limit 1;

-- zad2
select c.id, c.first_name, c.last_name
from client c left join reservation r on c.id = r.client_id
left join trip t on t.id = r.trip_id
where extract(year from t.start_date) = 2020 or t.start_date is null
group by c.id, c.first_name, c.last_name
having count(t.id) = 0;

-- zad3
select sum(r.price), avg(r.price), t.id
from trip t join reservation r on t.id = r.trip_id
group by t.id;

-- zad4
select g.first_name, g.last_name
from guide g join trip t on g.id = t.guide_id
join reservation r on r.trip_id = r.id
where extract(year from t.start_date) = 2020
group by g.first_name, g.last_name
order by sum(r.price) desc
limit 1;


-- zad5
select c.first_name, c.last_name, c.passport_number
from trip t join reservation r on r.trip_id = t.id
join client c on c.id = r.client_id
order by (t.default_price - r.price) desc limit 1;

