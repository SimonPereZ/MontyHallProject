package se.comhem.test.montyhall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MontyHallResponse {

    private Long numberOfAttempts;
    private Long successfulAttempts;
    private Long unSuccessfulAttempts;
    private Double successRate;
    private boolean changedDoor;

}
