package net.albertoi.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MediatorTest {

    private Musician musician;
    private SoundEngineer engineer;
    private RecordingBooth booth;

    @BeforeEach
    void setUp() {
        RecordingSessionMediator mediator = new RecordingSessionMediator();
        musician = new Musician(mediator);
        engineer = new SoundEngineer(mediator);
        booth = new RecordingBooth(mediator);
        mediator.connect(musician, engineer, booth);
    }

    @Test
    void readinessIsCommunicatedWithoutDirectColleagueReferences() {
        musician.announceReady();

        assertEquals("Ready to record", engineer.getStatus());
    }

    @Test
    void mediatorPreventsARecordingBeforeTheMusicianIsReady() {
        engineer.startTake();

        assertEquals("Waiting for musician", engineer.getStatus());
        assertFalse(booth.isRecording());
        assertFalse(musician.isCueLightOn());
    }

    @Test
    void startingAndStoppingCoordinatesAllParticipants() {
        musician.announceReady();
        engineer.startTake();

        assertTrue(booth.isRecording());
        assertTrue(musician.isCueLightOn());
        assertEquals("Recording", engineer.getStatus());

        engineer.stopTake();

        assertFalse(booth.isRecording());
        assertFalse(musician.isCueLightOn());
        assertEquals(1, booth.getCompletedTakes());
    }
}
