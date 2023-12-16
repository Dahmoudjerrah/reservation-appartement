package mr.iscae.service;

import mr.iscae.entity.Reservation;
import mr.iscae.repositrie.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    public Reservation create(Reservation reservation){
        return reservationRepo.save(reservation);
    }
    public List<Reservation> findAll(){
        return reservationRepo.findAll();
    }
    public String delete(Long id){
        Optional<Reservation> reservationOptional=reservationRepo.findById(id);
        if(reservationOptional.isPresent()){
            reservationRepo.deleteById(id);
            return "reservation annuler";
        }
        else{
            return "reservation nexist pas";
        }
    }
}
