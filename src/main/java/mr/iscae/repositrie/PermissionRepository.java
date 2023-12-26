package mr.iscae.repositrie;

import mr.iscae.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    boolean existsByName(String name);
}
