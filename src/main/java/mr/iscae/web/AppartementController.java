package mr.iscae.web;

import java.util.List;

import mr.iscae.entity.Appartement;
import mr.iscae.service.AppartementServices;
import mr.iscae.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(Constants.APP_ROOT+Constants.APPARTEMENT)

public class AppartementController {
    @Autowired
    private AppartementServices service;

    @PostMapping
    public ResponseEntity<Appartement> create(@RequestBody Appartement appartement ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(appartement));
    }

    @GetMapping
    public ResponseEntity<List<Appartement>> getAllappartement(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
         

    @GetMapping("/{id}")
    public ResponseEntity<Appartement> getCompanyByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Appartement> delete(@PathVariable("id") Long id){
    //     return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    // }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Appartement appartement, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(appartement, id));
    }

    @GetMapping("/company-servers/{idCompany}")
    public ResponseEntity<Object> getCompanyServers(@PathVariable Long idCompany){
        return service.getCompanyServers(idCompany);
    }
}
