package com.codeclan.example.pirateservice.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Entity for class will be a table
@Entity
@Table(name = "pirates")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")        // ORM approach writing tables - it is like sql database but annotated on a class
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    /////////////////////////////
    // JPA + Hibernate
    // Set the relationship between Pirate and Ship classes
    @ManyToOne
    // @JoinColumn annotation will generate a column ship_id (a foreign key) in the pirates table which will point to the id of the ships table (primary key)
    // Each pirate must have a ship, so we set foreign key as nullable = false
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;


    @ManyToMany
    @JoinTable(
        name = "pirates_raids",
        joinColumns = {
            @JoinColumn(
            name = "pirate_id",
            nullable = false,
            updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(
            name = "raid_id",
            nullable = false,
            updatable = false)
        }
    )
    private List<Raid> raids;


    // To ensure Pirate must have a ship we will also change the constructor of Pirate to take in the ship when we create a new Pirate object
    public Pirate(String firstName, String lastName, int age, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<Raid>();
    }

    // POJO - Second constructor will create an empty object without any values
    // THIS MUST BE IN ORDER TO CREATE OBJECTS TO SAVE TO DATABASE
    public Pirate() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void addRaid(Raid raid) {
        this.raids.add(raid);
    }

}
