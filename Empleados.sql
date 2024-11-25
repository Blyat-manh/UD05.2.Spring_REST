drop database gestionNominas2;
create database gestionNominas2;
use gestionNominas2;

CREATE TABLE nomina (
    categoria INT PRIMARY KEY,
    sueldo INT
);

INSERT INTO nomina (categoria, sueldo) VALUES 
(1, 50000), 
(2, 70000), 
(3, 90000), 
(4, 110000), 
(5, 130000), 
(6, 150000), 
(7, 170000), 
(8, 190000), 
(9, 210000), 
(10, 230000);


CREATE TABLE empleado (
    nombre VARCHAR(50),
    dni VARCHAR(10) PRIMARY KEY,
    sexo CHAR(1),
    categoria INT,
    anyos INT
);


drop table salarios;

CREATE TABLE salarios (
    dni VARCHAR(10) PRIMARY KEY,
    salario INT
);
