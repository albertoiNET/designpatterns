package net.albertoi.mediator;

public class Musician extends StudioMember {

    private boolean ready;
    private boolean cueLightOn;

    public Musician(StudioMediator mediator) {
        super(mediator);
    }

    public void announceReady() {
        ready = true;
        mediator.notify(this, StudioEvent.MUSICIAN_READY);
    }

    void showCue() {
        cueLightOn = true;
    }

    void clearCue() {
        cueLightOn = false;
    }

    public boolean isReady() {
        return ready;
    }

    public boolean isCueLightOn() {
        return cueLightOn;
    }
}
