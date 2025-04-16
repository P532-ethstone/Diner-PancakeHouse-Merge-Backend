package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.VegetarianRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vegetarian")
public class VegetarianController {
    VegetarianRepository vegetarianRepository;

    public VegetarianController(VegetarianRepository vegetarianRepository){
        this.vegetarianRepository = vegetarianRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get(){
        return vegetarianRepository.getTheMenuItems();
    }
}
