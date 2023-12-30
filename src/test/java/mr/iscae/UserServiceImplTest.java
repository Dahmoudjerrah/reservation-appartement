package mr.iscae;
import mr.iscae.entity.AppUser;
import mr.iscae.entity.Role;
import mr.iscae.repositrie.RoleRepository;
import mr.iscae.repositrie.UserRepo;
import mr.iscae.service.serviceImpl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class UserServiceImplTest {
     @Mock
    private UserRepo appUserRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test
    // void addUser() {
    //     // Arrange
    //     AppUser userInfo = new AppUser();
    //     when(passwordEncoder.encode(userInfo.getPassword())).thenReturn("encodedPassword");
    //     when(roleRepository.findById(2)).thenReturn(Optional.of(new Role(2, "ROLE_USER")));

    //     // Act
    //     ResponseEntity<?> response = userService.addUser(userInfo);

    //     // Assert
    //     assertEquals(HttpStatus.CREATED, response.getStatusCode());
    //     verify(appUserRepository, times(1)).save(userInfo);
    // }

    // @Test
    // void fidUserByUsername() {
    //     // Arrange
    //     String username = "testUser";
    //     when(appUserRepository.findByUsername(username)).thenReturn(Optional.of(new AppUser(1, username, "password")));

    //     // Act
    //     AppUser result = userService.fidUserByUsername(username);

    //     // Assert
    //     assertNotNull(result);
    //     assertEquals(username, result.getUsername());
    // }

    @Test
    void DeleteUser() {
        // Arrange
        Integer userId = 1;

        // Act
        userService.DeleteUser(userId);

        // Assert
        verify(appUserRepository, times(1)).deleteById(userId);
    }

    // @Test
    // void findUserById_Exists() {
    //     // Arrange
    //     Integer userId = 1;
    //     when(appUserRepository.findById(userId)).thenReturn(Optional.of(new AppUser(userId, "testUser", "password")));

    //     // Act
    //     boolean result = userService.findUserById(userId);

    //     // Assert
    //     assertTrue(result);
    // }

    @Test
    void findUserById_NotExists() {
        // Arrange
        Integer userId = 1;
        when(appUserRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        boolean result = userService.findUserById(userId);

        // Assert
        assertFalse(result);
    }

    // @Test
    // void getUsers() {
    //     // Arrange
    //     List<AppUser> expectedUsers = Arrays.asList(new AppUser(1, "user1", "password1"), new AppUser(2, "user2", "password2"));
    //     when(appUserRepository.findAll()).thenReturn(expectedUsers);

    //     // Act
    //     List<AppUser> actualUsers = userService.getUsers();

    //     // Assert
    //     assertEquals(expectedUsers, actualUsers);
    // }

    // @Test
    // void getUserById_Exists() {
    //     // Arrange
    //     Integer userId = 1;
    //     when(appUserRepository.findById(userId)).thenReturn(Optional.of(new AppUser(userId, "testUser", "password")));

    //     // Act
    //     AppUser result = userService.getUserById(userId);

    //     // Assert
    //     assertNotNull(result);
    //     assertEquals(userId, result.getId());
    // }

    @Test
    void getUserById_NotExists() {
        // Arrange
        Integer userId = 1;
        when(appUserRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        AppUser result = userService.getUserById(userId);

        // Assert
        assertNull(result);
    }

    
    
}
