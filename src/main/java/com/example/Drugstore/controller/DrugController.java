package com.example.Drugstore.controller;

import com.example.Drugstore.model.Drug;
import com.example.Drugstore.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugService drugService;
    @PostMapping
    public Drug addDrug(@RequestBody Drug drug) {
        return drugService.addDrug(drug);
    }

    @GetMapping
    public List<Drug> getAllDrugs() {
        return drugService.findAllDrugs();
    }

    @GetMapping("/{id}")
    public Drug getDrugById(@PathVariable Integer id) {
        return drugService.findDrugById(id);
    }


    @PutMapping("/{id}")
    public Drug updateDrug(@PathVariable Integer id, @RequestBody Drug drug) {
        return drugService.updateDrug(id, drug);
    }

    @DeleteMapping("/{id}")
    public Drug deleteDrug(@PathVariable Integer id) {
        return drugService.deleteDrug(id);
    }

}
