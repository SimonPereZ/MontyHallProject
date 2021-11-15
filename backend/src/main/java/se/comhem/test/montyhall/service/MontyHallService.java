package se.comhem.test.montyhall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.comhem.test.montyhall.dto.MontyHallResponse;
import se.comhem.test.montyhall.dto.SimulationRequest;
import se.comhem.test.montyhall.manager.MontyHallManager;

@Service
public class MontyHallService {

    @Autowired
    private MontyHallManager manager;

    public MontyHallResponse startSimulation(SimulationRequest request) {
        manager.validateRequest(request);
        return manager.runSimulation(request);
    }
}
