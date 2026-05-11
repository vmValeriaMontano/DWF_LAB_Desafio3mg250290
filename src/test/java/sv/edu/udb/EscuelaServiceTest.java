package sv.edu.udb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sv.edu.udb.service.EscuelaService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EscuelaServiceTest {

    //Inyeccion de dependencia
    @Autowired
    private EscuelaService escuelaService;

    @Test
    @Commit
    void insertarProfesor(){
        // Inseratr dos filas de tabla profesor
        var proferso1 = escuelaService.guardarProfesor("Profesor A");
        var proferso2 = escuelaService.guardarProfesor("Profesor B");
        //verificamos que no es NULL
        assertNotNull(proferso1.getId());
        assertNotNull(proferso2.getId());
    }

    @Test
    @Commit
    void insertarAlumnos(){
        // Inseratr dos filas de tabla alumno

        var alumno1 = escuelaService.guardarAlumno("Valeria", "Montano");
        var alumno2 = escuelaService.guardarAlumno("Santiago", "Mejia");
        //verificamos que no es NULL
        assertNotNull(alumno1.getId());
        assertNotNull(alumno2.getId());
    }

    @Test
    @Commit
    void insertarMaterias(){
        //OneToMany: profesor-materia  ...  ManyToOne: materia-profesor
        //1-proferos
        var profesor = escuelaService.guardarProfesor("Profesor X");
        //2- materia
        var materia1 = escuelaService.guardarMateria("Frameworks", profesor.getId());
        var materia2 = escuelaService.guardarMateria("Base de Datos", profesor.getId());
        //verificamos que no es NULL
        assertNotNull(materia1.getId());
        assertNotNull(materia2.getId());

        //Materia y profesor asociadas
        //ManyToOne
        assertNotNull(materia1.getProfesor());
        assertEquals(profesor.getId(), materia1.getProfesor().getId());
    }

    @Test
    @Commit
    void inscribirAlumno(){

        //1- profesor
        var profesor = escuelaService.guardarProfesor("Profesor Y");
        //2- alumno
        var alumno1 = escuelaService.guardarAlumno("Ana", "Perez");
        var alumno2 = escuelaService.guardarAlumno("Luis", "Martinez");
        //3- materia
        var materia = escuelaService.guardarMateria("Java", profesor.getId());
        //verificamos que no es NULL
        assertNotNull(alumno1.getId());
        assertNotNull(alumno2.getId());
        assertNotNull(materia.getId());

        //llamar
        escuelaService.inscribirAlumno(alumno1.getId(), materia.getId());
        escuelaService.inscribirAlumno(alumno2.getId(), materia.getId());

    }
}
