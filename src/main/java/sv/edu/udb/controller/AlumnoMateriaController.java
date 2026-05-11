package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.domain.Alumno;
import sv.edu.udb.domain.AlumnoMateria;
import sv.edu.udb.domain.Materia;
import sv.edu.udb.repository.AlumnoMateriaRepository;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.repository.MateriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")//endpoit principal
public class AlumnoMateriaController {

    //Inyección de dependencias del
    // repositorio para acceder a operaciones CRUD
    @Autowired
    private AlumnoMateriaRepository repo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private MateriaRepository materiaRepo;

    @GetMapping
    public List<AlumnoMateria> listar(){
        return repo.findAll();
    }

    @PostMapping
    public AlumnoMateria inscribir(@RequestParam Long alumnoId, @RequestParam Long materiaId){

        Alumno alumno = alumnoRepo.findById(alumnoId).orElseThrow();
        Materia materia = materiaRepo.findById(materiaId).orElseThrow();

        return repo.save(new AlumnoMateria(alumno, materia));
    }

    //-----Metodo devuelve un mensaje de confirmacion
    //----al procesar la eliminacion
    @DeleteMapping
    public String eliminar(@RequestParam Long alumnoId, @RequestParam Long materiaId){
        var id = new sv.edu.udb.domain.AlumnoMateriaId(alumnoId, materiaId);

        if (!repo.existsById(id)){
            return "Inscripcion no encontrada";
        }

        repo.deleteById(id);
        return "Incripcion eliminada correctamente";
    }
}