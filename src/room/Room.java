package room;

import puzzles.Puzzles;
import inventory.Item;
import player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String roomName;
    private String roomDescription;
    private List<Item> items = new ArrayList<>();
    private Map<String, Room> exits = new HashMap<>();
    private Puzzles puzzle;
    private boolean locked = true;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public void setPuzzle(Puzzles puzzle) {
        this.puzzle = puzzle;
    }

    public boolean isLocked() {
        return locked;
    }

    public void enterRoom(Player player) {
        System.out.println("Entering room " + roomName);
        System.out.println(roomDescription);

        if (locked) {
            System.out.println("the door is locked ..Solve the puzzle ");
            tryUnlock(player);
        }
    }

    private void tryUnlock(Player player) {
        if (puzzle == null) {
            locked = false;
            return;
        }
        if (puzzle.solve(player)) {
            locked = false;
            System.out.println("the door is unlocked ..");
        } else {
            System.out.println("the door is  locked ..");
        }
    }

    public void showDetails() {
        System.out.println(roomDescription);

        if (items.isEmpty()) {
            System.out.println("There is no items in this room");
        } else {
            System.out.println("There are " + items.size() + " items in this room");
            items.forEach(System.out::println);
        }

        System.out.println("Exits" + exits.keySet());
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item RemoveItem(String itemName) {
        for (Item i : items) {
            if (i.getItemName().equalsIgnoreCase(itemName)) {
                items.remove(i);
                return i;
            }
        }
        return null;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getNextRoom(String direction) {
        return exits.get(direction);
    }
}
