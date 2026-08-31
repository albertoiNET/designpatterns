package net.albertoi.chainofresponsibility;

public record Approval(boolean approved, String decidedBy, String reason) {
}
