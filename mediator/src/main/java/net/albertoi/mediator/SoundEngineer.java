package net.albertoi.mediator;

public class SoundEngineer extends StudioMember {

    private String status = "Idle";

    public SoundEngineer(StudioMediator mediator) {
        super(mediator);
    }

    public void startTake() {
        mediator.notify(this, StudioEvent.START_TAKE);
    }

    public void stopTake() {
        mediator.notify(this, StudioEvent.STOP_TAKE);
    }

    void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
