package net.albertoi.memento;

import java.time.Clock;
import java.util.Objects;

public class BoardGameCampaign {

    private final Clock clock;
    private int chapter;
    private String location;
    private int partyHealth;

    public BoardGameCampaign(
        int chapter,
        String location,
        int partyHealth,
        Clock clock
    ) {
        this.clock = Objects.requireNonNull(clock);
        update(chapter, location, partyHealth);
    }

    public void update(int chapter, String location, int partyHealth) {
        if (chapter < 1 || location == null || location.isBlank()) {
            throw new IllegalArgumentException("Campaign position is invalid");
        }
        if (partyHealth < 0 || partyHealth > 100) {
            throw new IllegalArgumentException("Party health must be between 0 and 100");
        }
        this.chapter = chapter;
        this.location = location;
        this.partyHealth = partyHealth;
    }

    public CampaignSavePoint save() {
        return new CampaignSavePoint(chapter, location, partyHealth, clock.instant());
    }

    public void restore(CampaignSavePoint savePoint) {
        CampaignSavePoint saved = Objects.requireNonNull(savePoint);
        update(saved.chapter(), saved.location(), saved.partyHealth());
    }

    public int getChapter() {
        return chapter;
    }

    public String getLocation() {
        return location;
    }

    public int getPartyHealth() {
        return partyHealth;
    }
}
