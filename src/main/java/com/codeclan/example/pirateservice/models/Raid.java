package com.codeclan.example.pirateservice.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "raids")
public class Raid {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "loot")
    private int loot;


    /////////////////////////////
    // JPA + Hibernate
    @ManyToMany
    @JoinTable(
        name = "pirates_raids",
        joinColumns = {
            @JoinColumn(
            name = "raid_id",
            nullable = false,
            updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(
            name = "pirate_id",
            nullable = false,
            updatable = false)
        }
    )
    private List<Pirate> pirates;


    // Constructor
    public Raid(String location, int loot) {
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<Pirate>();
    }

    public Raid() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void addPirate(Pirate pirate) {
        this.pirates.add(pirate);
    }

}
