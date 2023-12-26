package mr.iscae.service;

import java.util.List;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import mr.iscae.entity.Appartement;

//@Service
public interface AppartementServices {


    public List<Appartement> findAll();

    public Appartement create(Appartement appartement);

    public Boolean delete(Long id);

    public Appartement findById(Long id);

    public String update(Appartement appartement, Long id);

    public List<Appartement> findByName(String name);

    public ResponseEntity<Object> getCompanyServers(Long idappartement);

}
