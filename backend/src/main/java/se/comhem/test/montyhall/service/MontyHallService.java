package se.comhem.test.montyhall.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.comhem.test.montyhall.dto.MontyHallResponse;
import se.comhem.test.montyhall.dto.SimulationRequest;
import se.comhem.test.montyhall.manager.MontyHallManager;

@Service
@Log4j2
public class MontyHallService {

    @Autowired
    private MontyHallManager manager;

    public MontyHallResponse startSimulation(SimulationRequest request) {
        log.info("Start Simulation request received: {}", request);
        manager.validateRequest(request);
        return manager.runSimulation(request);
    }
}
