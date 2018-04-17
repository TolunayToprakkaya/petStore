package com.example.petStore.models;

import com.example.petStore.models.seedwork.AbstractEntity;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Table(name = "T_PET")
public class Pet extends AbstractEntity{

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "categoryName")
    private Category category;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "name")
    private String name;

    @Column(name = "photoUrl")
    private String photoUrl;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "tagName")
    private Tag tag;

   private enum status{
       available,
       pending,
       sold
   }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
