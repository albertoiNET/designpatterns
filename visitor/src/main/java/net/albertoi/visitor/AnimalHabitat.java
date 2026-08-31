package net.albertoi.visitor;

public record AnimalHabitat(String name, int fenceIntegrity) implements ReserveAsset {

    public AnimalHabitat {
        if (name == null || name.isBlank() || fenceIntegrity < 0 || fenceIntegrity > 100) {
            throw new IllegalArgumentException("Habitat details are invalid");
        }
    }

    @Override
    public <R> R accept(ReserveAssetVisitor<R> visitor) {
        return visitor.visitHabitat(this);
    }
}
