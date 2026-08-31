package net.albertoi.visitor;

public record RangerStation(String name, boolean smokeAlarmOperational)
    implements ReserveAsset {

    public RangerStation {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Station name is required");
        }
    }

    @Override
    public <R> R accept(ReserveAssetVisitor<R> visitor) {
        return visitor.visitStation(this);
    }
}
