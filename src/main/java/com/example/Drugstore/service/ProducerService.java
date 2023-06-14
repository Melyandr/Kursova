package com.example.Drugstore.service;

import com.example.Drugstore.filestore.ProducerFileStorage;
import com.example.Drugstore.model.Producer;
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
public class ProducerService {
    private Map<Integer, Producer> producers = new HashMap<>();
    private Integer index = 0;

    @Autowired
    private ProducerFileStorage producerFileStorage;

    public List<Producer> findAllProducers() {
        return new ArrayList<>(producers.values());
    }

    public Producer findProducerById(Integer id) {
        return producers.get(id);
    }


    public Producer addProducer(Producer producer) {
        index += 1;
        producer.setId(index);
        producers.put(index, producer);
        return producer;
    }

    public Producer updateProducer(Integer id, Producer producer) {
        producer.setId(id);
        producers.put(id, producer);
        return producer;
    }

    public Producer deleteProducer(Integer id) {
        return producers.remove(id);
    }

    @PreDestroy
    private void saveData() throws IOException {
        List<Producer> list = producers.values().stream().toList();
        producerFileStorage.save(list);
    }

    @PostConstruct
    private void dataToHashMap() throws IOException {
        if (producerFileStorage.read() != null) {
            List<Producer> list = producerFileStorage.read();
            for (Producer producer : list) {
                index += 1;
                if (producer.getId() > index) {
                    index = producer.getId();
                }
                producers.put(producer.getId(), producer);
            }
        }
    }
}
