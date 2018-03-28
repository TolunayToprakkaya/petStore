package models;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Table(name = "T_PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "categoryName")
    private Category categoryName;

    @Column(name = "petName")
    private String petName;

    @Column(name = "photoUrl")
    private String photoUrl;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "tagName")
    private Tag tagName;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Tag getTagName() {
        return tagName;
    }
    public void setTagName(Tag tagName) {
        this.tagName = tagName;
    }

}
