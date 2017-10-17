package commands.codeconv;

import command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class JavaCommand extends Command {
    public JavaCommand(String command) {
        super(command);
    }

    @Override
    protected void execute(String[] args, MessageReceivedEvent e) {
        sendCode("java");
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
