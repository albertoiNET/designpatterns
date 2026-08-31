package net.albertoi.decorator;

public abstract class ShippingLabelDecorator implements ShippingLabel {

    protected final ShippingLabel wrappedLabel;

    protected ShippingLabelDecorator(ShippingLabel wrappedLabel) {
        this.wrappedLabel = wrappedLabel;
    }
}
