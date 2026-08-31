package net.albertoi.mediator;

import java.util.logging.Logger;

public class MainMediator {

    private static final Logger LOGGER = Logger.getLogger(MainMediator.class.getName());

    public static void main(String[] args) {
        RecordingSessionMediator mediator = new RecordingSessionMediator();
        Musician musician = new Musician(mediator);
        SoundEngineer engineer = new SoundEngineer(mediator);
        RecordingBooth booth = new RecordingBooth(mediator);
        mediator.connect(musician, engineer, booth);

        musician.announceReady();
        engineer.startTake();
        LOGGER.info(() -> "Session status: " + engineer.getStatus());
    }
}
