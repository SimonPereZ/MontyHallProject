package se.comhem.test.montyhall;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.comhem.test.montyhall.dto.MontyHallResponse;
import se.comhem.test.montyhall.dto.SimulationRequest;
import se.comhem.test.montyhall.service.MontyHallService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyHallApplicationTests {

    @Autowired
    private MontyHallService testService;

    @Test
    public void testSimulationNumberOfAttempts() {
        SimulationRequest request = new SimulationRequest(75210L, false);
        MontyHallResponse response = testService.startSimulation(request);

        Assert.assertEquals(request.getNumberOfAttempts(), response.getNumberOfAttempts());
    }

    @Test
    public void testSimulationResponse() {
        SimulationRequest request = new SimulationRequest(75210L, true);
        MontyHallResponse response = testService.startSimulation(request);

        Assert.assertEquals(request.getNumberOfAttempts().longValue(), response.getSuccessfulAttempts() + response.getUnSuccessfulAttempts());
        Assert.assertNotNull(response.getSuccessRate());
        Assert.assertEquals(response.isChangedDoor(), request.isChangeDoor());
    }

    @Test
    public void testRequestValidation() {
        SimulationRequest request = new SimulationRequest(0L, false);

        try {
            testService.startSimulation(request);
            Assert.fail();

        } catch (IllegalArgumentException e) {
            Assert.assertEquals("NumberOfAttempts can not be null or less than one", e.getMessage());
        }
    }

}
