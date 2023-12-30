package mr.iscae;
import mr.iscae.entity.Role;
import mr.iscae.repositrie.RoleRepository;
import mr.iscae.service.serviceImpl.RoleServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class RoleServiceImplTest {
      @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test
    // void getAllRoles() {
    //     // Arrange
    //     List<Role> expectedRoles = Arrays.asList(
    //             new Role(1L, "Role1"),
    //             new Role(2L, "Role2")
    //     );
    //     when(roleRepository.findAll()).thenReturn(expectedRoles);

    //     // Act
    //     List<Role> actualRoles = roleService.getAllRoles();

    //     // Assert
    //     assertEquals(expectedRoles, actualRoles);
    // }

    // @Test
    // void getRoleById_Exists() {
    //     // Arrange
    //     long roleId = 1L;
    //     Role expectedRole = new Role(roleId, "Role1");
    //     when(roleRepository.findById(roleId)).thenReturn(Optional.of(expectedRole));

    //     // Act
    //     Role actualRole = roleService.getRoleById(roleId);

    //     // Assert
    //     assertEquals(expectedRole, actualRole);
    // }

    @Test
    void getRoleById_NotExists() {
        // Arrange
        long roleId = 1L;
        when(roleRepository.findById(roleId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> roleService.getRoleById(roleId));
    }

    // @Test
    // void createRole() {
    //     // Arrange
    //     Role roleToCreate = new Role(1L, "Role1");
    //     when(roleRepository.save(roleToCreate)).thenReturn(roleToCreate);

    //     // Act
    //     Role createdRole = roleService.createRole(roleToCreate);

    //     // Assert
    //     assertEquals(roleToCreate, createdRole);
    // }

    // @Test
    // void updateRole() {
    //     // Arrange
    //     Role updatedRole = new Role(1L, "UpdatedRole");
    //     when(roleRepository.save(updatedRole)).thenReturn(updatedRole);

    //     // Act
    //     Role result = roleService.updateRole(updatedRole);

    //     // Assert
    //     assertEquals(updatedRole.getName(), result.getName());
    // }

    // @Test
    // void deleteRole_Exists() {
    //     // Arrange
    //     long roleId = 1L;
    //     Role roleToDelete = new Role(roleId, "Role1");
    //     when(roleRepository.findById(roleId)).thenReturn(Optional.of(roleToDelete));

    //     // Act
    //     roleService.deleteRole(roleId);

    //     // Assert
    //     verify(roleRepository, times(1)).delete(roleToDelete);
    // }

    @Test
    void deleteRole_NotExists() {
        // Arrange
        long roleId = 1L;
        when(roleRepository.findById(roleId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> roleService.deleteRole(roleId));
    }

    
}
