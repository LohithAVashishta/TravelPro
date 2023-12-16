package com.eatWithNymble.TravelPro;

import Exceptions.ActivityCapacityReached;
import Exceptions.BalanceInsufficientException;
import Models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TravelProApplication {

	public static void main(String[] args) throws BalanceInsufficientException, ActivityCapacityReached {
		SpringApplication.run(TravelProApplication.class, args);

		Destination destination1 = new Destination();
		destination1.setId(1);
		destination1.setName("Mysore");

		Activity activity1 = new Activity();
		activity1.setId(1);
		activity1.setName("Palace Visit");
		activity1.setDescription("Visiting the Royal Mysore Palace");
		activity1.setCost(800.00);
		activity1.setCapacity(10);


		Activity activity2 = new Activity();
		activity2.setId(2);
		activity2.setName("KRS Dam visit");
		activity2.setDescription("Visiting the KRS Dam and enjoying the serene view of back waters.");
		activity2.setCost(500.00);
		activity2.setCapacity(5);

		Activity activity3 = new Activity();
		activity3.setId(3);
		activity3.setName("Paragliding");
		activity3.setDescription("Paragliding from Chamundi hill and viewing Mysore from the skies.");
		activity3.setCost(5000.00);
		activity3.setCapacity(2);

		activity1.setDestination(destination1);
		activity2.setDestination(destination1);
		activity3.setDestination(destination1);

		List<Activity> destination1Activities = new ArrayList<>();
		destination1Activities.add(activity1);
		destination1Activities.add(activity2);
		destination1Activities.add(activity3);
		destination1.setActivities(destination1Activities);


		Destination destination2 = new Destination();
		destination2.setId(2);
		destination2.setName("Delhi");

		Activity activity4 = new Activity();
		activity4.setId(4);
		activity4.setName("Red Fort");
		activity4.setDescription("Visiting Red Fort.");
		activity4.setCost(500.00);
		activity4.setCapacity(8);
		activity4.setDestination(destination2);

		Activity activity5 = new Activity();
		activity5.setId(5);
		activity5.setName("Qutub Minar");
		activity5.setDescription("Visiting Qutub Minar.");
		activity5.setCost(600.00);
		activity5.setCapacity(4);
		activity5.setDestination(destination2);

		Activity activity6 = new Activity();
		activity6.setId(6);
		activity6.setName("Taj Mahal");
		activity6.setDescription("Visiting Taj Mahal.");
		activity6.setCost(2000.00);
		activity6.setCapacity(6);

		List<Activity> destination2Activities = new ArrayList<>();
		destination2Activities.add(activity4);
		destination2Activities.add(activity5);
		destination2Activities.add(activity6);
		destination2.setActivities(destination2Activities);


		Passenger passenger1 = new PremiumSubscription();
		passenger1.setId(1);
		passenger1.setPassengerNumber(8197901942L);
		passenger1.setName("Lohith A Vashishta");

		List<Destination> p1OptedDestinations = new ArrayList<>();
		p1OptedDestinations.add(destination1);
		p1OptedDestinations.add(destination2);

		passenger1.setDestinations(p1OptedDestinations);

//		List<Activity> p1OptedActivities = new ArrayList<>();
//		p1OptedActivities.add(activity1);
//		p1OptedActivities.add(activity3);
//		p1OptedActivities.add(activity4);
//		p1OptedActivities.add(activity6);
//
//		passenger1.setOptedActivities(p1OptedActivities);

		passenger1.signUp(activity1);
		passenger1.signUp(activity3);
		passenger1.signUp(activity4);
		passenger1.signUp(activity6);
		activity1.signUpForActivity(passenger1);
		activity3.signUpForActivity(passenger1);
		activity4.signUpForActivity(passenger1);
		activity6.signUpForActivity(passenger1);







		GoldSubscription passenger2 = new GoldSubscription();
		passenger2.setId(2);
		passenger2.setPassengerNumber(9000000000L);
		passenger2.setName("Harsha");
		passenger2.setBalance(2000);

		List<Destination> p2OptedDestinations = new ArrayList<>();
		p2OptedDestinations.add(destination2);

		passenger2.setDestinations(p2OptedDestinations);

//		List<Activity> p2OptedActivities = new ArrayList<>();
//
//		p2OptedActivities.add(activity4);
//		p2OptedActivities.add(activity5);
//
//		passenger2.setOptedActivities(p2OptedActivities);

		passenger2.signUp(activity4);
		passenger2.signUp(activity5);
		activity4.signUpForActivity(passenger2);
		activity5.signUpForActivity(passenger2);





		StandardSubscription passenger3 = new StandardSubscription();
		passenger3.setId(3);
		passenger3.setPassengerNumber(8000000000L);
		passenger3.setName("Varsha");
		passenger3.setBalance(6000);

		List<Destination> p3OptedDestinations = new ArrayList<>();
		p3OptedDestinations.add(destination1);

		passenger3.setDestinations(p3OptedDestinations);

//		List<Activity> p3OptedActivities = new ArrayList<>();
//		p3OptedActivities.add(activity2);
//		p3OptedActivities.add(activity3);
//		passenger3.setOptedActivities(p3OptedActivities);

		passenger3.signUp(activity2);
		passenger3.signUp(activity3);
		activity2.signUpForActivity(passenger3);
		activity3.signUpForActivity(passenger3);

		TravelPackage package1 = new TravelPackage();
		package1.setId(1);
		package1.setName("Mysore & Delhi");
		package1.setPassengerCapacity(3);

		List<Passenger> package1Passengers = new ArrayList<>();
		package1Passengers.add(passenger1);
		package1Passengers.add(passenger2);
		package1Passengers.add(passenger3);

		package1.setPassengers(package1Passengers);

		List<Destination> package1Destinations = new ArrayList<>();
		package1Destinations.add(destination1);
		package1Destinations.add(destination2);

		package1.setDestinations(package1Destinations);

		package1.printPackage();





		
	}

}
