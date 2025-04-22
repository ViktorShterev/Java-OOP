import java.util.ArrayList;
import java.util.List;

public class ModifyPrice {
    private final List<CommandP> commands;
    private CommandP command;
    public ModifyPrice() {
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


