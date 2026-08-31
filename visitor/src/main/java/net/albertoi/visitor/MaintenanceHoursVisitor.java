package net.albertoi.visitor;

public class MaintenanceHoursVisitor implements ReserveAssetVisitor<Integer> {

    @Override
    public Integer visitHabitat(AnimalHabitat habitat) {
        return Math.max(0, (100 - habitat.fenceIntegrity() + 9) / 10);
    }

    @Override
    public Integer visitStation(RangerStation station) {
        return station.smokeAlarmOperational() ? 0 : 2;
    }

    @Override
    public Integer visitWateringHole(WateringHole wateringHole) {
        return wateringHole.ph() >= 6.5 && wateringHole.ph() <= 8.5 ? 0 : 3;
    }
}
