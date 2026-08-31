package net.albertoi.mediator;

public class RecordingBooth extends StudioMember {

    private boolean recording;
    private int completedTakes;

    public RecordingBooth(StudioMediator mediator) {
        super(mediator);
    }

    void startRecording() {
        recording = true;
    }

    void stopRecording() {
        if (recording) {
            completedTakes++;
        }
        recording = false;
    }

    public boolean isRecording() {
        return recording;
    }

    public int getCompletedTakes() {
        return completedTakes;
    }
}
