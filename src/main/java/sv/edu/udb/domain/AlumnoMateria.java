package sv.edu.udb.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "alumno_materia")
public class AlumnoMateria {

    //Primary KEY
    @EmbeddedId
    private AlumnoMateriaId id; //traemos clas AlumnoMateriaId

    //Foreign KEYs
    @ManyToOne
    @MapsId("idAlumno")
    @JoinColumn(name = "id_alumno")
    @OnDelete(action = OnDeleteAction.CASCADE) //si elimina alumno, se borra su historial de inscripciones
    private Alumno alumno;

    @ManyToOne
    @MapsId("idMateria")
    @JoinColumn(name = "id_materia")
    @OnDelete(action = OnDeleteAction.CASCADE) //si materia desaparece, se eliminan inscripciones asociadas.
    private Materia materia;


    public AlumnoMateria() {
    }

    public AlumnoMateria(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        //traemos objetos alumno y materia extare IDs y
        // crea objeto AlumnoMateriId
        this.id= new AlumnoMateriaId(alumno.getId(), materia.getId());
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }
}
