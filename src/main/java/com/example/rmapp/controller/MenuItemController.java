package com.example.rmapp.controller;
import com.example.rmapp.domain.model.MenuItem;
import com.example.rmapp.services.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class MenuItemController {
    private MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    @PostMapping("/menuItem")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem){
            return menuItemService.createMenuItem(menuItem);
    }
    @GetMapping("/menuItem")
    public List<MenuItem> getMenuItem(){
        return menuItemService.getAllMenuItem();
    }
    @DeleteMapping("/menuItem/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteMenuItem(@PathVariable Long Id){
        boolean deleted = menuItemService.deleteMunuItem(Id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/menuItem/{id}")
    public  ResponseEntity<MenuItem>getMenuItemById(@PathVariable Long Id){
        MenuItem menuItem = null;
        menuItem = menuItemService.getMenuItemById(Id);
        return ResponseEntity.ok(menuItem);
    }
    @PutMapping("/menuItem/{id}")
    public  ResponseEntity<MenuItem>updateMenuItem(@PathVariable Long id ,
                                                   @RequestBody MenuItem menuItem){
       menuItem = menuItemService.updateMenuItem(id ,menuItem);
       return  ResponseEntity.ok(menuItem);

    }
}
