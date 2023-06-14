package com.example.Drugstore.service;

import com.example.Drugstore.filestore.DrugstoreFileStorage;
import com.example.Drugstore.model.Drugstore;
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
public class DrugstoreService {
    private Map<Integer, Drugstore> drugstores = new HashMap<>();
    private Integer index = 0;

    @Autowired
    private DrugstoreFileStorage drugstoreFileStorage;

    public List<Drugstore> findAllDrugstores() {
        return new ArrayList<>(drugstores.values());
    }

    public Drugstore findDrugstoreById(Integer id) {
        return drugstores.get(id);
    }


    public Drugstore addDrugstore(Drugstore drugstore) {
        index += 1;
        drugstore.setId(index);
        drugstores.put(index, drugstore);
        return drugstore;
    }

    public Drugstore updateDrugstore(Integer id, Drugstore drugstore) {
        drugstore.setId(id);
        drugstores.put(id, drugstore);
        return drugstore;
    }

    public Drugstore deleteDrugstore(Integer id) {
        return drugstores.remove(id);
    }

    @PreDestroy
    private void saveData() throws IOException {
        List<Drugstore> list = drugstores.values().stream().toList();
        drugstoreFileStorage.save(list);
    }

    @PostConstruct
    private void dataToHashMap() throws IOException {
        if (drugstoreFileStorage.read() != null) {
            List<Drugstore> list = drugstoreFileStorage.read();
            for (Drugstore drugstore : list) {
                index += 1;
                if (drugstore.getId() > index) {
                    index = drugstore.getId();
                }
                drugstores.put(drugstore.getId(), drugstore);
            }
        }
    }
}
