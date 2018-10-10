DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS CERTIFICATE;

create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);

-- insertando filas
--INSERT INTO EMPLOYEE(first_name, last_name, salary) 
--VALUES('Juan', 'Perez',1200);

--INSERT INTO EMPLOYEE(first_name, last_name, salary) 
--VALUES('Dino', 'Suarez',1500);

---Para ejm, de tener una lista set como atributo.
create table CERTIFICATE (
   id INT NOT NULL auto_increment,
   certificate_name VARCHAR(30) default NULL,
   idx INT default NULL, ----Columna de indice, define la posicion del elemento en la coleccion.
   employee_id INT default NULL,
   PRIMARY KEY (id)
);