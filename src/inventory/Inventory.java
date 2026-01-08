package inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private  List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getItemName() + "added to inventory");
    }

    public void removeItem(String item) {
      items.removeIf(i -> i.getItemName().equalsIgnoreCase(item));
        System.out.println(item + " removed from inventory");
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(i -> i.getItemName().equalsIgnoreCase(itemName));
    }

    public void showItems() {
        if(items.isEmpty()) {
            System.out.println("No items in your inventory");
            return;
        }
        items.forEach(System.out::println);
    }

}
