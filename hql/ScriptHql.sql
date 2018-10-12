select * from departamentos;

select * from distritos;

select * from departamentos;

select * from cliente;

select * from employee;
select * from certificate;
select * from emp_cert;

########################

select * from alumnos;
select * from notas;

select idalumno,count(idnota) from notas
group by idalumno;

select a.nombre,
case
		when count(n.idnota) = null then 0
		when count(n.idnota) >= 0 then count(n.idnota)
end
from alumnos a
left join notas n
on a.idalumno = n.idalumno
group by a.nombre;

########################

select dep.departamento,p.provincia,d.distrito from departamentos dep
inner join provincias p
on dep.iddepartamento = p.iddepartamento
inner join distritos d
on p.idprovincia = d.idprovincia;

###############