package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenuIterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseIterator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class MergeRepository {
    public List<MenuItem> get(DinerMenuIterator dinerMenu, PancakeHouseIterator pancakeHouseMenu){
        ArrayList<MenuItem> fullMenu = new ArrayList<>();

        while(dinerMenu.hasNext()){
            fullMenu.add(dinerMenu.next());
        }

        while(pancakeHouseMenu.hasNext()){
            fullMenu.add(pancakeHouseMenu.next());
        }

        //sort the list by name
        fullMenu.sort(Comparator.comparing(MenuItem::getName));
        return fullMenu;
    }
}
