package net.albertoi.state;

public class PausedState implements RentalState {

    @Override
    public String name() {
        return "paused";
    }

    @Override
    public void resume(ScooterRental rental) {
        rental.transitionTo(new RidingState());
    }

    @Override
    public void end(ScooterRental rental) {
        rental.transitionTo(new CompletedState());
    }
}
