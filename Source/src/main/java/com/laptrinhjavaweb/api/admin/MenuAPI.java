package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.MenuDTO;
import com.laptrinhjavaweb.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/menu")
public class MenuAPI {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuDTO>> get() {
        return ResponseEntity.ok(menuService.getMenus());
    }

    @PostMapping
    public ResponseEntity<MenuDTO> create(@RequestBody MenuDTO req) {
        return ResponseEntity.ok(menuService.insert(req));
    }

    @PutMapping
    public ResponseEntity<MenuDTO> update(@RequestBody MenuDTO req) {
        return ResponseEntity.ok(menuService.update(req));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody long[] ids) {
        if (ids.length > 0) {
            menuService.delete(ids);
        }
        return ResponseEntity.ok("success");
    }
}
