package Game;

import player.Player;
import state.GameState;
import state.StartGame;

import java.util.Scanner;

public class GameManager {
    private GameState currentState;
    private Player player;
    private boolean isRunning;
    private Scanner scanner;

    public GameManager() {
        this.player = new Player("Hero"); // Default name, can be changed in StartState
        this.currentState = new StartGame();
        this.isRunning = true;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (isRunning) {
            currentState.handleState(this);
        }
    }

    public void changeState(GameState newState) {
        this.currentState = newState;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
    
    public Scanner getScanner() {
        return scanner;
    }
}
