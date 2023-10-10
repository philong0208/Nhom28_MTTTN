package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;
public class CategoryDTO extends AbstractDTO<CategoryDTO> {

    private static final long serialVersionUID = -4553583583100510783L;

    private String name;
    private String code;
    private String title;
    private String content;
    private String description;
    private List<String> nameOfPosts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getNameOfPosts() {
        return nameOfPosts;
    }
    public void setNameOfPosts(List<String> nameOfPosts) {
        this.nameOfPosts = nameOfPosts;
    }
    public int getTotalPosts() {
        return nameOfPosts.size();
    }
    public String getNameOfPostsStr() {
        return String.join(", ", nameOfPosts);
    }
}
