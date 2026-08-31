package net.albertoi.chainofresponsibility;

public class GardenCoordinator extends ApprovalHandler {

    @Override
    protected boolean canApprove(GardenRequest request) {
        return request.volunteerHours() <= 8 && request.cost() <= 500;
    }

    @Override
    protected String role() {
        return "Garden coordinator";
    }
}
