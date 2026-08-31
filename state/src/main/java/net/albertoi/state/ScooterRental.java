package net.albertoi.state;

import java.util.Objects;

public class ScooterRental {

    private RentalState state = new AvailableState();
    private int ridingMinutes;

    public void unlock() {
        state.unlock(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void resume() {
        state.resume(this);
    }

    public void rideFor(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("Riding time must be positive");
        }
        state.rideFor(this, minutes);
    }

    public void end() {
        state.end(this);
    }

    void transitionTo(RentalState state) {
        this.state = Objects.requireNonNull(state);
    }

    void addRidingMinutes(int minutes) {
        ridingMinutes += minutes;
    }

    public String getStateName() {
        return state.name();
    }

    public int getRidingMinutes() {
        return ridingMinutes;
    }
}
