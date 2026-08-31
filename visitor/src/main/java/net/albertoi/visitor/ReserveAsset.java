package net.albertoi.visitor;

public interface ReserveAsset {

    <R> R accept(ReserveAssetVisitor<R> visitor);
}
