package com.laptrinhjavaweb.dto;

public class MenuFilter extends AbstractDTO<MenuDTO> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
