package net.albertoi.visitor;

public record WateringHole(String name, double ph) implements ReserveAsset {

    public WateringHole {
        if (name == null || name.isBlank() || ph < 0 || ph > 14) {
            throw new IllegalArgumentException("Watering hole details are invalid");
        }
    }

    @Override
    public <R> R accept(ReserveAssetVisitor<R> visitor) {
        return visitor.visitWateringHole(this);
    }
}
