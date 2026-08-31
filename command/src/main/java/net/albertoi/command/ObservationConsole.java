package net.albertoi.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class ObservationConsole {

    private final Deque<TelescopeCommand> history = new ArrayDeque<>();

    public void submit(TelescopeCommand command) {
        TelescopeCommand acceptedCommand = Objects.requireNonNull(command);
        acceptedCommand.execute();
        history.push(acceptedCommand);
    }

    public boolean undoLast() {
        if (history.isEmpty()) {
            return false;
        }
        history.pop().undo();
        return true;
    }
}
