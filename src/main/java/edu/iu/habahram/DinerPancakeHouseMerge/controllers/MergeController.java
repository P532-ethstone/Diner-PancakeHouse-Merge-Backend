package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {
    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;
    MergeRepository mergeRepository;

    public MergeController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository, MergeRepository mergeRepository){
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.mergeRepository = mergeRepository;
    }

    @GetMapping
    public List<MenuItem> get(){
        return mergeRepository.get((DinerMenuIterator) DinerMenu.createIterator(), (PancakeHouseIterator) PancakeHouseMenu.createIterator());
    }
}
