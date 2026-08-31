package net.albertoi.state;

public class RidingState implements RentalState {

    @Override
    public String name() {
        return "riding";
    }

    @Override
    public void pause(ScooterRental rental) {
        rental.transitionTo(new PausedState());
    }

    @Override
    public void rideFor(ScooterRental rental, int minutes) {
        rental.addRidingMinutes(minutes);
    }

    @Override
    public void end(ScooterRental rental) {
        rental.transitionTo(new CompletedState());
    }
}
