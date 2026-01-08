package player;

import inventory.Inventory;
import inventory.Item;

public class Player {
    private String name;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void pickItem(Item item) {
        inventory.addItem(item);
    }

    public void unlockRoom(String itemName) {
        inventory.removeItem(itemName);
    }

    public void showInventory() {
        inventory.showItems();
    }

    public boolean hasItem(String itemName) {
        return inventory.hasItem(itemName);
    }
}
