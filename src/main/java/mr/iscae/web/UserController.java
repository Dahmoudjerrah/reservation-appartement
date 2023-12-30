package mr.iscae.web;
import mr.iscae.entity.AppUser;
import mr.iscae.service.UserServices;
import mr.iscae.utils.Constants;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.USER)
public class UserController {
      @Autowired
      private UserServices service;

@GetMapping("/profile/{email}")
    public ResponseEntity<AppUser> getusers(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(service.findUserByemail(email));
    }
    @PutMapping("/update-password/{id}")
    public ResponseEntity<String> updatepaswrd(@PathVariable Integer id,@RequestBody AppUser user){
         return ResponseEntity.status(HttpStatus.OK).body(service.updatepasswrd(id,user));
    }
}
