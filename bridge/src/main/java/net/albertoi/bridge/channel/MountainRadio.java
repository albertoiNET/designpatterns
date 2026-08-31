package net.albertoi.bridge.channel;

public class MountainRadio implements DeliveryChannel {

    @Override
    public String send(String headline, String details) {
        return "Radio channel 7 | " + headline + " | " + details;
    }
}
