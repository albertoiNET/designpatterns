package net.albertoi.chainofresponsibility;

import java.util.logging.Logger;

public class MainChainOfResponsibility {

    private static final Logger LOGGER =
        Logger.getLogger(MainChainOfResponsibility.class.getName());

    public static void main(String[] args) {
        RequestHandler lead = new VolunteerLead();
        lead.setNext(new GardenCoordinator()).setNext(new CommunityBoard());

        Approval approval = lead.handle(
            new GardenRequest("Build an accessible raised bed", 24, 1_200)
        );
        LOGGER.info(() -> approval.decidedBy() + ": " + approval.approved());
    }
}
