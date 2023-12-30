package mr.iscae.service;

import mr.iscae.entity.Reservation;


import java.util.List;

public interface ReservationService {
    public List<Reservation> findAll();

    public Reservation create(Reservation reservation);

    public Boolean delete(Long id);
}
