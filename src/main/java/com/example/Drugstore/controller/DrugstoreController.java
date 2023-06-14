package com.example.Drugstore.controller;

import com.example.Drugstore.model.Drugstore;
import com.example.Drugstore.service.DrugstoreService;
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
@RequestMapping("/drugstore")
public class DrugstoreController {
    @Autowired
    private DrugstoreService drugstoreService;
    @PostMapping
    public Drugstore addDrugstore(@RequestBody Drugstore drugstore) {
        return drugstoreService.addDrugstore(drugstore);
    }
    @GetMapping
    public List<Drugstore> getAllDrugstores() {
        return drugstoreService.findAllDrugstores();
    }

    @GetMapping("/{id}")
    public Drugstore getDrugstoreById(@PathVariable Integer id) {
        return drugstoreService.findDrugstoreById(id);
    }


    @PutMapping("/{id}")
    public Drugstore updateDrugstore(@PathVariable Integer id, @RequestBody Drugstore drugstore) {
        return drugstoreService.updateDrugstore(id, drugstore);
    }

    @DeleteMapping("/{id}")
    public Drugstore deleteDrugstore(@PathVariable Integer id) {
        return drugstoreService.deleteDrugstore(id);
    }
}
