package mr.iscae.service;

import mr.iscae.entity.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {
    public ResponseEntity<?> addUser(AppUser userInfo);

    public AppUser fidUserByUsername(String username);
    public AppUser findUserByemail(String email);
    public void DeleteUser(Integer id);

    public boolean findUserById(Integer id);

    public List<AppUser> getUsers();
    public String add_role_to_user(Integer iduser,Long idrole);
    public String updatepasswrd(Integer id,AppUser user);
}
