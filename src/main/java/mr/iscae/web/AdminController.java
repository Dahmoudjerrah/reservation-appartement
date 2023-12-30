package mr.iscae.web;
import mr.iscae.entity.AppUser;
import mr.iscae.entity.Permission;
import mr.iscae.service.UserServices;
import mr.iscae.entity.Role;
import mr.iscae.service.RoleServices;
import mr.iscae.service.PermissionServices;
import mr.iscae.utils.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(Constants.ADMIN_ROOT)
public class AdminController {
      @Autowired
      private UserServices service;
      @Autowired
      private PermissionServices permissionServices;
      @Autowired
      private RoleServices roleServices;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getusers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());
    }
    @GetMapping("/addrole/{iduser}/{idrole}")
    public String add_role_to_user(@PathVariable("iduser") Integer iduser,@PathVariable("idrole") Long idrole ){
        return service.add_role_to_user(iduser, idrole);
    }
     @GetMapping("/addpermisiontorole/{idrole}/{idper}")
    public String add_permision_to_role(@PathVariable("idrole") Long idrole,@PathVariable("idper") Long idper ){
        return roleServices.add_permision_to_role( idrole,idper);
    }
         

    @GetMapping("/{id}")
    public boolean getUserByID(@PathVariable("id") Integer id){
        return service.findUserById(id);
    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id")Integer  id){
        service.DeleteUser(id);
    }
    

@PostMapping("/permissions")
    public ResponseEntity<Permission> create(@RequestBody Permission permission ){
        return ResponseEntity.status(HttpStatus.CREATED).body(permissionServices.createPermission(permission));
    }

    @GetMapping("/permissions")
    public ResponseEntity<List<Permission>> getAllpermitions(){
        return ResponseEntity.status(HttpStatus.OK).body(permissionServices.getAllPermissions());
    }
         

    @GetMapping("/permissions/{id}")
    public ResponseEntity<Permission> getPermisionByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(permissionServices.getPermissionById(id));
    }
    

    @PutMapping("/permissions/{id}")
    public ResponseEntity<Permission> updatePermision( @PathVariable("id") Long id,@RequestBody Permission permission){
        return ResponseEntity.status(HttpStatus.OK).body(permissionServices.updatePermission(id, permission));
    }
    
    @DeleteMapping("/permissions/{id}")
    public boolean delete(@PathVariable("id")Long  id){
        return permissionServices.deletePermission(id);
    }
    @PostMapping("/roles")
    public ResponseEntity<Role> create(@RequestBody Role role ){
        return ResponseEntity.status(HttpStatus.CREATED).body(roleServices.createRole(role));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRolles(){
        return ResponseEntity.status(HttpStatus.OK).body(roleServices.getAllRoles());
    }
         

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(roleServices.getRoleById(id));
    }
    

    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole( @PathVariable("id") Long id,@RequestBody Role role){
        return ResponseEntity.status(HttpStatus.OK).body(roleServices.updateRole(id, role));
    }
    
    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable("id")Long  id){
         roleServices.deleteRole(id);
    }

}
