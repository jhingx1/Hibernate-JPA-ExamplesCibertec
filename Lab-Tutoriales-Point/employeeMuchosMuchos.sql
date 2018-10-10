DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS CERTIFICATE;
DROP TABLE IF EXISTS EMP_CERT;

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
   PRIMARY KEY (id)
);

create table EMP_CERT (
   employee_id INT NOT NULL,
   certificate_id INT NOT NULL,
   PRIMARY KEY (employee_id,certificate_id)
);

