package se.comhem.test.montyhall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.comhem.test.montyhall.dto.MontyHallResponse;
import se.comhem.test.montyhall.dto.SimulationRequest;
import se.comhem.test.montyhall.service.MontyHallService;

@RestController
@RequestMapping(value = "/")
public class MontyHallController {

    @Autowired
    private MontyHallService montyHallService;

    @PostMapping("start")
    @ResponseStatus(HttpStatus.CREATED)
    public MontyHallResponse runSimulation(@RequestBody SimulationRequest request) {
        return montyHallService.startSimulation(request);
    }

}
