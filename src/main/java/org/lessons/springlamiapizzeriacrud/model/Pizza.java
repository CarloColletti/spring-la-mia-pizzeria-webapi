package org.lessons.springlamiapizzeriacrud.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizze")
public class Pizza {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //column
    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    private String image;
    private BigDecimal price;

    @OneToMany(mappedBy = "pizza")
    private List<Offers> offers = new ArrayList<>();

    //getter
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public BigDecimal getPrice() {
        return price;
    }


    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

