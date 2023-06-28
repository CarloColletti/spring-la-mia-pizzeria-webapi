package org.lessons.springlamiapizzeriacrud.controller;


import org.lessons.springlamiapizzeriacrud.model.Pizza;
import org.lessons.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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

    //--------------metodo index---------------------
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

    //--------------metodo show---------------------
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

    //--------------metodo create---------------------
    //controller che restituisce la pagina create con un attributo vuoto
    @GetMapping("/create")
    public String create(Model model){
        //aggiungo al model un attributo pizza vuoto
        model.addAttribute(new Pizza());
        return "pizza/edit";
    }

    // controller che gestisce il post del form
    @PostMapping("/create")
    public String store(@ModelAttribute("pizza") Pizza formPizza
    ) {
        pizzaRepository.save(formPizza);
        return "redirect:/pizza";
    }

    //--------------metodo edit---------------------
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " la pizza con id: " + id + " non è stata trovata ");
        }
        model.addAttribute("pizza", result.get());
        return "pizza/edit";
    }

    @PostMapping("/edit/{id}")
    public String toEdit(@PathVariable Integer id, @ModelAttribute("pizza") Pizza formPizza) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " la pizza con id: " + id + " non è stata trovata ");
        }
        //trasferisco i dati non compresi nel form
        formPizza.setId(result.get().getId());
        //salvo il resto del form
        pizzaRepository.save(formPizza);
        return "redirect:/pizza";
    }


    //--------------metodi custom---------------------
    private Pizza getPizzaById(Integer id) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " la pizza con id: " + id + " non è stata trovata ");
        }
        return result.get();
    }
}
