package hello;

import java.util.Comparator;

/**
 * Created by clsanfor on 7/15/17.
 */
public class ComparatorItemSaves implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getNumSaves() - item2.getNumSaves();
    }
}
