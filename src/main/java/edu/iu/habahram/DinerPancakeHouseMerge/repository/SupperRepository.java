package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class SupperRepository {
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent supperMenu = new CafeMenu("CAFE MENU", "Dinner");

        Iterator<MenuComponent> iterator = supperMenu.createIterator();
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof MenuItem) {
                records.add(new MenuItemRecord(menuComponent.getName(),
                        menuComponent.getDescription(),
                        menuComponent.isVegetarian(),
                        menuComponent.getPrice()));
            }
        }
        return records;
    }
}
