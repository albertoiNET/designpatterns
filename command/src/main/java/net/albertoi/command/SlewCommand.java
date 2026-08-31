package net.albertoi.command;

import java.util.Objects;

public class SlewCommand implements TelescopeCommand {

    private final Telescope telescope;
    private final int targetAzimuth;
    private final int targetElevation;
    private int previousAzimuth;
    private int previousElevation;

    public SlewCommand(Telescope telescope, int targetAzimuth, int targetElevation) {
        this.telescope = Objects.requireNonNull(telescope);
        this.targetAzimuth = targetAzimuth;
        this.targetElevation = targetElevation;
    }

    @Override
    public void execute() {
        previousAzimuth = telescope.getAzimuth();
        previousElevation = telescope.getElevation();
        telescope.slewTo(targetAzimuth, targetElevation);
    }

    @Override
    public void undo() {
        telescope.slewTo(previousAzimuth, previousElevation);
    }
}
