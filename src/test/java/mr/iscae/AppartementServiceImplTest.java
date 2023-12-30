package mr.iscae;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import mr.iscae.entity.Appartement;
import mr.iscae.repositrie.AppartementRepo;
import mr.iscae.service.serviceImpl.AppartementServiceImpl;
import mr.iscae.repositrie.ReservationRepo;

@SpringBootTest
public class AppartementServiceImplTest {
    @Mock
    private AppartementRepo repository;

    @Mock
    private ReservationRepo reservationRepoRepository;

    @InjectMocks
    private AppartementServiceImpl appartementService;

    @Test
    void testFindAll() {
        List<Appartement> appartements = Arrays.asList(new Appartement(), new Appartement());
        when(repository.findAll()).thenReturn(appartements);

        List<Appartement> result = appartementService.findAll();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testCreate() {
        Appartement appartement = new Appartement();
        when(repository.save(any(Appartement.class))).thenReturn(appartement);

        Appartement result = appartementService.create(appartement);

        assertNotNull(result);
        verify(repository, times(1)).save(any(Appartement.class));
    }

    @Test
    void testDelete() { 
        Long appartementId = 1L;
        when(repository.findById(appartementId)).thenReturn(Optional.of(new Appartement()));

        boolean result = appartementService.delete(appartementId);

        assertTrue(result);
        verify(repository, times(1)).deleteById(appartementId);
    }

    // Similar tests for findById, update, findByName, and getCompanyServers methods

    // ...


    
}
