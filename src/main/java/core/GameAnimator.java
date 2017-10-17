package core;


import main.Main;
import net.dv8tion.jda.core.entities.Game;

public class GameAnimator implements Runnable {

    private Thread t;
    private boolean running = false;

    private int currentGame = 0;

    private String[] gameAnimations = {
            ".java <Code>",
            ".python <Code>"
    };

    @Override
    public void run() {
        long last = 0;
        while (running) {
            if (System.currentTimeMillis() >= last + 60000) {
                Main.getJDA().getPresence().setGame(Game.of(gameAnimations[currentGame]));
                last = System.currentTimeMillis();

                if (currentGame == gameAnimations.length - 1)
                    currentGame = 0;
                else
                    currentGame += 1;
            }
        }
    }

    public synchronized void start() {
        if (!running) {
            t = new Thread(this);
            t.setName("GameAnimator Thread");
            running = true;
            t.start();
        }
    }

    public synchronized void stop() {
        if (running) {
            try {
                running = false;
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
