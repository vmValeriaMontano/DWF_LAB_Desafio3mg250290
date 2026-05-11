package sv.edu.udb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.domain.AlumnoMateria;
import sv.edu.udb.domain.AlumnoMateriaId;

//tomamos la clave compuesta
public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, AlumnoMateriaId> {
}
