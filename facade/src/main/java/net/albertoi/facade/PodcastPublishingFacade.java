package net.albertoi.facade;

import net.albertoi.facade.subsystem.AudioNormalizer;
import net.albertoi.facade.subsystem.PodcastFeed;
import net.albertoi.facade.subsystem.TranscriptGenerator;

public class PodcastPublishingFacade {

    private final AudioNormalizer audioNormalizer;
    private final TranscriptGenerator transcriptGenerator;
    private final PodcastFeed podcastFeed;

    public PodcastPublishingFacade() {
        this(new AudioNormalizer(), new TranscriptGenerator(), new PodcastFeed());
    }

    PodcastPublishingFacade(
        AudioNormalizer audioNormalizer,
        TranscriptGenerator transcriptGenerator,
        PodcastFeed podcastFeed
    ) {
        this.audioNormalizer = audioNormalizer;
        this.transcriptGenerator = transcriptGenerator;
        this.podcastFeed = podcastFeed;
    }

    public PublishedEpisode publish(Episode episode) {
        String normalizedAudio = audioNormalizer.normalize(episode);
        String transcript = transcriptGenerator.generate(episode);
        String publicUrl = podcastFeed.publish(episode, normalizedAudio, transcript);
        return new PublishedEpisode(normalizedAudio, transcript, publicUrl);
    }
}
