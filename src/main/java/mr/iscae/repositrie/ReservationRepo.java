package mr.iscae.repositrie;

import mr.iscae.entity.Appartement;
import mr.iscae.entity.Reservation;
import mr.iscae.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
   // List<Reservation> findByClient(AppUser utilisateur);
    public List<Reservation> findByAppartement(Appartement appartement);
   // Long countByclient(Long clientid);
}
