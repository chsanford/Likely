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
    
    public Data() {
        users = new ArrayList<>();
        companies = new ArrayList<>();
        tags = new ArrayList<>();
        
        tags.add("shirt");
        tags.add("scarf");
        tags.add("hit");
        tags.add("fashion");
        tags.add("tech");
        tags.add("aesthetic");
        tags.add("buttons");
        tags.add("men");
        tags.add("women");
        tags.add("casual");
        tags.add("pants");

        User stephanie = new User(1, "Stephanie", LocalDate.of(1997, 12, 10), "Female");
        User jagan = new User(2, "Jagan", LocalDate.of(1995, 3, 16), "Male");
        User kayla = new User(3, "Kayla", LocalDate.of(1996, 7, 31), "Female");
        addUser(stephanie);
        addUser(jagan);
        addUser(kayla);
        
        Company  zara = new Company(1, "Zara", "Zara",
                "https://static.zara.net/stdstatic/1.42.2-b.6/images/logo-zara-16.svg");
        Company pacsun = new Company(2, "PacSun", "Samesies.",
                "https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h1264");
        Company banana = new Company(3, "Banana Republic", "Banana Republic.",
                "https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h1264");
        addCompany(zara);
        addCompany(pacsun);
        
        Item zaraDressOne = new Item(
                                 1,
                                 "Midi Dress with Buttons",
                                 "Midi Dress with Buttons",
                                 new ArrayList<String>(Arrays.asList("dress", "buttons", "midi", "casual", "women")),
                                 LocalDate.of(2017, 5, 9),
                                 zara.getId(),
                                "https://static.zara.net/photos///2017/I/0/1/p/7952/675/104/2/w/1024/7952675104_2_3_1.jpg?ts=1499674298795");
        Item pacsunPants = new Item(
                                     2,
                                     "Skinny Stretch Chino Pants",
                                     "Skinny Stretch Chino Pants",
                                     new ArrayList<String>(Arrays.asList("skinny", "chino", "pants", "casual", "men")),
                                     LocalDate.of(2017, 6, 19),
                                     pacsun.getId(),
                                    "http://demandware.edgesuite.net/sits_pod15/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dw12fb8acb/product_images/0133436750005NEW_02_025.jpg?sw=340&sh=528&sm=fit");
        Item bananaBlazer = new Item(
                                  3,
                                  "Milano Stitch Short Blazer",
                                  "Milano Stitch Short Blazer?",
                                  new ArrayList<String>(Arrays.asList("blazer", "aesthetic", "formal", "short blazer", "milano")),
                                  LocalDate.of(2017, 2, 20),
                                  zara.getId(),
                                  "http://bananarepublic.gap.com/webcontent/0013/472/720/cn13472720.jpg");
        zara.addItem(zaraDressOne);
        pacsun.addItem(pacsunPants);
        banana.addItem(bananaBlazer);
        
        Category aesthetix = new Category(1, "Aesthetix", "lmao");
        stephanie.addCategory(aesthetix);
        stephanie.addToCategory(zaraDressOne, aesthetix);
        stephanie.addToCategory(pacsunPants, aesthetix);
        stephanie.addLikedItem(pacsunPants);
        kayla.addLikedItem(pacsunPants);
        jagan.addLikedItem(pacsunPants);
        stephanie.addLikedItem(zaraDressOne);
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
