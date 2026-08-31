package net.albertoi.state;

public class AvailableState implements RentalState {

    @Override
    public String name() {
        return "available";
    }

    @Override
    public void unlock(ScooterRental rental) {
        rental.transitionTo(new RidingState());
    }
}
