package commands.codeconv;

import command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PythonCommand extends Command {
    public PythonCommand(String command) {
        super(command);
    }

    @Override
    protected void execute(String[] args, MessageReceivedEvent e) {
        sendCode("python");
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public int getPermissionLevel() {
        return 0;
    }
}
