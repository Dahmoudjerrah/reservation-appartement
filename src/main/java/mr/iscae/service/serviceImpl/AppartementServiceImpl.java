package mr.iscae.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import mr.iscae.entity.Appartement;
import mr.iscae.entity.Reservation;
import mr.iscae.repositrie.AppartementRepo;
import mr.iscae.repositrie.ReservationRepo;
import mr.iscae.service.AppartementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mr.iscae.Dto.AppartemeentReservationDto;

@Service

public class AppartementServiceImpl implements AppartementServices {
    @Autowired
    private AppartementRepo repository;

    @Autowired
    private ReservationRepo reservationRepoRepository;

    @Override
    public List<Appartement> findAll() {
        return repository.findAll();
    }

    @Override
    public Appartement create(Appartement appartement) {
        return repository.save(appartement);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Appartement> appartementOptional = repository.findById(id);
        if (appartementOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Appartement findById(Long id) {
        Optional<Appartement> appartementOptional = repository.findById(id);
        if (appartementOptional.isPresent())
            return appartementOptional.get();
        return null;
    }

    @Override
    public String update(Appartement appartement, Long id) {
        Optional<Appartement> appartementOptional = repository.findById(id);
        if (appartementOptional.isPresent()) {
            Appartement updateappartement = appartementOptional.get();

            updateappartement.setName(appartement.getName());

            repository.save(updateappartement);
            return "Appartement updated !";

        }
        return "Old Appartement not found !";
    }

    @Override
    public List<Appartement> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public ResponseEntity<Object> getCompanyServers(Long idCompany) {
        Optional<Appartement> appartementOptional = repository.findById(idCompany);
        if (appartementOptional.isPresent()) {
            var appartement = appartementOptional.get();

            List<Reservation> appartementreservation = reservationRepoRepository.findByAppartement(appartement );
            var appartementServerDto = new AppartemeentReservationDto(appartementreservation.size(), appartementreservation);

            return ResponseEntity.ok().body(appartementServerDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appartement not found");
    }
}
