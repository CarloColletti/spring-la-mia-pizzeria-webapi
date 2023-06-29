package org.lessons.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    private String Title;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name="pizza_id", nullable = false)
    private Pizza pizza;


    // getter_______________________
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Pizza getPizza() {
        return pizza;
    }

    // setter_______________________
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
