package mr.iscae.repositrie;

import mr.iscae.entity.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AppartementRepo extends JpaRepository<Appartement,Long> {
      List<Appartement> findByName(String name);
}
