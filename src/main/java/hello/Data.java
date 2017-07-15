package hello;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by clsanfor on 7/15/17.
 */
public class Data {
    ArrayList<User> users;
    ArrayList<Company> companies;
    ArrayList<String> tags;
    
    public Data() throws URISyntaxException {
        users = new ArrayList<>();
        companies = new ArrayList<>();
        tags = new ArrayList<>();
        
        tags.add("shirt");
        tags.add("scarf");
        tags.add("hit");
        tags.add("fashion");
        tags.add("tech");
        tags.add("aesthetic");
        
        User stephanie = new User(1, "Stephanie", LocalDate.of(1997, 12, 10), "Female");
        User jagan = new User(2, "Jagan", LocalDate.of(1995, 3, 16), "Male");
        User kayla = new User(3, "Kayla", LocalDate.of(1996, 7, 31), "Female");
        addUser(stephanie);
        addUser(jagan);
        addUser(kayla);
        
        Company li = new Company(1, "LinkedIn", "We're a clothes company now.",
                "https://lh3.googleusercontent.com/00APBMVQh3yraN704gKCeM63KzeQ-zHUi5wK6E9TjRQ26McyqYBt-zy__4i8GXDAfeys=w300");
        Company google = new Company(1, "Google", "Samesies.",
                "https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h1264");
        addCompany(li);
        addCompany(google);
        
        Item shirt500 = new Item(
                                 1,
                                 "500M shirt",
                                 "500 members!",
                                 new ArrayList<String>(Arrays.asList("shirt", "aesthetic", "tech")),
                                 LocalDate.of(2017, 5, 9),
                                 li.getId(),
                                 null);
        Item hipsterScarf = new Item(
                                     2,
                                     "Hipster scarf",
                                     "Look how cool we are.",
                                     new ArrayList<String>(Arrays.asList("scarf", "aesthetic", "fashion")),
                                     LocalDate.of(2017, 6, 19),
                                     li.getId(),
                                     null);
        Item spinnyHat = new Item(
                                  3,
                                  "Spinny Hat!",
                                  "Did I ever tell you I work at Google?",
                                  new ArrayList<String>(Arrays.asList("hat", "aesthetic", "tech")),
                                  LocalDate.of(2017, 2, 20),
                                  google.getId(),
                                  null);
        li.addItem(shirt500);
        li.addItem(hipsterScarf);
        google.addItem(spinnyHat);
        
        Category aesthetix = new Category(1, "Aesthetix", "lmao");
        stephanie.addCategory(aesthetix);
        stephanie.addToCategory(shirt500, aesthetix);
        stephanie.addToCategory(hipsterScarf, aesthetix);
        stephanie.addLikedItem(hipsterScarf);
        kayla.addLikedItem(hipsterScarf);
        jagan.addLikedItem(hipsterScarf);
        stephanie.addLikedItem(shirt500);
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
    
    public void addUser(User newUser) {
        users.add(newUser);
    }
    
    public ArrayList<Company> getCompanies() {
        return companies;
    }
    
    public Company getCompanyById(int companyId) {
        for (Company company: companies) {
            if (company.getId() == companyId) {
                return company;
            }
        }
        return null;
    }
    
    public void addCompany(Company newCompany) {
        companies.add(newCompany);
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }
    
    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (Company company: companies) {
            items.addAll(company.getItems());
        }
        return items;
    }
    
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        for (User user: users) {
            categories.addAll(user.getCategories());
        }
        return categories;
    }
    
    public ArrayList<String> autocompleteTag(String tagSubstr) {
        ArrayList<String> possibleTags = new ArrayList<>();
        for (String tag: tags) {
            if (possibleTags.contains(tagSubstr)) {
                possibleTags.add(tag);
            }
        }
        return possibleTags;
    }
    
    public ArrayList<Item> tagSearch(String tag) {
        tag = tag.toLowerCase();
        ArrayList<Item> results = new ArrayList<>();
        for (Item item: getItems()) {
            if (item.getTags().contains(tag)) {
                results.add(item);
            }
        }
        return results;
    }
    
    public ArrayList<Item> textSearch(String str) {
        str = str.toLowerCase();
        ArrayList<Item> results = new ArrayList<>();
        for (Item item: getItems()) {
            if (item.getTags().contains(str) ||
                getCompanyById(item.getCompanyId()).getName().toLowerCase().contains(str) ||
                item.getName().toLowerCase().contains(str)) {
                results.add(item);
            }
        }
        return results;
    }
    
    public int mostLikesInTag(String tag) {
        ArrayList<Item> relevantItems = tagSearch(tag);
        int maxLikes = 0;
        for (Item item: relevantItems) {
            maxLikes = Math.max(maxLikes, item.getNumLikes());
        }
        return maxLikes;
    }
    
    public double averageLikesInTag(String tag) {
        ArrayList<Item> relevantItems = tagSearch(tag);
        double totalLikes = 0;
        for (Item item: relevantItems) {
            totalLikes += item.getNumLikes();
        }
        return totalLikes / relevantItems.size();
    }
    
    public double rankLikesInTag(String tag, Item item) {
        ArrayList<Item> relevantItems = tagSearch(tag);
        relevantItems.sort(new ComparatorItemLikes());
        Collections.reverse(relevantItems);
        for (int i = 0; i < relevantItems.size(); i++) {
            if (item.getNumLikes() >= relevantItems.get(i).getNumLikes()) {
                return i + 1;
            }
        }
        return relevantItems.size();
    }
    
    public int mostSavesInTag(String tag) {
        ArrayList<Item> relevantItems = tagSearch(tag);
        int maxSaves = 0;
        for (Item item: relevantItems) {
            maxSaves = Math.max(maxSaves, item.getNumSaves());
        }
        return maxSaves;
    }
    
    public double averageSavesInTag(String tag) {
        ArrayList<Item> relevantItems = tagSearch(tag);
        double totalSaves = 0;
        for (Item item: relevantItems) {
            totalSaves += item.getNumSaves();
        }
        return totalSaves / relevantItems.size();
    }
    
    public double rankSavesInTag(String tag, Item item) {
        ArrayList<Item> relevantItems = tagSearch(tag);
        relevantItems.sort(new ComparatorItemSaves());
        Collections.reverse(relevantItems);
        for (int i = 0; i < relevantItems.size(); i++) {
            if (item.getNumSaves() >= relevantItems.get(i).getNumSaves()) {
                return i + 1;
            }
        }
        return relevantItems.size();
    }
    
    public double getTagSize(String tag) {
        return tagSearch(tag).size();
    }
}
