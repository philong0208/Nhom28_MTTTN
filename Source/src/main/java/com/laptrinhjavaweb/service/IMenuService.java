package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.builder.MenuBuilder;
import com.laptrinhjavaweb.dto.MenuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    Page<MenuDTO> search(MenuBuilder MenuBuilder, Pageable pageable);

    Map<Long,String> getParentMenu();

    List<MenuDTO> getMenus();

    MenuDTO insert(MenuDTO MenuDTO);

    MenuDTO findById(long id);

    MenuDTO update(MenuDTO MenuDTO);

    void delete(long[] ids);
}
