create database integrador_java;
use integrador_java;
CREATE TABLE contactos (
  id_contacto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  email VARCHAR(255),
  telefono VARCHAR(255),
  mensaje VARCHAR(255),
  fecha_alta date,
  curso INT
);
select * from contactos;
