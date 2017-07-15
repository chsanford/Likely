package hello;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;

/**
 * Created by clsanfor on 7/15/17.
 */
public class User {
    private int id;
    private String name;
    private LocalDate birthday;
    private String gender;
    private ArrayList<Item> likedItems;
    private ArrayList<Category> categories;

    public User(
            int id,
            String name,
            LocalDate birthday,
            String gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.likedItems = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Item> getLikedItems() {
        return likedItems;
    }

    public int getNumLikes() {
        return getLikedItems().size();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public int getNumCategories() {
        return getCategories().size();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addLikedItem(Item newLikedItem) {
        likedItems.add(newLikedItem);
        newLikedItem.addLike();
    }

    public void removeLikedItem(Item delLikedItem) {
        likedItems.remove(delLikedItem);
        delLikedItem.subtractLike();
    }

    public void addCategory(Category newCategory) {
        categories.add(newCategory);
    }

    public void removeCategory(Category delCategory) {
        categories.remove(delCategory);
    }

    public void addToCategory(Item newSavedItem, Category category) {
        category.addSavedItem(newSavedItem);
    }

    public void removeFromCategory(Item delSavedItem, Category category) {
        category.removeSavedItem(delSavedItem);
    }
}
