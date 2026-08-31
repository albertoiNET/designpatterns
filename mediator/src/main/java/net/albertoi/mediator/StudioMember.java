package net.albertoi.mediator;

import java.util.Objects;

public abstract class StudioMember {

    protected final StudioMediator mediator;

    protected StudioMember(StudioMediator mediator) {
        this.mediator = Objects.requireNonNull(mediator);
    }
}
