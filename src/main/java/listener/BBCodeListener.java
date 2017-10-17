package listener;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.MessageUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BBCodeListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContent();
        String lowerCase = message.toLowerCase();
        boolean changed = false;
        if(lowerCase.contains("[code]") && lowerCase.contains("[/code]")) {
            message = message.replace("[CODE]", "```");
            message = message.replace("[/CODE]", "```");
            message = message.replace("[code]", "```");
            message = message.replace("[/code]", "```");
            changed = true;
        }

        if(lowerCase.contains("[b]") && lowerCase.contains("[/b]")) {
            message = message.replace("[B]", "**");
            message = message.replace("[/B]", "**");
            message = message.replace("[b]", "**");
            message = message.replace("[/b]", "**");
            changed = true;
        }

        if(lowerCase.contains("[i]") && lowerCase.contains("[/i]")) {
            message = message.replace("[I]", "*");
            message = message.replace("[/I]", "*");
            message = message.replace("[i]", "*");
            message = message.replace("[/i]", "*");
            changed = true;
        }

        if(lowerCase.contains("[s]") && lowerCase.contains("[/s]")) {
            message = message.replace("[S]", "~~");
            message = message.replace("[/S]", "~~");
            message = message.replace("[s]", "~~");
            message = message.replace("[/s]", "~~");
            changed = true;
        }

        if(lowerCase.contains("[u]") && lowerCase.contains("[/u]")) {
            message = message.replace("[U]", "__");
            message = message.replace("[/U]", "__");
            message = message.replace("[u]", "__");
            message = message.replace("[/u]", "__");
            changed = true;
        }

        if(changed) {
            e.getTextChannel().sendMessage(new EmbedBuilder().setAuthor(e.getAuthor().getName(), null, e.getAuthor().getEffectiveAvatarUrl()).setDescription(message).build()).queue();
            e.getMessage().delete().queue();
        }
    }

    @Override
    public void onMessageUpdate(MessageUpdateEvent e) {
        String message = e.getMessage().getContent();
        String lowerCase = message.toLowerCase();
        boolean changed = false;
        if(lowerCase.contains("[code]") && lowerCase.contains("[/code]")) {
            message = message.replace("[CODE]", "```");
            message = message.replace("[/CODE]", "```");
            message = message.replace("[code]", "```");
            message = message.replace("[/code]", "```");
            changed = true;
        }

        if(lowerCase.contains("[b]") && lowerCase.contains("[/b]")) {
            message = message.replace("[B]", "**");
            message = message.replace("[/B]", "**");
            message = message.replace("[b]", "**");
            message = message.replace("[/b]", "**");
            changed = true;
        }

        if(lowerCase.contains("[i]") && lowerCase.contains("[/i]")) {
            message = message.replace("[I]", "*");
            message = message.replace("[/I]", "*");
            message = message.replace("[i]", "*");
            message = message.replace("[/i]", "*");
            changed = true;
        }

        if(lowerCase.contains("[s]") && lowerCase.contains("[/s]")) {
            message = message.replace("[S]", "~~");
            message = message.replace("[/S]", "~~");
            message = message.replace("[s]", "~~");
            message = message.replace("[/s]", "~~");
            changed = true;
        }

        if(lowerCase.contains("[u]") && lowerCase.contains("[/u]")) {
            message = message.replace("[U]", "__");
            message = message.replace("[/U]", "__");
            message = message.replace("[u]", "__");
            message = message.replace("[/u]", "__");
            changed = true;
        }

        if(changed) {
            e.getTextChannel().sendMessage(new EmbedBuilder().setAuthor(e.getAuthor().getName(), null, e.getAuthor().getEffectiveAvatarUrl()).setDescription(message).build()).queue();
            e.getMessage().delete().queue();
        }
    }
}
