package state;

import Game.GameManager;

public class ExitState implements GameState {
    @Override
    public void handleState(GameManager gameManager) {
        System.out.println("Exiting the game. Goodbye!");
        gameManager.setRunning(false);
    }
}
