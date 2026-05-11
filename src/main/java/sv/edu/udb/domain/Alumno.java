package sv.edu.udb.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {

    //id automático
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    //-----Se borran sus inscripciones
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlumnoMateria> inscripciones;

    //Contructor vacio
    public Alumno() {
    }

    //constructor y parámetros
    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters y Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
