package hello;

import java.util.ArrayList;

/**
 * Created by clsanfor on 7/15/17.
 */
public class Category {
    private int id;
    private String name;
    private String description;
    private ArrayList<Item> savedItems;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.savedItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getSavedItems() {
        return savedItems;
    }

    public void addSavedItem(Item newSavedItem) {
        savedItems.add(newSavedItem);
        newSavedItem.addSave();
    }

    public void removeSavedItem(Item delSavedItem) {
        savedItems.remove(delSavedItem);
        delSavedItem.subtractSave();
    }

}
