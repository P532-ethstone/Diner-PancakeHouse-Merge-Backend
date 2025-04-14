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
        Iterator<MenuItem> dinerMenuIterator = dinerRepository.getIterator();
        Iterator<MenuItem> pancakeHouseIterator = pancakeHouseRepository.getIterator();
        Iterator<MenuItem> cafeIterator = cafeRepository.getIterator();
        return mergeRepository.get(dinerMenuIterator, pancakeHouseIterator, cafeIterator);
    }
}
