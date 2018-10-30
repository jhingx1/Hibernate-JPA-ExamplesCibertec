DROP TABLE IF EXISTS preguntas;
DROP TABLE IF EXISTS examenes;

CREATE TABLE examenes (
    idexamen int(11) NOT NULL AUTO_INCREMENT,
    titulo varchar(200) NOT NULL,
    descripcion text DEFAULT NULL,
    duracion int(11) NOT NULL COMMENT 'minutos que dura examen',
    publicacion date NOT NULL COMMENT 'fecha de creacion de examen',
    minimanota double(13,2) NOT NULL COMMENT 'nota minima para aprobar',
    activo char(1) NOT NULL DEFAULT 'S'  COMMENT 'S==Si, N==No',

    PRIMARY KEY (idexamen)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE preguntas (
    idpregunta int(11) NOT NULL AUTO_INCREMENT,
    idexamen int(11) NOT NULL,
    pregunta text NOT NULL,
    prioridad int(11) NOT NULL,

    PRIMARY KEY (idpregunta),
    KEY FK_preguntas_2 (idexamen),
    CONSTRAINT FK_preguntas_2 FOREIGN KEY (idexamen) 
        REFERENCES examenes (idexamen) 
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

