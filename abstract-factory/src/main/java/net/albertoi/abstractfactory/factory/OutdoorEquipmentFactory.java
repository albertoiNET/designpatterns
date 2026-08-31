package net.albertoi.abstractfactory.factory;

import net.albertoi.abstractfactory.product.ClimateControl;
import net.albertoi.abstractfactory.product.MistCooling;
import net.albertoi.abstractfactory.product.PathLighting;
import net.albertoi.abstractfactory.product.Lighting;

public class OutdoorEquipmentFactory implements VenueEquipmentFactory {

    @Override
    public Lighting createLighting() {
        return new PathLighting();
    }

    @Override
    public ClimateControl createClimateControl() {
        return new MistCooling();
    }
}
