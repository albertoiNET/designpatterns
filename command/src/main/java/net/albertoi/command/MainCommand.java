package net.albertoi.command;

import java.util.logging.Logger;

public class MainCommand {

    private static final Logger LOGGER = Logger.getLogger(MainCommand.class.getName());

    public static void main(String[] args) {
        Telescope telescope = new Telescope();
        ObservationConsole console = new ObservationConsole();

        console.submit(new SlewCommand(telescope, 142, 48));
        console.submit(new OpenShutterCommand(telescope));
        LOGGER.info(() -> "Observing at azimuth " + telescope.getAzimuth());

        console.undoLast();
        LOGGER.info(() -> "Shutter open after undo: " + telescope.isShutterOpen());
    }
}
