package hello;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by clsanfor on 7/15/17.
 */
public class FeedItem {
    public String getCompanyLogoUri() {
        return companyLogoUri;
    }

    public void setCompanyLogoUri(String companyLogoUri) {
        this.companyLogoUri = companyLogoUri;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImageUri() {
        return itemImageUri;
    }

    public void setItemImageUri(String itemImageUri) {
        this.itemImageUri = itemImageUri;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    private String companyLogoUri;
    private String companyName;
    private String itemName;
    private String itemImageUri;
    private int numLikes;
    private ArrayList<String> tags;

    public FeedItem(String companyLogoUri, String companyName, String itemName, String itemImageUri, int numLikes, ArrayList<String> tags) {
        this.companyLogoUri = companyLogoUri;
        this.companyName = companyName;
        this.itemName = itemName;
        this.itemImageUri = itemImageUri;
        this.numLikes = numLikes;
        this.tags = tags;
    }


}
