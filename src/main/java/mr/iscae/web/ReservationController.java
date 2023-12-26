package mr.iscae.web;

import java.util.List;

import mr.iscae.entity.Reservation;
import mr.iscae.service.ReservationService;
import mr.iscae.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(Constants.APP_ROOT+Constants.RESERVATION)
public class ReservationController {
   // @Qualifier("")
    @Autowired
    private ReservationService service;


    @PostMapping("/create")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(reservation));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllServers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
