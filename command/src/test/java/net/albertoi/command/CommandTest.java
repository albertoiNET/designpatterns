package net.albertoi.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandTest {

    private Telescope telescope;
    private ObservationConsole console;

    @BeforeEach
    void setUp() {
        telescope = new Telescope();
        console = new ObservationConsole();
    }

    @Test
    void executesACommandAgainstTheReceiver() {
        console.submit(new SlewCommand(telescope, 210, 36));

        assertEquals(210, telescope.getAzimuth());
        assertEquals(36, telescope.getElevation());
    }

    @Test
    void undoesCommandsInReverseOrder() {
        console.submit(new SlewCommand(telescope, 210, 36));
        console.submit(new OpenShutterCommand(telescope));

        assertTrue(telescope.isShutterOpen());
        assertTrue(console.undoLast());
        assertFalse(telescope.isShutterOpen());
        assertEquals(210, telescope.getAzimuth());

        assertTrue(console.undoLast());
        assertEquals(0, telescope.getAzimuth());
        assertEquals(0, telescope.getElevation());
    }

    @Test
    void reportsWhenThereIsNothingToUndo() {
        assertFalse(console.undoLast());
    }
}
