package sv.edu.udb.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//Tabla intermedia
@Embeddable //clave compuesta
public class AlumnoMateriaId implements Serializable {

    private Long idAlumno;
    private Long idMateria;

    public AlumnoMateriaId() {
    }

    public AlumnoMateriaId(Long idAlumno, Long idMateria) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    // getters y setters
    public Long getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdMateria() {
        return idMateria;
    }
    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    //comparacion de objetos
    public boolean equals(Object o){
        if(this==o) return true;
        if (!(o instanceof AlumnoMateriaId)) return false;
        //compara y ve si van en la misma fila de la tabla
        AlumnoMateriaId that = (AlumnoMateriaId) o;
        return Objects.equals(idAlumno, that.idAlumno) &&
                Objects.equals(idMateria, that.idMateria);
    }

    //genreamos id unicos con hashCode
    @Override
    public int hashCode(){
        return Objects.hash(idAlumno, idMateria);
    }
}
