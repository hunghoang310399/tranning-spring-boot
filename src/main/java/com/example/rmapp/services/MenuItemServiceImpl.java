package com.example.rmapp.services;

import com.example.rmapp.domain.entity.MenuItemEntity;
import com.example.rmapp.domain.model.MenuItem;
import com.example.rmapp.repository.MenuItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository  menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        MenuItemEntity menuItemEntity = new MenuItemEntity();

        BeanUtils.copyProperties(menuItem,menuItemEntity);

        menuItemRepository.save(menuItemEntity);

        return menuItem;
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
        List<MenuItemEntity> menuItemEntities = menuItemRepository.findAll();

        List<MenuItem> menuItems = menuItemEntities
                .stream()
                .map(item -> new MenuItem(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice(),
                        item.getImageUrl()))
                .collect(Collectors.toList());
        return menuItems;
    }

    @Override
    public boolean deleteMunuItem(Long id) {
        MenuItemEntity menuItem = menuItemRepository.findById(id).get();
        menuItemRepository.delete(menuItem);
        return true;
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        MenuItemEntity menuItemEntity = menuItemRepository.findById(id).get();
        MenuItem   menuItem = new MenuItem();
        BeanUtils.copyProperties(menuItemEntity,menuItem);
        return menuItem;
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        MenuItemEntity menuItemEntity = menuItemRepository.findById(id).get();
        menuItemEntity.setId(menuItemEntity.getId());
        menuItemEntity.setName(menuItem.getName());
        menuItemEntity.setDescription(menuItem.getDescription());
        menuItemEntity.setPrice(menuItem.getPrice());
        menuItemEntity.setImageUrl(menuItemEntity.getImageUrl());

        menuItemRepository.save(menuItemEntity);
        return menuItem;
    }
}
