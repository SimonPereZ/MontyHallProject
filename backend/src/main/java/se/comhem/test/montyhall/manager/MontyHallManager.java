package se.comhem.test.montyhall.manager;

import org.springframework.stereotype.Service;
import se.comhem.test.montyhall.dto.MontyHallResponse;
import se.comhem.test.montyhall.dto.SimulationRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

@Service
public class MontyHallManager {

    public void validateRequest(SimulationRequest request) {
        if (Objects.isNull(request.getNumberOfAttempts()) || request.getNumberOfAttempts() < 1) {
            throw new IllegalArgumentException("NumberOfAttempts can not be null or less than one");
        }
    }

    public MontyHallResponse runSimulation(SimulationRequest request) {
        long successfulAttempts = 0L;
        long unSuccessfulAttempts = 0L;
        long attempts = 0L;

        while (attempts < request.getNumberOfAttempts()) {
            if (isGameSuccessful(request.isChangeDoor())) {
                successfulAttempts++;

            } else {
                unSuccessfulAttempts++;
            }
            attempts++;
        }
        double winRate = calculateWinRate(request.getNumberOfAttempts(), successfulAttempts);

        return new MontyHallResponse(request.getNumberOfAttempts(), successfulAttempts, unSuccessfulAttempts, winRate, request.isChangeDoor());
    }

    private boolean isGameSuccessful(boolean changeDoor) {
        Random random = new Random();
        int prizeDoor = random.nextInt(3) + 1;
        int playerDoor = random.nextInt(3) + 1;

        boolean winArgumentOne = prizeDoor != playerDoor && changeDoor;
        boolean winArgumentTwo = prizeDoor == playerDoor && !changeDoor;

        return winArgumentOne || winArgumentTwo;
    }

    public double calculateWinRate(double numberOfAttempts, double successfulAttempts) {
        BigDecimal winRate = new BigDecimal((successfulAttempts / numberOfAttempts) * 100);
        return winRate.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
