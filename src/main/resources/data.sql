----------------DATOS
-- Profesores
INSERT INTO profesor (nombre) VALUES ('Carlos Martinez');
INSERT INTO profesor (nombre) VALUES ('Ana Lopez');
INSERT INTO profesor (nombre) VALUES ('Mario Ruiz');
INSERT INTO profesor (nombre) VALUES ('Lucia Torres');
INSERT INTO profesor (nombre) VALUES ('Jose Hernandez');

-- Materias
INSERT INTO materia (nombre, id_profesor) VALUES ('Matematica', 1);
INSERT INTO materia (nombre, id_profesor) VALUES ('Programacion', 2);
INSERT INTO materia (nombre, id_profesor) VALUES ('Fisica', 3);
INSERT INTO materia (nombre, id_profesor) VALUES ('Base de Datos', 4);
INSERT INTO materia (nombre, id_profesor) VALUES ('Redes', 5);

-- Alumnos
INSERT INTO alumno (nombre, apellido) VALUES ('Juan', 'Perez');
INSERT INTO alumno (nombre, apellido) VALUES ('Maria', 'Gomez');
INSERT INTO alumno (nombre, apellido) VALUES ('Luis', 'Ramirez');
INSERT INTO alumno (nombre, apellido) VALUES ('Sofia', 'Castro');
INSERT INTO alumno (nombre, apellido) VALUES ('Andres', 'Vasquez');

-- Inscripciones
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES (1,1);
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES (1,2);
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES (2,3);
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES (3,4);
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES (4,5);
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES (5,1);