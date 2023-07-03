package org.lessons.springlamiapizzeriacrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    //attributi______________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    //getter______________________________________
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //setter______________________________________
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}