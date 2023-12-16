package mr.iscae.Controller;

import mr.iscae.entity.Appartement;
import mr.iscae.entity.Reservation;
import mr.iscae.entity.Utilisateur;
import mr.iscae.service.AppartementService;
import mr.iscae.service.ReservationService;
import mr.iscae.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService  userService;
    @Autowired
    private AppartementService appartementService;

    @Autowired
    private ReservationService reservationService;
    // users methods
    @PostMapping("/adduser")
    public Utilisateur saveuser(@RequestBody Utilisateur user){
         return userService.create(user);
    }
    @GetMapping("/user/{id}")
    public Utilisateur getuser(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping("/alluser")
    public List<Utilisateur> getallusers(){
        return userService.findAll();
    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
    // appartemts methods
    @PostMapping("/addappartement")
    public Appartement ajouterappartement(@RequestBody Appartement appartement){
        return appartementService.create(appartement);
    }
    @GetMapping("/allappartement")
    public List<Appartement> getallappartement(){

        return appartementService.findAll();
    }
    @GetMapping("/appartement/{id}")
    public Appartement getappartement(@PathVariable Long id){

        return appartementService.getAppartementById(id);
    }
    @DeleteMapping("/appartement/{id}")
    public void deleteappartement(@PathVariable Long id){

        appartementService.delete(id);
    }
    //Reservation methodes
    @GetMapping("/allreservations")
    public List<Reservation> allreservations(){
        return reservationService.findAll();
    }
    @DeleteMapping("annuler/{id}")
    public void anullerreservation(@PathVariable Long id){
        reservationService.delete(id);
    }

}
