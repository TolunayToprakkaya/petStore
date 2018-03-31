package models;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Table(name = "T_PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "petId")
    private Integer petId;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "store")
    private String status;

    @RestResource(exported = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    public Integer getPetId() {
        return petId;
    }
    public void setPetId(Integer petId) {
        this.petId = petId;
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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
