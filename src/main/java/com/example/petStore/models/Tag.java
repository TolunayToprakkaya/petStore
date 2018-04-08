package com.example.petStore.models;

import com.example.petStore.models.seedwork.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_TAG")
public class Tag extends AbstractEntity{

    @Column(name = "tagName")
    private String tagName;

    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
