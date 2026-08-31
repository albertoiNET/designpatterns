package net.albertoi.state;

public interface RentalState {

    String name();

    default void unlock(ScooterRental rental) {
        reject("unlock");
    }

    default void pause(ScooterRental rental) {
        reject("pause");
    }

    default void resume(ScooterRental rental) {
        reject("resume");
    }

    default void rideFor(ScooterRental rental, int minutes) {
        reject("record riding time");
    }

    default void end(ScooterRental rental) {
        reject("end");
    }

    private void reject(String action) {
        throw new IllegalStateException("Cannot " + action + " while rental is " + name());
    }
}
