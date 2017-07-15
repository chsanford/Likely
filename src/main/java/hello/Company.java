package hello;

import java.lang.reflect.Array;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by clsanfor on 7/15/17.
 */
public class Company {
    private int id;
    private String name;
    private String description;
    private ArrayList<Item> items;
    private String logoUri;

    public Company(int id, String name, String description, String logoUri) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = new ArrayList<Item>();
        this.logoUri = logoUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public void removeItem(Item delItem) {
        items.remove(delItem);
    }

    public String getLogoUri() {
        return logoUri;
    }

    public void setLogoUri(String logoUri) {
        this.logoUri = logoUri;
    }

    public ArrayList<Item> getTopItems(int daysBefore, int numItems) {
        return (ArrayList<Item>) getTopItems(daysBefore).subList(0, numItems);
    }

    public ArrayList<Item> getTopItems(int daysBefore) {
        ArrayList<Item> recentItems = getRecentItems(daysBefore);
        recentItems.sort(new ComparatorItemLikes());
        Collections.reverse(recentItems);
        return recentItems;
    }

    private ArrayList<Item> getRecentItems(int daysBefore) {
        ArrayList<Item> recentItems = new ArrayList<>();
        for (Item item: items) {
            if (!LocalDate.now().minusDays(daysBefore).isBefore(item.getCreationDate())) {
                recentItems.add(item);
            }
        }
        return recentItems;
    }
}
