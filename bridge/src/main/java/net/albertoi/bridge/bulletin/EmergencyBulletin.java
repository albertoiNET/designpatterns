package net.albertoi.bridge.bulletin;

import net.albertoi.bridge.channel.DeliveryChannel;

public class EmergencyBulletin extends SafetyBulletin {

    public EmergencyBulletin(DeliveryChannel channel) {
        super(channel);
    }

    @Override
    public String publish(String details) {
        return channel.send("EMERGENCY - LEAVE THE TRAIL", details.toUpperCase());
    }
}
