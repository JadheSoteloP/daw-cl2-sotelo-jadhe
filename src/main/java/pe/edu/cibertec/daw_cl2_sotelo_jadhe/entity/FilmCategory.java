package pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private Film film;

    private Date lastUpdate;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FilmCategoryId implements Serializable {
        private Integer categoryId;
        private Integer filmId;
    }
}