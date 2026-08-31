package net.albertoi.command;

import java.util.Objects;

public class OpenShutterCommand implements TelescopeCommand {

    private final Telescope telescope;
    private boolean previousState;

    public OpenShutterCommand(Telescope telescope) {
        this.telescope = Objects.requireNonNull(telescope);
    }

    @Override
    public void execute() {
        previousState = telescope.isShutterOpen();
        telescope.setShutterOpen(true);
    }

    @Override
    public void undo() {
        telescope.setShutterOpen(previousState);
    }
}
