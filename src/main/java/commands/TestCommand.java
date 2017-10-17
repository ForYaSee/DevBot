package commands;

import command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class TestCommand extends Command {

    public TestCommand(String command) {
        super(command);
    }

    @Override
    protected void execute(String[] args, MessageReceivedEvent e) {
        sendNotImplementedMessage(e);
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
        return 3;
    }
}
