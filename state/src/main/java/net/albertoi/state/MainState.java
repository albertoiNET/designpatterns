package net.albertoi.state;

import java.util.logging.Logger;

public class MainState {

    private static final Logger LOGGER = Logger.getLogger(MainState.class.getName());

    public static void main(String[] args) {
        ScooterRental rental = new ScooterRental();
        rental.unlock();
        rental.rideFor(12);
        rental.pause();
        rental.resume();
        rental.rideFor(5);
        rental.end();

        LOGGER.info(
            () -> rental.getStateName() + " after " + rental.getRidingMinutes() + " minutes"
        );
    }
}
