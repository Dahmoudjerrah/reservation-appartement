package mr.iscae.service;

import mr.iscae.entity.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {
    public ResponseEntity<?> addUser(AppUser userInfo);

    public AppUser fidUserByUsername(String username);

    public void DeleteUser(Integer id);

    public boolean findUserById(Integer id);

    public List<AppUser> getUsers();
}
