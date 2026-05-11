package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.domain.Materia;
import sv.edu.udb.repository.MateriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/materias")//endpoit principal
public class MateriaController {

    //Inyección de dependencia del
    // repositorio para acceder a operaciones CRUD
    @Autowired
    private MateriaRepository materiaRepo;

    @GetMapping
    public List<Materia> listar(){
        return materiaRepo.findAll();
    }

    @PostMapping
    public Materia guardar(@RequestBody Materia materia){
        return materiaRepo.save(materia);
    }

    @PutMapping("/{id}")
    public Materia actualizar(@PathVariable Long id, @RequestBody Materia materia){
        materia.setId(id);
        return materiaRepo.save(materia);
    }

    //-----Metodo devuelve un mensaje de confirmacion
    //----al procesar la eliminacion
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if (!materiaRepo.existsById(id)){
            return "Materia no encontrada";
        }
        materiaRepo.deleteById(id);
        return "Materia eliminada correctamente";
    }
}