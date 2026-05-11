package sv.edu.udb.domain;

import jakarta.persistence.*;

//tabla que nos servira para nuestro LOGIN
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String rol;

}
