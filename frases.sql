DROP TABLE IF EXISTS frases;
DROP TABLE IF EXISTS autores;

-- tabla autores
CREATE TABLE autores (
  idautor       int(11) NOT NULL AUTO_INCREMENT,
  autor         varchar(100) NOT NULL,
  PRIMARY KEY (idautor),
  UNIQUE KEY IDX_autores_1 (autor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO autores(autor) VALUES('Albert Einstein');
INSERT INTO autores(autor) VALUES('Jorge Luis Borges');
INSERT INTO autores(autor) VALUES('Miguel de Cervantes Saavedra');


-- tabla frases
CREATE TABLE frases (
  idfrase       int(11) NOT NULL AUTO_INCREMENT,
  idautor       int(11) NOT NULL,
  frase         text NOT NULL,
  PRIMARY KEY (idfrase),
  KEY FK_frases_1 (idautor),
  CONSTRAINT FK_frases_1 FOREIGN KEY (idautor) REFERENCES autores (idautor) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO frases(idautor, frase) VALUES(1, 'Yo no hablo de venganzas ni perdones, el olvido es la única venganza y el único perdón.');
INSERT INTO frases(idautor, frase) VALUES(1, 'He cometido el peor pecado que uno puede cometer. No he sido feliz.');
INSERT INTO frases(idautor, frase) VALUES(2, '¿Qué locura o qué desatino me lleva a contar las ajenas faltas, teniendo tanto que decir de las mías');
INSERT INTO frases(idautor, frase) VALUES(2, 'No ames lo que eres, sino lo que puedes llegar a ser.');
INSERT INTO frases(idautor, frase) VALUES(3, 'Intenta no volverte un hombre de éxito, sino volverte un hombre de valor.');
INSERT INTO frases(idautor, frase) VALUES(3, 'La memoria es la inteligencia de los tontos.');
INSERT INTO frases(idautor, frase) VALUES(3, 'No entiendes realmente algo a menos que seas capaz de explicarselo a tu abuela.');
