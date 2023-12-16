package mr.iscae.service;

import mr.iscae.entity.Appartement;
import mr.iscae.repositrie.AppartementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartementService {
    @Autowired
    private AppartementRepo appartementRepo;
    public List<Appartement> findAll(){
        return appartementRepo.findAll();
    }
    public Appartement create(Appartement appartement){
        return appartementRepo.save(appartement);
    }
    public Appartement getAppartementById(Long id){
        return appartementRepo.findById(id).get();
    }
    public Boolean delete(Long id){
        Optional<Appartement> userOptional=appartementRepo.findById(id);
        if(userOptional.isPresent()){
            appartementRepo.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
