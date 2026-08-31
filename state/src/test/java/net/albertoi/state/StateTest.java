package net.albertoi.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StateTest {

    private ScooterRental rental;

    @BeforeEach
    void setUp() {
        rental = new ScooterRental();
    }

    @Test
    void followsTheNormalRentalLifecycle() {
        rental.unlock();
        assertEquals("riding", rental.getStateName());

        rental.pause();
        assertEquals("paused", rental.getStateName());

        rental.resume();
        rental.end();
        assertEquals("completed", rental.getStateName());
    }

    @Test
    void behaviorDependsOnTheCurrentState() {
        assertThrows(IllegalStateException.class, rental::pause);

        rental.unlock();
        rental.pause();

        assertThrows(IllegalStateException.class, () -> rental.rideFor(5));
    }

    @Test
    void onlyRidingStateAccumulatesUsage() {
        rental.unlock();
        rental.rideFor(8);
        rental.pause();
        rental.resume();
        rental.rideFor(4);

        assertEquals(12, rental.getRidingMinutes());
    }

    @Test
    void completedRentalCannotBeRestarted() {
        rental.unlock();
        rental.end();

        assertThrows(IllegalStateException.class, rental::unlock);
        assertThrows(IllegalStateException.class, rental::resume);
    }
}
