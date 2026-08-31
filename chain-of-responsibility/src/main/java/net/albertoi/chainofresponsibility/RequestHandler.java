package net.albertoi.chainofresponsibility;

public interface RequestHandler {

    RequestHandler setNext(RequestHandler next);

    Approval handle(GardenRequest request);
}
