package mr.iscae.Dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mr.iscae.entity.Reservation;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppartemeentReservationDto {

    private int totslServers;
    private List<Reservation> reservations;
}
