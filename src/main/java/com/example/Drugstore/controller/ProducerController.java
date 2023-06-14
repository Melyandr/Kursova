package com.example.Drugstore.controller;

import com.example.Drugstore.model.Producer;
import com.example.Drugstore.service.ProducerService;
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
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;


    @PostMapping
    public Producer addProducer(@RequestBody Producer producer) {
        return producerService.addProducer(producer);
    }
    @GetMapping
    public List<Producer> getAllProducers() {
        return producerService.findAllProducers();
    }
    @GetMapping("/{id}")
    public Producer getProducerById(@PathVariable Integer id) {
        return producerService.findProducerById(id);
    }
    @PutMapping("/{id}")
    public Producer updateProducer(@PathVariable Integer id, @RequestBody Producer producer) {
        return producerService.updateProducer(id, producer);
    }

    @DeleteMapping("/{id}")
    public Producer deleteProducer(@PathVariable Integer id) {
        return producerService.deleteProducer(id);
    }
}
