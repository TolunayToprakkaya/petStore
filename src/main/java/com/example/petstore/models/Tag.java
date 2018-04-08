package com.example.petstore.models;

import com.example.petstore.models.seedwork.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_TAG")
public class Tag extends AbstractEntity {
    @Column(name = "tagName")
    private String tagName;

    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
