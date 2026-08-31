package net.albertoi.memento;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MementoTest {

    private BoardGameCampaign campaign;
    private CampaignArchive archive;

    @BeforeEach
    void setUp() {
        Clock clock = Clock.fixed(Instant.parse("2026-08-31T12:00:00Z"), ZoneOffset.UTC);
        campaign = new BoardGameCampaign(1, "Willow Village", 100, clock);
        archive = new CampaignArchive();
    }

    @Test
    void restoresAllOriginatorStateFromASavePoint() {
        archive.store("arrival", campaign.save());
        campaign.update(2, "Sunken Library", 35);

        campaign.restore(archive.load("arrival"));

        assertEquals(1, campaign.getChapter());
        assertEquals("Willow Village", campaign.getLocation());
        assertEquals(100, campaign.getPartyHealth());
    }

    @Test
    void keepsMultipleSavePointsIndependent() {
        archive.store("village", campaign.save());
        campaign.update(2, "Sunken Library", 70);
        archive.store("library", campaign.save());
        campaign.update(3, "Glass Mountain", 20);

        campaign.restore(archive.load("library"));
        assertEquals("Sunken Library", campaign.getLocation());

        campaign.restore(archive.load("village"));
        assertEquals("Willow Village", campaign.getLocation());
    }

    @Test
    void savePointTimestampUsesTheInjectedClock() {
        CampaignSavePoint savePoint = campaign.save();

        assertEquals(Instant.parse("2026-08-31T12:00:00Z"), savePoint.createdAt());
    }

    @Test
    void rejectsAnUnknownSavePoint() {
        assertThrows(IllegalArgumentException.class, () -> archive.load("missing"));
    }
}
