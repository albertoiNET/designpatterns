package net.albertoi.memento;

import java.time.Instant;

public final class CampaignSavePoint {

    private final int chapter;
    private final String location;
    private final int partyHealth;
    private final Instant createdAt;

    CampaignSavePoint(int chapter, String location, int partyHealth, Instant createdAt) {
        this.chapter = chapter;
        this.location = location;
        this.partyHealth = partyHealth;
        this.createdAt = createdAt;
    }

    int chapter() {
        return chapter;
    }

    String location() {
        return location;
    }

    int partyHealth() {
        return partyHealth;
    }

    public Instant createdAt() {
        return createdAt;
    }
}
