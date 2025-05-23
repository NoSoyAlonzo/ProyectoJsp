CREATE DATABASE escuela;
USE escuela;
SELECT user, host FROM mysql.user;


CREATE TABLE Maestro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    email VARCHAR(100),
    contrasena VARCHAR(100)
);

CREATE TABLE Clase (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    maestro_id INT NOT NULL,
    FOREIGN KEY (maestro_id) REFERENCES Maestro(id)
);

CREATE TABLE Alumno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    clase_id INT NOT NULL,
    FOREIGN KEY (clase_id) REFERENCES Clase(id)
);

CREATE TABLE Asistencia(
	alumno_id INT NOT NULL,
    fecha DATE NOT NULL,
    presente BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY (alumno_id, fecha),
    FOREIGN KEY(alumno_id) REFERENCES Alumno(id)
);



