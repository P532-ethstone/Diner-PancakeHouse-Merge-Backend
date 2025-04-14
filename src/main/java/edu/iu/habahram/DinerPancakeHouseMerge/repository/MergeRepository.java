package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergeRepository {
    public List<MenuItem> get(Iterator<MenuItem> dinerMenu, Iterator<MenuItem> pancakeHouseMenu, Iterator<MenuItem> cafeMenu){
        ArrayList<MenuItem> fullMenu = new ArrayList<>();

        while(dinerMenu.hasNext()){
            fullMenu.add(dinerMenu.next());
        }

        while(pancakeHouseMenu.hasNext()){
            fullMenu.add(pancakeHouseMenu.next());
        }

        while(cafeMenu.hasNext()){
            fullMenu.add(cafeMenu.next());
        }

        //sort the list by name
        fullMenu.sort(Comparator.comparing(MenuItem::getName));
        return fullMenu;
    }

    public ArrayList<Menu> getTheMenus() {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new DinerMenu());
        menus.add(new PancakeHouseMenu());
        menus.add(new CafeMenu());
        return menus;
    }
}
