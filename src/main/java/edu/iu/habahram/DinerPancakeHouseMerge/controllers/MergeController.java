package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    MergeRepository mergeRepository;

    public MergeController(MergeRepository mergeRepository) {
        this.mergeRepository = mergeRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        return mergeRepository.getTheMenuItems();
    }
}
