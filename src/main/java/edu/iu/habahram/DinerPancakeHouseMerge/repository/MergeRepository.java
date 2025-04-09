package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class MergeRepository {
    public List<MenuItem> get(MenuItem[] dinerMenu, List<MenuItem> pancakeHouseMenu){
        ArrayList<MenuItem> fullMenu = new ArrayList<>();

        //add everything to one menu
        for(MenuItem m: dinerMenu){
            fullMenu.add(m);
        }
        fullMenu.addAll(pancakeHouseMenu);

        //sort the list by name
        fullMenu.sort(Comparator.comparing(MenuItem::getName));
        return fullMenu;
    }
}
