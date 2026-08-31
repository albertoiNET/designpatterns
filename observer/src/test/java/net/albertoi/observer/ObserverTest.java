package net.albertoi.observer;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObserverTest {

    private BicycleStation station;
    private RiderAvailabilityAlert riderAlert;
    private MaintenanceDashboard dashboard;

    @BeforeEach
    void setUp() {
        station = new BicycleStation("Market Square", 10, 2);
        riderAlert = new RiderAvailabilityAlert(3);
        dashboard = new MaintenanceDashboard();
        station.subscribe(riderAlert);
        station.subscribe(dashboard);
    }

    @Test
    void notifiesAllObserversWhenAvailabilityChanges() {
        station.returnBike();

        assertEquals(
            "Market Square has 3 bikes",
            riderAlert.getMessages().get(0)
        );
        assertEquals(new StationSnapshot("Market Square", 3, 7), dashboard.getLatestSnapshot());
    }

    @Test
    void observerCanFilterUpdatesAccordingToItsOwnInterest() {
        station.rentBike();

        assertTrue(riderAlert.getMessages().isEmpty());
        assertEquals(1, dashboard.getUpdateCount());
    }

    @Test
    void unsubscribedObserverStopsReceivingUpdates() {
        station.unsubscribe(dashboard);
        station.returnBike();
        station.returnBike();

        assertEquals(0, dashboard.getUpdateCount());
        assertEquals(2, riderAlert.getMessages().size());
    }

    @Test
    void observerCanSafelyUnsubscribeDuringANotification() {
        BicycleStation localStation = new BicycleStation("Canal Bridge", 8, 2);
        AtomicInteger oneShotUpdates = new AtomicInteger();
        AtomicInteger regularUpdates = new AtomicInteger();
        StationObserver oneShotObserver = new StationObserver() {
            @Override
            public void update(StationSnapshot stationSnapshot) {
                oneShotUpdates.incrementAndGet();
                localStation.unsubscribe(this);
            }
        };
        localStation.subscribe(oneShotObserver);
        localStation.subscribe(stationSnapshot -> regularUpdates.incrementAndGet());

        localStation.returnBike();
        localStation.returnBike();

        assertEquals(1, oneShotUpdates.get());
        assertEquals(2, regularUpdates.get());
    }
}
