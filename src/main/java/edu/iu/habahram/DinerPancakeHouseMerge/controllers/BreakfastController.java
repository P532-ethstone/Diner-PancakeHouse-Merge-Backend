package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.BreakfastRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/breakfast")
public class BreakfastController {
    BreakfastRepository breakfastRepository;

    public BreakfastController(BreakfastRepository breakfastRepository){
        this.breakfastRepository = breakfastRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get(){
        return breakfastRepository.getTheMenuItems();
    }
}
