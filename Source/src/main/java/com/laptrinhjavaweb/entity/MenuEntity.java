package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class MenuEntity extends BaseEntity {

    private static final long serialVersionUID = 3050640464816933435L;

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private int position;

    @Column
    private Long index;

    @Column
    private boolean newTab;
    @Column
    private int status;

    @Column(name = "parent_id" )
    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public boolean isNewTab() {
        return newTab;
    }

    public void setNewTab(boolean newTab) {
        this.newTab = newTab;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
