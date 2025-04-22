package DesignPatterns.Lab.AllPatterns.Command;

import java.util.ArrayDeque;

public class Switch {
    private ArrayDeque<Command.Command> history;

    public Switch() {
        this.history = new ArrayDeque<>();
    }

    public void storeAndExecute(Command.Command command) {
        this.history.push(command);
        command.execute();
    }
    public void undoExecuted() {
        this.history.pop();

        Command.Command command = this.history.peek();
        if (command != null) {
            command.execute();
        }
    }
}
