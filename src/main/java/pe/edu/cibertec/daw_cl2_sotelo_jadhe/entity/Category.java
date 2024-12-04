package pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;
    private Date lastUpdate;

    // RELACION CON FILM POR MEDIO DE FILMCATEGORY
    @OneToMany(mappedBy = "category")
    private List<FilmCategory> filmCategories;
}