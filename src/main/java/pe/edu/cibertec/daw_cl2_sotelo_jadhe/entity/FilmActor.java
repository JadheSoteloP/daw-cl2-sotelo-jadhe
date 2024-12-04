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
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private Film film;

    private Date lastUpdate;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FilmActorId implements Serializable {
        private Integer actorId;
        private Integer filmId;
    }
}
