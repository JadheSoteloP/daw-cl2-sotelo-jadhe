package pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

    public class Rental {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer rentalId;

        @ManyToOne
        @JoinColumn(name = "inventory_id", nullable = false)
        private Inventory inventory;

        @Column(name = "rental_date")
        private Date rentalDate;

        @Column(name = "return_date")
        private Date returnDate;

    }

