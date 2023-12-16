package mr.iscae.Controller;

import mr.iscae.entity.Reservation;
import mr.iscae.entity.Utilisateur;
import mr.iscae.service.ReservationService;
import mr.iscae.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;
    @GetMapping("/user/{id}")
    public Utilisateur getuser(@PathVariable Long id){

        return userService.getUserById(id);
    }

    @PostMapping("/addreservation")
    public Reservation efectuereservation(Reservation reservation){
        return reservationService.create(reservation);
    }
}
