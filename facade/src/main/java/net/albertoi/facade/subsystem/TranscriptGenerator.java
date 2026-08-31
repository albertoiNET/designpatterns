package net.albertoi.facade.subsystem;

import net.albertoi.facade.Episode;

public class TranscriptGenerator {

    public String generate(Episode episode) {
        return "transcripts/" + episode.sourceAudioFile().replaceFirst("\\.[^.]+$", "") + ".txt";
    }
}
