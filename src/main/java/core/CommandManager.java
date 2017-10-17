package core;

import command.CommandHandler;
import commands.codeconv.JavaCommand;
import commands.TestCommand;
import commands.codeconv.PythonCommand;

public class CommandManager {

    public CommandManager() {
        initCommands();
    }

    private void initCommands() {
        CommandHandler.addCommand(new JavaCommand("java"));
        CommandHandler.addCommand(new PythonCommand("python"));
        CommandHandler.addCommand(new TestCommand("test"));
    }
}
