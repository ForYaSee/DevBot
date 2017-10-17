package command;

import main.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Colors;
import util.Info;

import java.util.concurrent.TimeUnit;

/**
 * Permission Level
 * 0 = Everyone
 * 1 = Permission added
 * 2 = Server Owner
 * 3 = Bot Owner
 */

public abstract class Command {

    protected String command;
    protected String[] args;
    protected MessageReceivedEvent e;

    public Command(String command) {
        this.command = command;
    }

    public void call(String[] args, MessageReceivedEvent e) {
        this.args = args;
        this.e = e;
        execute(args, e);
        e.getMessage().delete().queue();
    }

    protected abstract void execute(String[] args, MessageReceivedEvent e);

    public abstract String getDescription();

    public abstract String getUsage();

    public abstract int getPermissionLevel();

    protected String convertArgsToString() {
        if(args.length == 0)
            return "//No Code";
        String s = "";
        for (int i = 0; i < args.length; i++) {
            s += args[i] + " ";
        }
        return s;
    }

    protected void sendCode(String lang) {
        if (lang.equalsIgnoreCase("java"))
            e.getTextChannel().sendMessage("```" + lang + "\n//Code by " + e.getAuthor().getName() + "\n\n" + convertArgsToString() + "\n```").queue();
        if(lang.equalsIgnoreCase("python"))
            e.getTextChannel().sendMessage("```" + lang + "\n#Code by " + e.getAuthor().getName() + "\n\n" + convertArgsToString() + "\n```").queue();
    }

    protected boolean isMessageFromBotOwner(MessageReceivedEvent e) {
        if (e.getMessage().getAuthor().getIdLong() == Info.getForYaSeeID()) {
            return true;
        }
        return false;
    }

    protected boolean isMessageFromGuildOwner(MessageReceivedEvent e) {
        if (e.getGuild().getOwner() == e.getGuild().getMemberById(e.getAuthor().getId()))
            return true;
        return false;
    }

    protected void sendErrorMessage(MessageReceivedEvent e, String message) {
        EmbedBuilder b = new EmbedBuilder();
        b.setAuthor("Error!", null, Main.getJDA().getSelfUser().getEffectiveAvatarUrl());
        b.addField("", message, false);
        b.setColor(Colors.COLOR_ERROR);
        e.getTextChannel().sendMessage(b.build()).queue(msg2 -> msg2.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    protected void sendNoPermissionMessage(MessageReceivedEvent e) {
        EmbedBuilder b = new EmbedBuilder();
        b.setAuthor("No permissions!", null, e.getAuthor().getEffectiveAvatarUrl());
        b.setTitle("You don't have permissions to do that!");
        b.setColor(Colors.COLOR_ERROR);
        e.getTextChannel().sendMessage(b.build()).queue(msg2 -> msg2.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    protected void sendUsageMessage(MessageReceivedEvent e) {
        e.getTextChannel().sendMessage("Use `" + Info.getBotPrefix() + "help " + getCommand() + "` to get details about the command! " + e.getMessage().getAuthor().getAsMention()).queue(msg -> msg.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    protected void sendNotImplementedMessage(MessageReceivedEvent e) {
        EmbedBuilder b = new EmbedBuilder();
        b.setAuthor("Not Implemented!", null, Main.getJDA().getSelfUser().getEffectiveAvatarUrl());
        b.setTitle("This feature is not implemented!");
        b.setColor(Colors.COLOR_ERROR);
        e.getTextChannel().sendMessage(b.build()).queue(msg2 -> msg2.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public String getCommand() {
        return command;
    }
}

