package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.domain.Profesor;
import sv.edu.udb.repository.ProfesorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")//endpoit principal
public class ProfesorController {

    //Inyección de dependencia del
    // repositorio para acceder a operaciones CRUD
    @Autowired
    private ProfesorRepository repo;

    @GetMapping
    public List<Profesor> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Profesor guardar(@RequestBody Profesor profesor){
        return repo.save(profesor);
    }

    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Long id, @RequestBody Profesor profesor){
        profesor.setId(id);
        return repo.save(profesor);
    }

    //-----Metodo devuelve un mensaje de confirmacion
    //----al procesar la eliminacion
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){

        if (!repo.existsById(id)){
            return "Profesor no encontrado";
        }

        repo.deleteById(id);
        return "Profesor eliminado correctamente";
    }
}