# Ventas_DAW_Servidores
>### Repositorio para practicar de cara al examen final de Desarrollo Web en entorno Servidor
## BASE DE DATOS PARA EL PROYECTO


DROP DATABASE IF EXISTS ventasbbdd_2023;  
CREATE DATABASE ventasbbdd_2023 CHARACTER SET utf8mb4;  
USE ventasbbdd_2023;  
CREATE TABLE clientes (  
  id_cliente INT  AUTO_INCREMENT PRIMARY KEY,  
  nombre VARCHAR(100) NOT NULL,  
  apellido1 VARCHAR(100) NOT NULL,  
  apellido2 VARCHAR(100),  
  ciudad VARCHAR(100),  
  categoria INT   
);  
CREATE TABLE comerciales (  
  id_comercial INT  AUTO_INCREMENT PRIMARY KEY,  
  nombre VARCHAR(100) NOT NULL,  
  apellido1 VARCHAR(100) NOT NULL,  
  apellido2 VARCHAR(100),  
  comision double  
);  
CREATE TABLE pedidos (  
  id_pedido INT  AUTO_INCREMENT PRIMARY KEY,  
  total DOUBLE NOT NULL,  
  fecha DATE,  
  id_cliente INT  NOT NULL,   
  id_comercial INT  NOT NULL,  
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),  
  FOREIGN KEY (id_comercial) REFERENCES comerciales(id_comercial)  
);  
INSERT INTO clientes VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100);  
INSERT INTO clientes VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200);  
INSERT INTO clientes VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', 200);  
INSERT INTO clientes VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300);  
INSERT INTO clientes VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200);  
INSERT INTO clientes VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100);  
INSERT INTO clientes VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300);  
INSERT INTO clientes VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200);  
INSERT INTO clientes VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225);  
INSERT INTO clientes VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125);  
INSERT INTO comerciales VALUES(1, 'Daniel', 'Sáez', 'Vega', 0.15);  
INSERT INTO comerciales VALUES(2, 'Juan', 'Gómez', 'López', 0.13);  
INSERT INTO comerciales VALUES(3, 'Diego','Flores', 'Salas', 0.11);  
INSERT INTO comerciales VALUES(4, 'Marta','Herrera', 'Gil', 0.14);  
INSERT INTO comerciales VALUES(5, 'Antonio','Carretero', 'Ortega', 0.12);  
INSERT INTO comerciales VALUES(6, 'Manuel','Domínguez', 'Hernández', 0.13);  
INSERT INTO comerciales VALUES(7, 'Antonio','Vega', 'Hernández', 0.11);  
INSERT INTO comerciales VALUES(8, 'Alfredo','Ruiz', 'Flores', 0.05);  
INSERT INTO pedidos VALUES(1, 150.5, '2017-10-05', 5, 2);  
INSERT INTO pedidos VALUES(2, 270.65, '2016-09-10', 1, 5);  
INSERT INTO pedidos VALUES(3, 65.26, '2017-10-05', 2, 1);  
INSERT INTO pedidos VALUES(4, 110.5, '2016-08-17', 8, 3);  
INSERT INTO pedidos VALUES(5, 948.5, '2017-09-10', 5, 2);  
INSERT INTO pedidos VALUES(6, 2400.6, '2016-07-27', 7, 1);  
INSERT INTO pedidos VALUES(7, 5760, '2015-09-10', 2, 1);  
INSERT INTO pedidos VALUES(8, 1983.43, '2017-10-10', 4, 6);  
