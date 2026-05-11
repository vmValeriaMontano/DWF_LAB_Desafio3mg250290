package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.domain.Alumno;
import sv.edu.udb.repository.AlumnoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")//endpoit principal
public class AlumnoController {

    //Inyección de dependencia del
    // repositorio para acceder a operaciones CRUD
    @Autowired
    private AlumnoRepository repo;

    @GetMapping
    public List<Alumno> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Alumno guardar(@RequestBody Alumno alumno){
        return repo.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable Long id, @RequestBody Alumno alumno){
        alumno.setId(id);
        return repo.save(alumno);
    }

    //----Metodo devuelve un mensaje de confirmacion
    //----al procesar la eliminacion
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(!repo.existsById(id)){
            return "Alumno no encontrado";
        }

        repo.deleteById(id);
        return "Alumno eliminado correctamente";
    }
}