package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.MenuBuilder;
import com.laptrinhjavaweb.converter.MenuConverter;
import com.laptrinhjavaweb.dto.MenuDTO;
import com.laptrinhjavaweb.entity.MenuEntity;
import com.laptrinhjavaweb.repository.MenuRepository;
import com.laptrinhjavaweb.service.IMasterDataService;
import com.laptrinhjavaweb.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuConverter menuConverter;

    @Autowired
    private IMasterDataService masterDataService;

    private static int MaxIndexOfPosition = 2;

    @Override
    public Page<MenuDTO> search(MenuBuilder searchFilter, Pageable pageable) {
        Page<MenuEntity> results = menuRepository.findAllMenus(pageable);
        List<MenuDTO> dtos = treeMenuDto(results.getContent());
        dtos = menuConverter.flatten(dtos);
        return new PageImpl<>(dtos, results.getPageable(), results.getTotalPages());
    }

    @Override
    public Map<Long, String> getParentMenu() {
        List<MenuEntity> results = menuRepository.findAllMenus();
        List<MenuDTO> dtos = treeMenuDto(results);
        dtos = menuConverter.flatten(dtos);
        Map<Long, String> map = new LinkedHashMap<>();
        for (MenuDTO item : dtos) {
            String name = item.getName();
            if (item.getParentId() != null) {
                name = "|___" + name;
            }
            if (item.getPosition() <= MaxIndexOfPosition) {
                String position = masterDataService.getMenuType().get(item.getPosition().intValue());
                if (position !=null){
                    name = name + " (" + position + ") ";
                }
            }
            map.put(item.getId(), name);
        }
        return map;
    }

    public List<MenuDTO> getChild(Long parentId, List<MenuDTO> list) {
        List<MenuDTO> children = new ArrayList<>();
        for (MenuDTO dto : list) {
            if (parentId.equals(dto.getParentId())) {
                List<MenuDTO> childSub = getChild(dto.getId(), list);
                dto.setChildren(childSub);
                children.add(dto);
            }
        }
        return children;
    }

    public List<MenuDTO> getMenus() {
        List<MenuEntity> results = menuRepository.findAllMenus();
        return treeMenuDto(results);
    }

    public List<MenuDTO> treeMenuDto( List<MenuEntity> results) {
        List<MenuDTO> list = new ArrayList<>();
        for (MenuEntity item : results) {
            list.add(menuConverter.convertToDto(item));
        }
        List<MenuDTO> rootMenus = new ArrayList<>();
//        List<MenuDTO> itemsToRemove = new ArrayList<>();

        for (MenuDTO dto : list) {
            if (dto.getParentId() == null) {
                List<MenuDTO> child = getChild(dto.getId(), list);
                Collections.sort(child, Comparator.comparing(MenuDTO::getPosition));
                dto.setChildren(child);
                rootMenus.add(dto);
            }
       /*     else {
                itemsToRemove.add(dto); //TODO remove
            }*/
        }
        Collections.sort(list, Comparator.comparing(MenuDTO::getPosition));

//        list.removeAll(itemsToRemove); //TODO remove
        return rootMenus;
    }

    @Override
    @Transactional
    public MenuDTO insert(MenuDTO dto) {
        try {
            MenuEntity entity = menuConverter.convertToEntity(dto);
            entity = menuRepository.save(entity);
            return menuConverter.convertToDto(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public MenuDTO update(MenuDTO dto) {
        try {
            MenuEntity update = menuConverter.convertToEntity(dto);
            menuRepository.save(update);
            return menuConverter.convertToDto(update);
        } catch (Exception e) {
            return dto;
        }
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long item : ids) {
            menuRepository.deleteById(item);
        }
    }

    @Override
    public MenuDTO findById(long id) {
        MenuEntity entity = menuRepository.findById(id).get();
        return menuConverter.convertToDto(entity);
    }
}
