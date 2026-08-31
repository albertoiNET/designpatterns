package net.albertoi.abstractfactory.factory;

import net.albertoi.abstractfactory.product.ClimateControl;
import net.albertoi.abstractfactory.product.Lighting;

public interface VenueEquipmentFactory {

    Lighting createLighting();

    ClimateControl createClimateControl();
}
