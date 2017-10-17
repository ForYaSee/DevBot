package listener;

import command.CommandHandler;
import main.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Info;

public class CommandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {
        try {
            if (e.getAuthor() != Main.getJDA().getSelfUser()) {
                if (e.getMessage().getContent().startsWith(Info.getBotPrefix())) {
                    CommandHandler.handleCommand(CommandHandler.parser.parse(e.getMessage().getContent(), e));
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
