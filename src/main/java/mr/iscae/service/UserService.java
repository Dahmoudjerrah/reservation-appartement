package mr.iscae.service;

import mr.iscae.entity.Utilisateur;
import mr.iscae.repositrie.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
  public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<Utilisateur> findAll(){
        return userRepo.findAll();

    }
    public Utilisateur create(Utilisateur user){

        return userRepo.save(user);
    }
    public Utilisateur getUserById(Long id) {
//        Optional<User> userOptional=userRepo.findById(id);
//        if(userOptional.isPresent())
            return userRepo.findById(id).get();



    }

    public Boolean delete(Long id){
        Optional<Utilisateur> userOptional=userRepo.findById(id);
        if(userOptional.isPresent()){
            userRepo.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
