package mr.iscae;

import mr.iscae.entity.Permission;
import mr.iscae.repositrie.PermissionRepository;
import mr.iscae.service.serviceImpl.PermissionServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class PerSerTest {
     @Mock
    private PermissionRepository permissionRepository;

    @InjectMocks
    private PermissionServiceImpl permissionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test
    // void getAllPermissions() {
    //     // Arrange
    //     List<Permission> expectedPermissions = Arrays.asList(
    //             new Permission(1L, "Permission1"),
    //             new Permission(2L, "Permission2")
    //     );
    //     when(permissionRepository.findAll()).thenReturn(expectedPermissions);

    //     // Act
    //     List<Permission> actualPermissions = permissionService.getAllPermissions();

    //     // Assert
    //     assertEquals(expectedPermissions, actualPermissions);
    // }

    // @Test
    // void createPermission() {
    //     // Arrange
    //     Permission permissionToCreate = new Permission(1L, "Permission1");
    //     when(permissionRepository.save(permissionToCreate)).thenReturn(permissionToCreate);

    //     // Act
    //     Permission createdPermission = permissionService.createPermission(permissionToCreate);

    //     // Assert
    //     assertEquals(permissionToCreate, createdPermission);
    // }

    // @Test
    // void getPermissionById_Exists() {
    //     // Arrange
    //     long permissionId = 1L;
    //     Permission expectedPermission = new Permission(permissionId, "Permission1");
    //     when(permissionRepository.findById(permissionId)).thenReturn(Optional.of(expectedPermission));

    //     // Act
    //     Permission actualPermission = permissionService.getPermissionById(permissionId);

    //     // Assert
    //     assertEquals(expectedPermission, actualPermission);
    // }

    @Test
    void getPermissionById_NotExists() {
        // Arrange
        long permissionId = 1L;
        when(permissionRepository.findById(permissionId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResponseStatusException.class, () -> permissionService.getPermissionById(permissionId));
    }

    // @Test
    // void updatePermission_Exists() {
    //     // Arrange
    //     long permissionId = 1L;
    //     Permission existingPermission = new Permission(permissionId, "Permission1");
    //     Permission updatedPermission = new Permission(permissionId, "UpdatedPermission");
    //     when(permissionRepository.findById(permissionId)).thenReturn(Optional.of(existingPermission));
    //     when(permissionRepository.save(existingPermission)).thenReturn(existingPermission);

    //     // Act
    //     Permission result = permissionService.updatePermission(permissionId, updatedPermission);

    //     // Assert
    //     assertEquals(updatedPermission.getName(), result.getName());
    // }

    // @Test
    // void updatePermission_NotExists() {
    //     // Arrange
    //     long permissionId = 1L;
    //     Permission updatedPermission = new Permission(permissionId, "UpdatedPermission");
    //     when(permissionRepository.findById(permissionId)).thenReturn(Optional.empty());

    //     // Act and Assert
    //     assertThrows(ResponseStatusException.class, () -> permissionService.updatePermission(permissionId, updatedPermission));
    // }

    @Test
    void deletePermission() {
        // Arrange
        long permissionId = 1L;

        // Act
        Boolean result = permissionService.deletePermission(permissionId);

        // Assert
        assertTrue(result);
        verify(permissionRepository, times(1)).deleteById(permissionId);
    }

    
}
