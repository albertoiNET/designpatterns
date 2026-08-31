package net.albertoi.chainofresponsibility;

public class VolunteerLead extends ApprovalHandler {

    @Override
    protected boolean canApprove(GardenRequest request) {
        return request.volunteerHours() <= 2 && request.cost() <= 50;
    }

    @Override
    protected String role() {
        return "Volunteer lead";
    }
}
