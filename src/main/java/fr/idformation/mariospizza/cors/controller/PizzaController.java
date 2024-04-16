package fr.idformation.mariospizza.cors.controller;

import fr.idformation.mariospizza.cors.dtos.PizzaDto;
import fr.idformation.mariospizza.cors.enities.Pizza;
import fr.idformation.mariospizza.cors.mappers.PizzaMapper;
import fr.idformation.mariospizza.cors.service.IPizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    /**
     * injection service.
     */
    private final IPizzaService pizzaService;
    /**
     * injection mapper.
     */
    private final PizzaMapper pizzaMapper;


    /**
     * injection mapper.
     * @param pPizzaMapper mapper
     * @param pPizzaService service
     */
    public PizzaController(final IPizzaService pPizzaService,final  PizzaMapper pPizzaMapper) {
        this.pizzaService = pPizzaService;
        this.pizzaMapper = pPizzaMapper;
    }

    /**
     * @return list of pizza.
     */
   @GetMapping
    public ResponseEntity<List<PizzaDto>> getListPizza(){
        List<Pizza> listPizza=this.pizzaService.getAllPizza();
        List<PizzaDto>pizzaDto= this.pizzaMapper.toListPizzaDtos(listPizza);
        return ResponseEntity.ok(pizzaDto);
    }
}
