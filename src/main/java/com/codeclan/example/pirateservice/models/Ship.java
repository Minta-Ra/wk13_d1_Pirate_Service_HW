package com.codeclan.example.pirateservice.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "ship_name")
    private String name;


    /////////////////////////////
    // JPA + Hibernate
    // @JsonIgnoreProperties({"ship"}) - tells the serializer to not try and convert these properties to JSON, without it, it would avoid the infinite recursion
    // When it serializes that ship's pirates it should ignore their ship property
    @JsonIgnoreProperties({"ship"})
    @OneToMany(mappedBy = "ship")
    private List<Pirate> pirates;

    // Constructor
    public Ship(String name) {
        this.name = name;
        this.pirates = new ArrayList<Pirate>();
    }

    // POJO
    public Ship() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
