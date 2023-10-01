package com.laptrinhjavaweb.dto;

public class TemplateDTO extends AbstractDTO<TemplateDTO> {

    private static final long serialVersionUID = -4553583583100510783L;

    private String name;
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
