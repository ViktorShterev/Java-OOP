package DesignPatterns.Lab.Product;

import java.util.ArrayList;
import java.util.List;

public class ModifyPriceP {
    private final List<CommandP> commands;
    private CommandP command;
    public ModifyPriceP() {
        this.commands = new ArrayList<CommandP>();
    }

    public void setCommand(CommandP command) {
        this.command = command;
    }

    public void invoke(){
        this.commands.add(this.command);
        this.command.executeAction();
    }
}
