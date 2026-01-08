import inventory.Item;
import player.Player;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Hero");

        Item key = new Item("Rusty Key", "Looks old but useful");
        Item torch = new Item("Torch", "Lights up dark places");

        player.pickItem(key);
        player.pickItem(torch);

        player.showInventory();


    }
}