package net.albertoi.facade.subsystem;

import net.albertoi.facade.Episode;

public class PodcastFeed {

    public String publish(Episode episode, String audioFile, String transcriptFile) {
        if (audioFile.isBlank() || transcriptFile.isBlank()) {
            throw new IllegalArgumentException("Audio and transcript are required");
        }
        return "https://podcasts.example/episodes/" + episode.title()
            .toLowerCase()
            .replaceAll("[^a-z0-9]+", "-")
            .replaceAll("(^-|-$)", "");
    }
}
