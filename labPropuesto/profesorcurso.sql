-- MySQL Workbench Forward Engineering

DROP TABLE IF EXISTS cursos;
DROP TABLE IF EXISTS profesores;

-- -----------------------------------------------------
-- Schema parainfo
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `parainfo`.`profesores`
-- -----------------------------------------------------
CREATE TABLE profesores(
  idprofesores INT NOT NULL AUTO_INCREMENT,
  nombreprofesores VARCHAR(100) NOT NULL,
  carrera VARCHAR(50) NOT NULL,
  fechaingreso DATE NOT NULL,
  tipocontrato VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idprofesores`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO profesores(nombreprofesores,carrera,fechaingreso,tipocontrato) 
VALUES('Albert Einstein','Lic. Fisica','2018-03-15','Tiempo parcial');
INSERT INTO profesores(nombreprofesores,carrera,fechaingreso,tipocontrato) 
VALUES('Juan Lopez','Ing. Sistemas','2018-07-20','Temporal');
INSERT INTO profesores(nombreprofesores,carrera,fechaingreso,tipocontrato) 
VALUES('Juan Perez','Ing. Electronica','2018-04-20','Ocacional');


-- -----------------------------------------------------
-- Table `parainfo`.`cursos`
-- -----------------------------------------------------
CREATE TABLE cursos(
  idcursos INT NOT NULL AUTO_INCREMENT,
  nombrecursos VARCHAR(50) NOT NULL,
  descripcion VARCHAR(50) NOT NULL,
  fechainicio DATE NOT NULL,
  fechafin DATE NOT NULL,
  tipo VARCHAR(50) NOT NULL,
  horas INT NOT NULL,
  idprofesores INT NOT NULL,
  PRIMARY KEY (idcursos),  
  CONSTRAINT fk_cursos_profesores
    FOREIGN KEY (idprofesores)
    REFERENCES profesores (idprofesores)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB CHARSET=utf8;

INSERT INTO cursos(nombrecursos,descripcion,fechainicio,fechafin,tipo,horas,idprofesores) 
VALUES('Java Fundamentos','Conceptos Basicos Java 8','2017-02-21','2018-02-20','DAT',80,1);

INSERT INTO cursos(nombrecursos,descripcion,fechainicio,fechafin,tipo,horas,idprofesores) 
VALUES('Java WEB','Programacion Web con Java','2018-04-14','2018-06-14','CERTIFICACION',110,2);

INSERT INTO cursos(nombrecursos,descripcion,fechainicio,fechafin,tipo,horas,idprofesores) 
VALUES('Java Avanzado','Uso de Frameworks','2018-02-14','2018-08-14','DIPLOMADO',140,3);



