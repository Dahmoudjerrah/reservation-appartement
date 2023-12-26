package mr.iscae.service.serviceImpl;

import mr.iscae.entity.Reservation;
import mr.iscae.repositrie.ReservationRepo;
import mr.iscae.service.ReservationService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepo repository;

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }
    @Override
    public Reservation create(Reservation reservation) {
        
        return repository.save(reservation);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Reservation> reservationOptional = repository.findById(id);
        if (reservationOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
