package mr.iscae.service;

import mr.iscae.entity.Role;

import java.util.List;

public interface RoleServices {
    public List<Role> getAllRoles();

    public Role getRoleById(long id);

    public Role createRole(Role role);

    public Role updateRole(Long id,Role updatedRole);

    public void deleteRole(long id);
  
    public String  add_permision_to_role(Long idrole,Long idpermision);
}
