package net.albertoi.abstractfactory;

import java.util.logging.Logger;
import net.albertoi.abstractfactory.factory.IndoorEquipmentFactory;
import net.albertoi.abstractfactory.factory.OutdoorEquipmentFactory;
import net.albertoi.abstractfactory.factory.VenueEquipmentFactory;

public class MainAbstractFactory {

    private static final Logger LOGGER = Logger.getLogger(MainAbstractFactory.class.getName());

    public static void main(String[] args) {
        VenueEquipmentFactory factory = args.length > 0 && "outdoor".equalsIgnoreCase(args[0])
            ? new OutdoorEquipmentFactory()
            : new IndoorEquipmentFactory();

        EventPlan plan = new EventPlanner(factory).prepareVenue();
        LOGGER.info(() -> "Preparing " + plan.venueType() + " venue: " + plan.instructions());
    }
}
