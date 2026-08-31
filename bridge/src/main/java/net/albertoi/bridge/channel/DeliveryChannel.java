package net.albertoi.bridge.channel;

public interface DeliveryChannel {

    String send(String headline, String details);
}
