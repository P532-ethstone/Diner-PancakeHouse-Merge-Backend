package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.LunchRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lunch")
public class LunchController {
    LunchRepository lunchRepository;

    public LunchController(LunchRepository lunchRepository){
        this.lunchRepository = lunchRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get(){
        return lunchRepository.getTheMenuItems();
    }
}
