package se.comhem.test.montyhall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationRequest {

    private Long numberOfAttempts;
    private boolean changeDoor;

}
