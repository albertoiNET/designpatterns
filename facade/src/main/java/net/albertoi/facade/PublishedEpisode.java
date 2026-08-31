package net.albertoi.facade;

public record PublishedEpisode(
    String normalizedAudioFile,
    String transcriptFile,
    String publicUrl
) {
}
