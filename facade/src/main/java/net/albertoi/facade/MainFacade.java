package net.albertoi.facade;

import java.util.logging.Logger;

public class MainFacade {

    private static final Logger LOGGER = Logger.getLogger(MainFacade.class.getName());

    public static void main(String[] args) {
        Episode episode = new Episode("How Community Radio Works", "raw-interview.flac");
        PublishedEpisode result = new PodcastPublishingFacade().publish(episode);

        LOGGER.info(() -> "Published at " + result.publicUrl());
    }
}
