package fr.idformation.mariospizza.cors.service;

import fr.idformation.mariospizza.cors.enities.Pizza;

import java.util.List;

public interface IPizzaService {
    /**
     *
     * @return all pizza.
     */
    List<Pizza> getAllPizza();
}
