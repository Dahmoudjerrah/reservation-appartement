package mr.iscae.service;

import mr.iscae.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public interface ReservationService {
    public List<Reservation> findAll();

    public Reservation create(Reservation reservation);

    public Boolean delete(Long id);
}
