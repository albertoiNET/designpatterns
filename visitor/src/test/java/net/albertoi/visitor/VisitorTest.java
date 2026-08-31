package net.albertoi.visitor;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VisitorTest {

    private final SafetyInspectionVisitor inspection = new SafetyInspectionVisitor();

    @Test
    void dispatchesHabitatToItsSpecificInspection() {
        InspectionResult result = new AnimalHabitat("Wetland fence", 72).accept(inspection);

        assertFalse(result.passed());
        assertEquals("Fence repair required", result.finding());
    }

    @Test
    void inspectsDifferentAssetTypesThroughOneVisitor() {
        List<ReserveAsset> assets = List.of(
            new RangerStation("East station", true),
            new WateringHole("Reed pool", 9.1)
        );

        List<InspectionResult> results = assets.stream()
            .map(asset -> asset.accept(inspection))
            .toList();

        assertTrue(results.get(0).passed());
        assertFalse(results.get(1).passed());
        assertEquals("Water quality investigation required", results.get(1).finding());
    }

    @Test
    void anotherVisitorAddsAnOperationWithoutChangingAssets() {
        MaintenanceHoursVisitor maintenance = new MaintenanceHoursVisitor();
        List<ReserveAsset> assets = List.of(
            new AnimalHabitat("Wetland fence", 72),
            new RangerStation("East station", false),
            new WateringHole("Reed pool", 7.0)
        );

        List<Integer> hours = assets.stream()
            .map(asset -> asset.accept(maintenance))
            .toList();

        assertEquals(List.of(3, 2, 0), hours);
    }
}
