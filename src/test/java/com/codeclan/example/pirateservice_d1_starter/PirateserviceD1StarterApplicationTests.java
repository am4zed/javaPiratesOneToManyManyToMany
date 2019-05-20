package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;
	@Autowired
	ShipRepository shipRepository;
	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void createSinglePirateAndSave(){
//		Pirate pirate = new Pirate("Jack", "Sparrow", 32);
//		pirateRepository.save(pirate);
//	}
//
	@Test
	public void createPirateAndShip(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);
	}

	@Test
	public void canAddRaidToPirate(){
		Ship ship2 = new Ship("The Green Goddess");
		shipRepository.save(ship2);

		Pirate marge = new Pirate("Marge", "Cutthroat", 41, ship2);
		pirateRepository.save(marge);

		Raid raid1 = new Raid("Smuggler's Cove", 360);
		raidRepository.save(raid1);

		marge.addRaidToPirate(raid1);
		pirateRepository.save(marge);
	}

	@Test
	public void canAddPirateToRaid() {
		Ship ship3 = new Ship("The Deep Blue");
		shipRepository.save(ship3);

		Pirate sinbad = new Pirate("Captain", "Sinbad", 54, ship3);
		pirateRepository.save(sinbad);

		Raid raid2 = new Raid("Devil's Triangle", 458);
		raidRepository.save(raid2);

		raid2.addPirateToRaid(sinbad);
		raidRepository.save(raid2);
	}
//	won't save pirate to raid
}
