# Write your MySQL query statement below


# to find out the ids of the day where the current record
# date temp is higher than the date previous to it and return
# those ids

select c.id
from weather c
join weather p
on c.recordDate = DATE_ADD(p.recordDate, Interval 1 Day)
where c.temperature > p.temperature;
    