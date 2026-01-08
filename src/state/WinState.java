package state;

import Game.GameManager;

public class WinState implements GameState {
    @Override
    public void handleState(GameManager gameManager) {
        System.out.println("\nCongratulations! You have completed the game.");
        System.out.println("You are a true hero!");
        gameManager.changeState(new ExitState());
    }
}
