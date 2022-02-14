package com.codeclan.example.pirateservice.repositories;
import com.codeclan.example.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;

// inherit from another interface
public interface PirateRepository extends JpaRepository<Pirate, Long> {

    // This does all the crud functionality under the hood
    // Use this repository to save pirate object to the database - Save an instance to database

}
