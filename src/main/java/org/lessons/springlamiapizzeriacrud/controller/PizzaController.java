package org.lessons.springlamiapizzeriacrud.controller;


import org.lessons.springlamiapizzeriacrud.model.Pizza;
import org.lessons.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    //route index
    @GetMapping
    public String index (Model model){
        //lista pizze
        List<Pizza> pizze = pizzaRepository.findAll();
        //la metto nel model
        model.addAttribute("pizze", pizze);
        //view
        return "pizza/index";
    }

    //route show
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Integer id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
            if(pizza.isPresent()) {
                model.addAttribute("pizza", pizza.get());
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Errore 404: id: " + id + " non trovato"
                );
            }
        return "pizza/show";
    }

    //controller che restituisce la pagina create con un attributo vuoto
    @GetMapping("/create")
    public String create(Model model){
        //aggiungo al model un attributo pizza vuoto
        model.addAttribute(new Pizza());
        return "pizza/create";
    }

    // controller che gestisce il post del form
    @PostMapping("/create")
    public String store(@ModelAttribute("pizza") Pizza formPizza
    ) {
        pizzaRepository.save(formPizza);
        return "redirect:/pizza";
    }
}
