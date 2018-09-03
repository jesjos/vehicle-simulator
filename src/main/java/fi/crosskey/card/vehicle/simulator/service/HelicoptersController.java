package fi.crosskey.card.vehicle.simulator.service;


import fi.crosskey.card.vehicle.simulator.models.Helicopter;
import fi.crosskey.card.vehicle.simulator.repositories.HelicopterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/helicopters")
public class HelicoptersController {

    private HelicopterRepository vehiclesRepository;

    public HelicoptersController(final HelicopterRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Helicopter> findAll() {
        return vehiclesRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public  <S extends Helicopter> void save(S entity) {
        vehiclesRepository.save(entity);
    }

    /* URL path = localhost:8080/helicopters/findOne/value */

    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET)
    public Optional<Helicopter> findOne(@PathVariable Long id) {
    return vehiclesRepository.findById(id);
}



}
