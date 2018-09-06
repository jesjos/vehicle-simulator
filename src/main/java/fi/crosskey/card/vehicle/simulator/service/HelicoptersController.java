package fi.crosskey.card.vehicle.simulator.service;


import fi.crosskey.card.vehicle.simulator.models.Helicopter;
import fi.crosskey.card.vehicle.simulator.repositories.HelicopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/helicopters")
public class HelicoptersController {


    private HelicopterRepository helicopterRepo;
    @Autowired
    public HelicoptersController(final HelicopterRepository vehiclesRepository) {
        this.helicopterRepo = vehiclesRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Helicopter> findAll() {
        return helicopterRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public  Helicopter save(@RequestBody Helicopter entity) {
        return helicopterRepo.save(entity);
    }

    /* URL path = localhost:8080/helicopters/findOne/value */

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Helicopter> findOne(@PathVariable Long id) {
    return helicopterRepo.findById(id);
}



}
