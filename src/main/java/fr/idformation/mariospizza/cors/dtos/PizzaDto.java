package fr.idformation.mariospizza.cors.dtos;

import fr.idformation.mariospizza.cors.enities.OrderLine;

import java.math.BigDecimal;
import java.util.Set;

public record PizzaDto (String name, String description, String image, BigDecimal price, Set<OrderLine> pizOrderLines){
}
