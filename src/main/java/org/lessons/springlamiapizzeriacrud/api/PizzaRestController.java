package org.lessons.springlamiapizzeriacrud.api;

import org.lessons.springlamiapizzeriacrud.model.Pizza;
import org.lessons.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

//controller risorsa pizza
@RestController
@CrossOrigin
@RequestMapping("api/v1/pizza")
public class PizzaRestController {

    @Autowired
    private PizzaRepository pizzaRepository;

    //servizio per la lista delle pizze

    //index_________________________________
    @GetMapping
    public List<Pizza> index() {
        return pizzaRepository.findAll();
    }

    //show_________________________________
    @GetMapping("/{id}")
    public Pizza show( @PathVariable Integer id ) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isPresent()){
            return pizza.get();
        } else {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
