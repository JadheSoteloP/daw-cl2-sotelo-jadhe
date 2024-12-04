package pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    private String firstName;
    private String lastName;
    private Date lastUpdate;

    // RELACION CON FILM POR MEDIO DE FILMACTOR
    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;
}