package inventory;

public class Item {
    private String itemName;
    private String description;

    public Item(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{name='" + itemName + "', description='" + description + "'}";
    }
}
