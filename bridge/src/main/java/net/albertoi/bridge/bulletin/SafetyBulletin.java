package net.albertoi.bridge.bulletin;

import net.albertoi.bridge.channel.DeliveryChannel;

public abstract class SafetyBulletin {

    protected final DeliveryChannel channel;

    protected SafetyBulletin(DeliveryChannel channel) {
        this.channel = channel;
    }

    public abstract String publish(String details);
}
