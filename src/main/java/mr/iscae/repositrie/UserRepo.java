package mr.iscae.repositrie;

import mr.iscae.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<AppUser,Integer > {
    Optional<AppUser> findByUsername(String username);
    List<AppUser> findByUsernameContains(String username);
    Optional<AppUser> findByEmail(String email);
    //List<AppUser> findByEmailContains(String email);

}
