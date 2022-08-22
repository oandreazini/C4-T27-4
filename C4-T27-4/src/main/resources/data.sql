use heroku_0d3d9a2e88b6da5;

DROP table IF EXISTS `reservas`;
DROP table IF EXISTS `investigadores`;
DROP table IF EXISTS `equipos`;
DROP TABLE IF EXISTS `facultades`;

CREATE TABLE `facultades` (
  `id` int NOT NULL auto_increment,
  `nombre` nvarchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

insert into `facultades` (`nombre`) values('UB');
insert into `facultades` (`nombre`) values('UOC');
insert into `facultades` (`nombre`) values('UPC');

CREATE TABLE `investigadores` (
  `id` int NOT NULL auto_increment,
  `dni` nvarchar(8) NOT NULL,
  `nombre_apellidos` nvarchar(255) NOT NULL,
  `facultad` int NOT NULL,
  CONSTRAINT `FK_id_facultad` FOREIGN KEY (`facultad`) REFERENCES `facultades` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`id`)
);

insert into `investigadores` (`dni`, `nombre_apellidos`, `facultad`) values ('1234567A', 'Andrea Gonzales', 1 );
insert into `investigadores` (`dni`, `nombre_apellidos`, `facultad`) values ('8527419R',  'Pau Petit', 11);
insert into `investigadores` (`dni`, `nombre_apellidos`, `facultad`) values ('4563212P',  'Laura Tullit', 21);

CREATE TABLE `equipos` (
  `id` int NOT NULL auto_increment,
  `nombre` nvarchar(100) NOT NULL,
  `facultad` int NOT NULL,
  CONSTRAINT `FK_facultad_id` FOREIGN KEY (`facultad`) REFERENCES `facultades` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`id`)
);

insert into `equipos` ( `nombre`, `facultad`) values ( 'Un dos tres', 1);
insert into `equipos` ( `nombre`, `facultad`) values ( 'Oleee', 11);
insert into `equipos` ( `nombre`, `facultad`) values ( 'Venga yaa', 21);

CREATE TABLE `reservas` (
  `id` int NOT NULL auto_increment,
  `id_investigadores` int NOT NULL,
  `id_equipos` int NOT NULL,
  `comienzo` dateTime NOT NULL,
  `fin` dateTime NOT NULL,
  CONSTRAINT `FK_investigadores_id` FOREIGN KEY (`id_investigadores`) REFERENCES `investigadores` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_equipos_id` FOREIGN KEY (`id_equipos`) REFERENCES `equipos` (`id`) 
  ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`id`)
);

insert into `reservas`  (`id_investigadores`, `id_equipos`, `comienzo`, `fin`) values ( '1' , '1', '2022-02-15', '2022-02-15');
insert into `reservas`  (`id_investigadores`, `id_equipos`, `comienzo`, `fin`) values ( '11' , '11',  '2022-02-15', '2022-02-15');
insert into `reservas`  (`id_investigadores`, `id_equipos`, `comienzo`, `fin`) values ( '21', '21' ,  '2022-02-15', '2022-02-15');






