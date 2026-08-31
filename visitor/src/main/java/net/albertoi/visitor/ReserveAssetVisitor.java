package net.albertoi.visitor;

public interface ReserveAssetVisitor<R> {

    R visitHabitat(AnimalHabitat habitat);

    R visitStation(RangerStation station);

    R visitWateringHole(WateringHole wateringHole);
}
