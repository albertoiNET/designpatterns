package net.albertoi.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChainOfResponsibilityTest {

    private RequestHandler chain;

    @BeforeEach
    void setUp() {
        chain = new VolunteerLead();
        chain.setNext(new GardenCoordinator()).setNext(new CommunityBoard());
    }

    @Test
    void firstHandlerApprovesSmallRequests() {
        Approval result = chain.handle(new GardenRequest("Replace herb labels", 1, 20));

        assertTrue(result.approved());
        assertEquals("Volunteer lead", result.decidedBy());
    }

    @Test
    void delegatesRequestsBeyondAnEarlyHandlersLimit() {
        Approval result = chain.handle(new GardenRequest("Repair irrigation line", 6, 300));

        assertTrue(result.approved());
        assertEquals("Garden coordinator", result.decidedBy());
    }

    @Test
    void reachesTheLastHandlerForLargeRequests() {
        Approval result = chain.handle(new GardenRequest("Build an accessible bed", 24, 1_200));

        assertTrue(result.approved());
        assertEquals("Community board", result.decidedBy());
    }

    @Test
    void rejectsRequestsThatNoHandlerCanApprove() {
        Approval result = chain.handle(new GardenRequest("Construct a greenhouse", 80, 12_000));

        assertFalse(result.approved());
        assertEquals("Community board", result.decidedBy());
    }
}
