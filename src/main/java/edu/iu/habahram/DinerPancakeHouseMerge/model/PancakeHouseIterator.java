package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseIterator implements Iterator {
    List<MenuItem> items;
    int position = 0;

    public PancakeHouseIterator(List<MenuItem> items){
        this.items = items;
    }

    @Override
    public MenuItem next() {
        MenuItem currItem = items.get(position);
        position += 1;
        return currItem;
    }

    @Override
    public boolean hasNext() {
        if(position >= items.size() || items.get(position) == null){
            return false;
        }
        else{
            return true;
        }
    }
}
