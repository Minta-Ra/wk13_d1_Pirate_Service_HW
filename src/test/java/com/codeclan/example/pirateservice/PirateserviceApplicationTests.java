package com.codeclan.example.pirateservice;
import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	// @Autowired - Dependency injection - implement specific interface for me - ir gives all the access from that interface
	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	// Using this test file - save data into the database
	@Test
	public void createPirateAndShip() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);

		Pirate mack = new Pirate("Mack", "Calabran", 28, ship);
		pirateRepository.save(mack);

		Pirate black = new Pirate("Black", "Jack", 33, ship);
		pirateRepository.save(black);
	}


	@Test
	public void addPirateAndRaids() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);

		Pirate mack = new Pirate("Mack", "Calabran", 28, ship);
		pirateRepository.save(mack);

		Pirate black = new Pirate("Black", "Jack", 33, ship);
		pirateRepository.save(black);

		Raid tortuga = new Raid("Tortuga", 100);
		raidRepository.save(tortuga);

		tortuga.addPirate(jack);
		tortuga.addPirate(mack);
		tortuga.addPirate(black);

		raidRepository.save(tortuga);

		Raid caribbean = new Raid("Caribbean", 100);
		raidRepository.save(caribbean);

		caribbean.addPirate(mack);
		caribbean.addPirate(black);

		raidRepository.save(caribbean);
	}

}
