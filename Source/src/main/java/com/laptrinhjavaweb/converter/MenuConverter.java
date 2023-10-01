package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.MenuDTO;
import com.laptrinhjavaweb.entity.MenuEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MenuConverter {

    @Autowired
    private ModelMapper modelMapper;

    public MenuDTO convertToDto (MenuEntity entity){
        MenuDTO result = modelMapper.map(entity, MenuDTO.class);
        return result;
    }

    public MenuEntity convertToEntity (MenuDTO dto) {
        MenuEntity result = modelMapper.map(dto, MenuEntity.class);
        return result;
    }

    public List<MenuDTO> flatten(List<MenuDTO> menuList) {
        List<MenuDTO> flattenedList = new ArrayList<>();
        for (MenuDTO menu : menuList) {
            flattenedList.add(menu);
            if (menu.getChildren() != null && menu.getChildren().size() >0 ) {
                flattenedList.addAll(menu.getChildren());
            }
        }
        return flattenedList;
    }
}
