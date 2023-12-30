package mr.iscae.service.serviceImpl;

 import mr.iscae.entity.Permission;
import mr.iscae.entity.Role;
import mr.iscae.repositrie.PermissionRepository;
import mr.iscae.repositrie.RoleRepository;
import mr.iscae.service.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleServices {

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            return role;
        } else {
            throw new IllegalArgumentException("Role with ID " + id + " not found");
        }
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public String  add_permision_to_role(Long idrole,Long idpermision){
        Optional<Role> roleOptional =roleRepository.findById(idrole);
         Optional<Permission> permisionOptional=permissionRepository.findById(idpermision);
         if(permisionOptional.isPresent() && roleOptional.isPresent()){
           Permission per =permisionOptional.get();
         
         List <Permission> permissionse= new ArrayList<Permission>();
             permissionse.add(per);

            Role role=roleOptional.get();
            role.setPermissions(permissionse);
    
           roleRepository.save(role);
            return " permision add to role";
         }
        
         else{
            return "permision ou role note found";
         }

    }


    @Override
    public Role updateRole(Long id,Role updatedRole) {
        Optional<Role> optionalrole = roleRepository.findById(id) ;
        if (optionalrole.isPresent()) {
            Role role = optionalrole.get();
            role.setName(updatedRole.getName());
             return roleRepository.save(updatedRole);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permission not found");
        }
       
    }

    @Override
    public void deleteRole(long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            roleRepository.delete(role);
        } else {
            throw new IllegalArgumentException("Role with ID " + id + " not found");
        }
    }
}
