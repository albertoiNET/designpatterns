package net.albertoi.decorator;

public class BasicShippingLabel implements ShippingLabel {

    private final String recipient;
    private final String destination;

    public BasicShippingLabel(String recipient, String destination) {
        this.recipient = recipient;
        this.destination = destination;
    }

    @Override
    public String print() {
        return "Deliver to " + recipient + " at " + destination;
    }
}
