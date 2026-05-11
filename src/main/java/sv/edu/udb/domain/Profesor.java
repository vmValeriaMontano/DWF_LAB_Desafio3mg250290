package sv.edu.udb.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {

    //id automático
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    //-----Se borra sus materias
    //-----Se borran inscripciones de esas materias
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Materia> materias;

    //Constructor vacío
    public Profesor() {
    }

    //constructor con parametros
    public Profesor( String nombre) {
        this.nombre = nombre;
    }

    //Getter y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
