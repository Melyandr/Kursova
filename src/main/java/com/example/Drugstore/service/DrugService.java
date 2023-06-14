package com.example.Drugstore.service;

import com.example.Drugstore.filestore.DrugFileStorage;
import com.example.Drugstore.model.Drug;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrugService {
    private Map<Integer, Drug> drugs = new HashMap<>();
    private Integer index = 0;

    @Autowired
    private DrugFileStorage drugFileStorage;

    public List<Drug> findAllDrugs() {
        return new ArrayList<>(drugs.values());
    }

    public Drug findDrugById(Integer id) {
        return drugs.get(id);
    }
    public Drug addDrug(Drug drug) {
        index += 1;
        drug.setId(index);
        drugs.put(index, drug);
        return drug;
    }

    public Drug updateDrug(Integer id, Drug drug) {
        drug.setId(id);
        drugs.put(id, drug);
        return drug;
    }
    public Drug deleteDrug(Integer id) {
        return drugs.remove(id);
    }

    @PreDestroy
    private void saveData() throws IOException {
        List<Drug> list = drugs.values().stream().toList();
        drugFileStorage.save(list);
    }

    @PostConstruct
    private void dataToHashMap() throws IOException {
        if (drugFileStorage.read() != null) {
            List <Drug> list = drugFileStorage.read();
            for (Drug drug : list) {
                index += 1;
                if (drug.getId() > index) {
                    index = drug.getId();
                }
                drugs.put(drug.getId(), drug);
            }
        }
    }
}
