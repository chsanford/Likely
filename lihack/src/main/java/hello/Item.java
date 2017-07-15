package hello;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by clsanfor on 7/15/17.
 */
public class Item {
    private int id;
    private String name;
    private String description;
    private ArrayList<String> tags;
    private LocalDate creationDate;
    private int numLikes;
    private int numSaves;
    private int companyId;
    private URI imageUri;

    public Item(
            int id,
            String name,
            String description,
            ArrayList<String> tags,
            LocalDate creationDate,
            int companyId,
            URI imageUri) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.creationDate = creationDate;
        this.numLikes = 0;
        this.companyId = companyId;
        this.imageUri = imageUri;
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

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        for (String tag: tags) {
            tag = tag.toLowerCase();
        }
        this.tags = tags;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate newCreationDate) {
        creationDate = newCreationDate;
    }

    public int getNumLikes() {
        return  numLikes;
    }

    public void addLike() {
        numLikes++;
    }

    public void subtractLike() {
        numLikes--;
    }

    public int getNumSaves() {
        return  numSaves;
    }

    public void addSave() {
        numSaves++;
    }

    public void subtractSave() {
        numSaves--;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompany(int newCompanyId) {
        companyId = newCompanyId;
    }

    public URI getImageUri() {
        return imageUri;
    }

    public void setImageUri(URI newImageUri) {
        imageUri = newImageUri;
    }

}
