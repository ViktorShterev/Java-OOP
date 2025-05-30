package DesignPatterns.Lab.Command;

import java.util.ArrayList;
import java.util.List;

public class ModifyPrice {
    private final List<Command> commands;
    private Command command;
    public ModifyPrice() {
        this.commands = new ArrayList<Command>();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke(){
        this.commands.add(this.command);
        this.command.executeAction();
    }
}


