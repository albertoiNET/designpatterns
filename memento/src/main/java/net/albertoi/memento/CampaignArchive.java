package net.albertoi.memento;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CampaignArchive {

    private final Map<String, CampaignSavePoint> savePoints = new LinkedHashMap<>();

    public void store(String name, CampaignSavePoint savePoint) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("A save point name is required");
        }
        savePoints.put(name, Objects.requireNonNull(savePoint));
    }

    public CampaignSavePoint load(String name) {
        CampaignSavePoint savePoint = savePoints.get(name);
        if (savePoint == null) {
            throw new IllegalArgumentException("Unknown save point: " + name);
        }
        return savePoint;
    }
}
