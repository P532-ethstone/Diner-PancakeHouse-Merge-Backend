package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {
    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;
    MergeRepository mergeRepository;
    CafeRepository cafeRepository;

    public MergeController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository, MergeRepository mergeRepository, CafeRepository cafeRepository){
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.mergeRepository = mergeRepository;
        this.cafeRepository = cafeRepository;
    }

    @GetMapping
    public List<MenuItem> get(){
        Iterator<Menu> menus = mergeRepository.getTheMenus().iterator();
        ArrayList<MenuItem> items = new ArrayList<>();
        while(menus.hasNext()){
            Menu menu = menus.next();
            Iterator menuIterator = menu.createIterator();
            while(menuIterator.hasNext()){
                MenuItem item = (MenuItem) menuIterator.next();
                items.add(item);
            }
        }
        return items;
    }
}
