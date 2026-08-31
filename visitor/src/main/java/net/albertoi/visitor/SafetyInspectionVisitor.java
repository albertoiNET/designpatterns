package net.albertoi.visitor;

public class SafetyInspectionVisitor implements ReserveAssetVisitor<InspectionResult> {

    @Override
    public InspectionResult visitHabitat(AnimalHabitat habitat) {
        boolean passed = habitat.fenceIntegrity() >= 80;
        return new InspectionResult(
            habitat.name(),
            passed,
            passed ? "Fence secure" : "Fence repair required"
        );
    }

    @Override
    public InspectionResult visitStation(RangerStation station) {
        boolean passed = station.smokeAlarmOperational();
        return new InspectionResult(
            station.name(),
            passed,
            passed ? "Smoke alarm operational" : "Replace smoke alarm"
        );
    }

    @Override
    public InspectionResult visitWateringHole(WateringHole wateringHole) {
        boolean passed = wateringHole.ph() >= 6.5 && wateringHole.ph() <= 8.5;
        return new InspectionResult(
            wateringHole.name(),
            passed,
            passed ? "Water quality acceptable" : "Water quality investigation required"
        );
    }
}
