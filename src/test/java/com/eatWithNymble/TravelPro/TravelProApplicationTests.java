package com.eatWithNymble.TravelPro;

import Exceptions.ActivityCapacityReached;
import Exceptions.BalanceInsufficientException;
import Models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TravelProApplicationTests {

    @Test
    void signUpForActivityCapacityTest() throws ActivityCapacityReached {
        Activity activity = new Activity();
        activity.setCapacity(2);
        Passenger passenger1 = new PremiumSubscription();
        Passenger passenger2 = new StandardSubscription();
        Passenger passenger3 = new StandardSubscription();

        activity.signUpForActivity(passenger1);
        activity.signUpForActivity(passenger2);

        assertThrows(ActivityCapacityReached.class, () -> {
            activity.signUpForActivity(passenger3);
        });
    }

    @Test
    void testBalanceSignUpInsufficientForGold() throws BalanceInsufficientException {
        GoldSubscription passenger = new GoldSubscription();
        passenger.setBalance(5000.00);

        Activity activity1 = new Activity();
        activity1.setCost(3000.00);

        Activity activity2 = new Activity();
        activity2.setCost(4000.00);

        assertTrue(passenger.signUp(activity1));

        assertThrows(BalanceInsufficientException.class, () -> {
            passenger.signUp(activity2);
        });

        assertEquals(2300, passenger.getBalance());
    }


    @Test
    void testBalanceSignUpInsufficientForStandard() throws BalanceInsufficientException {
        StandardSubscription passenger = new StandardSubscription();
        passenger.setBalance(5000);

        Activity activity1 = new Activity();
        activity1.setCost(3000);

        Activity activity2 = new Activity();
        activity2.setCost(4000);

        assertTrue(passenger.signUp(activity1));

        assertThrows(BalanceInsufficientException.class, () -> {
            passenger.signUp(activity2);
        });
        assertEquals(2000, passenger.getBalance());
    }

    @Test
    void testSignUpForPremium() throws BalanceInsufficientException {
        PremiumSubscription passenger = new PremiumSubscription();
        Activity activity1 = new Activity();

        assertTrue(passenger.signUp(activity1));
    }

}
