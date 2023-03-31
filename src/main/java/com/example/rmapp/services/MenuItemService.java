package com.example.rmapp.services;

import com.example.rmapp.domain.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);

    List<MenuItem> getAllMenuItem();

    boolean deleteMunuItem(Long id);

    MenuItem getMenuItemById(Long id);

    MenuItem updateMenuItem(Long id, MenuItem menuItem);
}
