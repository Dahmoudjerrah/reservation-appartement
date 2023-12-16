package mr.iscae.repositrie;

import mr.iscae.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<Utilisateur,Long > {

}
