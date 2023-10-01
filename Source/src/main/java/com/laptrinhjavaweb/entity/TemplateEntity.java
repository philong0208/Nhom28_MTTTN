package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "template")
public class  TemplateEntity extends BaseEntity {

    private static final long serialVersionUID = 3050640464816933435L;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
