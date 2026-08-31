package net.albertoi.abstractfactory;

import java.util.List;
import net.albertoi.abstractfactory.factory.VenueEquipmentFactory;
import net.albertoi.abstractfactory.product.ClimateControl;
import net.albertoi.abstractfactory.product.Lighting;

public class EventPlanner {

    private final Lighting lighting;
    private final ClimateControl climateControl;

    public EventPlanner(VenueEquipmentFactory equipmentFactory) {
        this.lighting = equipmentFactory.createLighting();
        this.climateControl = equipmentFactory.createClimateControl();
    }

    public EventPlan prepareVenue() {
        if (!lighting.venueType().equals(climateControl.venueType())) {
            throw new IllegalStateException("The equipment families are not compatible");
        }

        return new EventPlan(
            lighting.venueType(),
            List.of(lighting.install(), climateControl.configure())
        );
    }
}
