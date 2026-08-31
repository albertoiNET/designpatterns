package net.albertoi.abstractfactory.factory;

import net.albertoi.abstractfactory.product.AirConditioning;
import net.albertoi.abstractfactory.product.CeilingLighting;
import net.albertoi.abstractfactory.product.ClimateControl;
import net.albertoi.abstractfactory.product.Lighting;

public class IndoorEquipmentFactory implements VenueEquipmentFactory {

    @Override
    public Lighting createLighting() {
        return new CeilingLighting();
    }

    @Override
    public ClimateControl createClimateControl() {
        return new AirConditioning();
    }
}
