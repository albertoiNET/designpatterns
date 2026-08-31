package net.albertoi.memento;

import java.time.Clock;
import java.util.logging.Logger;

public class MainMemento {

    private static final Logger LOGGER = Logger.getLogger(MainMemento.class.getName());

    public static void main(String[] args) {
        BoardGameCampaign campaign =
            new BoardGameCampaign(2, "Clockwork Harbor", 85, Clock.systemUTC());
        CampaignArchive archive = new CampaignArchive();
        archive.store("before-the-boss", campaign.save());

        campaign.update(3, "Storm Citadel", 12);
        campaign.restore(archive.load("before-the-boss"));
        LOGGER.info(() -> "Restored to " + campaign.getLocation());
    }
}
