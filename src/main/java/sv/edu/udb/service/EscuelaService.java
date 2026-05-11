package sv.edu.udb.service;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import sv.edu.udb.domain.*;
import sv.edu.udb.repository.*;

@Service
@Transactional
public class EscuelaService {

    private final ProfesorRepository profesorRepository;
    private final AlumnoRepository alumnoRepository;
    private final MateriaRepository materiaRepository;
    private final AlumnoMateriaRepository alumnoMateriaRepository;

    public EscuelaService(ProfesorRepository profesorRepository,
                          AlumnoRepository alumnoRepository,
                          MateriaRepository materiaRepository,
                          AlumnoMateriaRepository alumnoMateriaRepository) {
        this.profesorRepository = profesorRepository;
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
        this.alumnoMateriaRepository = alumnoMateriaRepository;
    }

    public Profesor guardarProfesor(String nombre) {
        return profesorRepository.save(new Profesor(nombre));
    }

    public Alumno guardarAlumno(String nombre, String apellido) {
        return alumnoRepository.save(new Alumno(nombre, apellido));
    }

    public Materia guardarMateria(String nombre, Long idProfesor) {
        Profesor profesor = profesorRepository.findById(idProfesor)
                .orElseThrow();
        return materiaRepository.save(new Materia(nombre, profesor));
    }

    public AlumnoMateria inscribirAlumno(Long idAlumno, Long idMateria) {
        Alumno alumno = alumnoRepository.findById(idAlumno).orElseThrow();
        Materia materia = materiaRepository.findById(idMateria).orElseThrow();
        return alumnoMateriaRepository.save(new AlumnoMateria(alumno, materia));
    }
}