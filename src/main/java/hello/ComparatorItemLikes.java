package hello;

import java.util.Comparator;

/**
 * Created by clsanfor on 7/15/17.
 */
public class ComparatorItemLikes implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getNumLikes() - item2.getNumLikes();
    }
}
