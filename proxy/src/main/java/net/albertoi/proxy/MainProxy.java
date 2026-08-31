package net.albertoi.proxy;

import java.util.logging.Logger;

public class MainProxy {

    private static final Logger LOGGER = Logger.getLogger(MainProxy.class.getName());

    public static void main(String[] args) {
        RemoteResearchArchive remoteArchive = new RemoteResearchArchive();
        ResearchArchive archive = new ResearchArchiveProxy(remoteArchive);

        LOGGER.info(() -> archive.open("public-catalog", AccessLevel.RESEARCHER));
        LOGGER.info(() -> archive.open("public-catalog", AccessLevel.RESEARCHER));
        LOGGER.info(() -> "Remote archive requests: " + remoteArchive.loadCount());
    }
}
