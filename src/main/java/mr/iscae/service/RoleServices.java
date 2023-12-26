package mr.iscae.service;

import mr.iscae.entity.Role;

import java.util.List;

public interface RoleServices {
    public List<Role> getAllRoles();

    public Role getRoleById(long id);

    public Role createRole(Role role);

    public Role updateRole(Role updatedRole);

    public void deleteRole(long id);
}
