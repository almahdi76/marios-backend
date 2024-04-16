package fr.idformation.mariospizza.cors.repositories;

import fr.idformation.mariospizza.cors.enities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
}
