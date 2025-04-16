package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class VegetarianRepository {
    public List<MenuItemRecord> getTheMenuItems(){
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        Iterator<MenuComponent> iterator = allMenus.createIterator();
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof MenuItem && menuComponent.isVegetarian()) {
                records.add(new MenuItemRecord(menuComponent.getName(),
                        menuComponent.getDescription(),
                        menuComponent.isVegetarian(),
                        menuComponent.getPrice()));
            }
        }
        return records;
    }
}
