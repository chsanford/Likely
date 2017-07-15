package hello;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by clsanfor on 7/15/17.
 */
public class FeedItem {
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
