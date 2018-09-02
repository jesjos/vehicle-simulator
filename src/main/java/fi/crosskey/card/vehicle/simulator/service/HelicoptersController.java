package fi.crosskey.card.vehicle.simulator.service;


import fi.crosskey.card.vehicle.simulator.models.Helicopter;
import fi.crosskey.card.vehicle.simulator.repositories.HelicopterRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
/*
    @RequestMapping(method = RequestMethod.GET)
    public Optional<Helicopter> findOne(Long primaryKey) {
        return vehiclesRepository.findById(primaryKey);
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public  <S extends Helicopter> void save(S entity) {
        vehiclesRepository.save(entity);
    }


}
