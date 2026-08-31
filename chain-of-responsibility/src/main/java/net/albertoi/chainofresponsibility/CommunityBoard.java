package net.albertoi.chainofresponsibility;

public class CommunityBoard extends ApprovalHandler {

    @Override
    protected boolean canApprove(GardenRequest request) {
        return request.volunteerHours() <= 40 && request.cost() <= 5_000;
    }

    @Override
    protected String role() {
        return "Community board";
    }
}
