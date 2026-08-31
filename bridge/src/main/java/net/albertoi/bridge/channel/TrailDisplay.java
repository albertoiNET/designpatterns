package net.albertoi.bridge.channel;

public class TrailDisplay implements DeliveryChannel {

    @Override
    public String send(String headline, String details) {
        return "Trail display: [" + headline + "] " + details;
    }
}
