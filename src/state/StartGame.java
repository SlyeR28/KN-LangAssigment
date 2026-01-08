package state;

import Game.GameManager;
import inventory.Item;

public class StartGame implements GameState {
    @Override
    public void handleState(GameManager gameManager) {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You wake up in a mysterious place...");

        // Initialize items as per original Main.java
        Item key = new Item("Rusty Key", "Looks old but useful");
        Item torch = new Item("Torch", "Lights up dark places");

        gameManager.getPlayer().pickItem(key);
        gameManager.getPlayer().pickItem(torch);

        System.out.println("You have picked up a Rusty Key and a Torch.");

        // Transition to ExploringState
        gameManager.changeState(new ExploringState());
    }
}
