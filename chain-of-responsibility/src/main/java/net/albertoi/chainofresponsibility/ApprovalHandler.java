package net.albertoi.chainofresponsibility;

import java.util.Objects;

public abstract class ApprovalHandler implements RequestHandler {

    private RequestHandler next;

    @Override
    public RequestHandler setNext(RequestHandler next) {
        this.next = Objects.requireNonNull(next);
        return next;
    }

    @Override
    public Approval handle(GardenRequest request) {
        Objects.requireNonNull(request);
        if (canApprove(request)) {
            return new Approval(true, role(), "Within approval limit");
        }
        if (next != null) {
            return next.handle(request);
        }
        return new Approval(false, role(), "Request exceeds the community garden limit");
    }

    protected abstract boolean canApprove(GardenRequest request);

    protected abstract String role();
}
