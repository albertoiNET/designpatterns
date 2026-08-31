package net.albertoi.observer;

public class MaintenanceDashboard implements StationObserver {

    private StationSnapshot latestSnapshot;
    private int updateCount;

    @Override
    public void update(StationSnapshot snapshot) {
        latestSnapshot = snapshot;
        updateCount++;
    }

    public StationSnapshot getLatestSnapshot() {
        return latestSnapshot;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
