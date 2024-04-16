package fr.idformation.mariospizza.cors.service.impl;

import fr.idformation.mariospizza.cors.enities.Pizza;
import fr.idformation.mariospizza.cors.repositories.PizzaRepository;
import fr.idformation.mariospizza.cors.service.IPizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PizzaService implements IPizzaService {
    /**
     *inject repo.
     */
    private final PizzaRepository pizzaRepository;

    /**
     *
     * @param pPizzaRepository repo.
     */
    public PizzaService(final PizzaRepository pPizzaRepository) {
        this.pizzaRepository = pPizzaRepository;
    }

    /**
     *
     * @return list pizza.
     */
    @Override
    public List<Pizza> getAllPizza() {
        return this.pizzaRepository.findAll();
    }
}
