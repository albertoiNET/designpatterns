package net.albertoi.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeTest {

    @Test
    void coordinatesThePublishingSubsystemBehindOneOperation() {
        Episode episode = new Episode("Night Sky Notes", "episode-07.flac");

        PublishedEpisode result = new PodcastPublishingFacade().publish(episode);

        assertEquals("audio/night-sky-notes-normalized.wav", result.normalizedAudioFile());
        assertEquals("transcripts/episode-07.txt", result.transcriptFile());
        assertEquals("https://podcasts.example/episodes/night-sky-notes", result.publicUrl());
    }
}
