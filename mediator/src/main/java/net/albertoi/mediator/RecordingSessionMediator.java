package net.albertoi.mediator;

import java.util.Objects;

public class RecordingSessionMediator implements StudioMediator {

    private Musician musician;
    private SoundEngineer engineer;
    private RecordingBooth booth;

    public void connect(
        Musician musician,
        SoundEngineer engineer,
        RecordingBooth booth
    ) {
        this.musician = Objects.requireNonNull(musician);
        this.engineer = Objects.requireNonNull(engineer);
        this.booth = Objects.requireNonNull(booth);
    }

    @Override
    public void notify(StudioMember sender, StudioEvent event) {
        ensureConnected();
        switch (event) {
            case MUSICIAN_READY -> {
                if (sender == musician) {
                    engineer.setStatus("Ready to record");
                }
            }
            case START_TAKE -> startTake(sender);
            case STOP_TAKE -> stopTake(sender);
        }
    }

    private void startTake(StudioMember sender) {
        if (sender != engineer) {
            return;
        }
        if (!musician.isReady()) {
            engineer.setStatus("Waiting for musician");
            return;
        }
        musician.showCue();
        booth.startRecording();
        engineer.setStatus("Recording");
    }

    private void stopTake(StudioMember sender) {
        if (sender == engineer) {
            booth.stopRecording();
            musician.clearCue();
            engineer.setStatus("Take stopped");
        }
    }

    private void ensureConnected() {
        if (musician == null || engineer == null || booth == null) {
            throw new IllegalStateException("Studio participants are not connected");
        }
    }
}
