package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.SupperRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/supper")
public class SupperController {
    SupperRepository supperRepository;

    public SupperController(SupperRepository supperRepository){
        this.supperRepository = supperRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get(){
        return supperRepository.getTheMenuItems();
    }
}
