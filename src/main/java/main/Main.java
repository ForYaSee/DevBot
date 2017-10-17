package main;

import core.CommandManager;
import core.GameAnimator;
import core.ListenerManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Info;
import util.Logger;

import javax.security.auth.login.LoginException;

public class Main {

    private static GameAnimator gameAnimator;

    private static JDA jda;

    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(Info.getBotToken());
        builder.setGame(Game.of(Info.getBotVersion()));

        new ListenerManager(builder);
        new CommandManager();

        try {
            jda = builder.buildBlocking();
        } catch (LoginException e) {
            Logger.error(e.getMessage());
        } catch (InterruptedException e) {
            Logger.error(e.getMessage());
        } catch (RateLimitedException e) {
            Logger.error(e.getMessage());
        }
        gameAnimator = new GameAnimator();
        gameAnimator.start();
    }

    public static JDA getJDA() {
        return jda;
    }

}
