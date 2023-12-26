package mr.iscae.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appartement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int nbr_de_chambers;
    private double prix;
    // @OneToMany(cascade = CascadeType.ALL)
    // private List<Reservation> reservations = new ArrayList();

}
