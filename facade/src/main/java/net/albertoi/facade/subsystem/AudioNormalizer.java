package net.albertoi.facade.subsystem;

import net.albertoi.facade.Episode;

public class AudioNormalizer {

    public String normalize(Episode episode) {
        return "audio/" + slug(episode.title()) + "-normalized.wav";
    }

    private String slug(String value) {
        return value.toLowerCase()
            .replaceAll("[^a-z0-9]+", "-")
            .replaceAll("(^-|-$)", "");
    }
}
