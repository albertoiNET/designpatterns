package net.albertoi.visitor;

import java.util.List;
import java.util.logging.Logger;

public class MainVisitor {

    private static final Logger LOGGER = Logger.getLogger(MainVisitor.class.getName());

    public static void main(String[] args) {
        List<ReserveAsset> assets = List.of(
            new AnimalHabitat("Otter enclosure", 92),
            new RangerStation("North station", true),
            new WateringHole("Acacia pool", 7.2)
        );
        SafetyInspectionVisitor inspection = new SafetyInspectionVisitor();

        assets.stream()
            .map(asset -> asset.accept(inspection))
            .forEach(result -> LOGGER.info(
                () -> result.assetName() + ": " + result.finding()
            ));
    }
}
