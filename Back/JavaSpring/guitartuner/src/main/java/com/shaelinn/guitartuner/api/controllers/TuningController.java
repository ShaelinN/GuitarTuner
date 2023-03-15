package com.shaelinn.guitartuner.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shaelinn.guitartuner.api.models.Tuning;
import com.shaelinn.guitartuner.services.TuningService;

@RestController
public class TuningController {
    private TuningService tuningService;

    
    @Autowired
    public TuningController(TuningService tuningService) {
        this.tuningService = tuningService;
    }

    @GetMapping("/tuning")
    public Tuning getTuning(@RequestParam String id) {
        Tuning result = tuningService.getTuning(id);
        return result;
    }

    @PostMapping("/tuning/add")
    public Tuning addTuning(@RequestParam String name, @RequestParam String category, 
    @Nullable @RequestParam String subCategory, @RequestParam String notes) {

        return tuningService.addTuning(name, category, subCategory, notes);
    }

    
}