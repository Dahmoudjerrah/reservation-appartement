package mr.iscae.config;
import mr.iscae.entity.AppUser;
import mr.iscae.entity.Permission;
import mr.iscae.entity.Role;
import mr.iscae.repositrie.PermissionRepository;
import mr.iscae.repositrie.RoleRepository;
import mr.iscae.repositrie.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;


import java.util.Optional;
@Component
public class PermissionInitializer implements ApplicationRunner{
    @Autowired
    private final PermissionRepository permissionRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private UserRepo userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PermissionInitializer(PermissionRepository permissionRepository, RoleRepository roleRepository,
                                 UserRepo userInfoRepository,
                                 PasswordEncoder passwordEncoder) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] perm_list = { "list_role", "view_role", "create_role", "update_role", "delete_role",
                "list_permission", "view_permission", "create_permission", "update_permission", "delete_permission",
                "list_user", "update_user_password", "update_user_role", "delete_user", "list_account", "view_account","create_permission",
                "update_user_password", "get_profile", "update_profile","create_company","view_company",
                "list_appartement","create_appartement",
                "update_appartement","get_appartement_byid","appartement_list_reservation","list_reservation",
                "create_reservation","delete_appartement"
        };

        for (String perm : perm_list) {
            createPermissionIfNotFound(perm);
        }

        createSuperAdminRole("super_admin");
        createSuperUser("admin", "admin", "admin@admin.com");
    }

    @Transactional
    public void createPermissionIfNotFound(String name) {
        if (!permissionRepository.existsByName(name)) {
            Permission permission = new Permission();
            permission.setName(name);
            permissionRepository.save(permission);
        }
    }

    @Transactional
    public void createSuperUser(String username, String password, String email) {
        Optional<AppUser> user1 = userInfoRepository.findByUsername(username);
        Optional<AppUser> user2 = userInfoRepository.findByEmail(email);
        if (user1.isPresent() || user2.isPresent()) {
            AppUser user = user1.isPresent() ? user1.get() : user2.get();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(roleRepository.findByName("super_admin"));
            userInfoRepository.save(user);
        } else {
            AppUser user = new AppUser();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(roleRepository.findByName("super_admin"));
            user.setEmail(email);
            userInfoRepository.save(user);
        }
    }

    @Transactional
    public void createSuperAdminRole(String name) {
        Role superAdminRole = roleRepository.findByName(name);
        if (superAdminRole == null) {
            // Create new super admin role if it does not exist
            superAdminRole = new Role();
            superAdminRole.setName(name);
            superAdminRole.setPermissions(permissionRepository.findAll());
            roleRepository.save(superAdminRole);
        } else {
            // Update existing super admin role by adding super user permission
            superAdminRole.setPermissions(permissionRepository.findAll());
            roleRepository.save(superAdminRole);
        }
    }

}
