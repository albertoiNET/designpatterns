package net.albertoi.decorator;

public class TrackingLabel extends ShippingLabelDecorator {

    private final String trackingCode;

    public TrackingLabel(ShippingLabel wrappedLabel, String trackingCode) {
        super(wrappedLabel);
        this.trackingCode = trackingCode;
    }

    @Override
    public String print() {
        return wrappedLabel.print() + " | Tracking: " + trackingCode;
    }
}
