package net.albertoi.bridge.bulletin;

import net.albertoi.bridge.channel.DeliveryChannel;

public class RoutineBulletin extends SafetyBulletin {

    public RoutineBulletin(DeliveryChannel channel) {
        super(channel);
    }

    @Override
    public String publish(String details) {
        return channel.send("DAILY TRAIL UPDATE", details);
    }
}
