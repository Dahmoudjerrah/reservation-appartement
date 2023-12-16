package mr.iscae.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_debut;
    private Date date_fin;
    @ManyToOne
    @JoinColumn(name="appartement_id")
    private Appartement appartement;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Utilisateur client;

}
