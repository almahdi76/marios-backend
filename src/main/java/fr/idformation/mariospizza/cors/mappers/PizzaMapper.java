package fr.idformation.mariospizza.cors.mappers;

import fr.idformation.mariospizza.cors.dtos.PizzaDto;
import fr.idformation.mariospizza.cors.enities.Pizza;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaMapper {
    /**
     *
     * @param pizza entity.
     * @return dto
     */
    PizzaDto toPizzaDto(Pizza pizza);


    /**
     *
     * @param pizzas entities.
     * @return dto
     */
    List<PizzaDto> toListPizzaDtos(List<Pizza> pizzas);
}


/*
 *
 * @param pizzaDto dto.
 * @return entity
 */
//Pizza toPizza(PizzaDto pizzaDto);
