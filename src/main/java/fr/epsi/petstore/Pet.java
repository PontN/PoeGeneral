package fr.epsi.petstore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yannis on 13/07/16.
 */
public class Pet implements Serializable {

    private Long id;
    private String name;
    private Category category;
    private List<String> photoUrls = new ArrayList<String>();
    private List<Tag> tags = new ArrayList<Tag>();
    private PetStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }
}
