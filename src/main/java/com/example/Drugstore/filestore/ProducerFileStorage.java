package com.example.Drugstore.filestore;

import com.example.Drugstore.model.Producer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProducerFileStorage extends AbstractFileStorage<Producer> {
    @Override
    protected String getModelName() {
        return "producer";
    }

    @Override
    protected Producer convert(List<String> values) {
        List<Integer> drugsId = new LinkedList<>();
        if (!Objects.equals(values.get(2), "")) {
            drugsId = Arrays.stream(values.get(2).split(", "))
                    .map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        }
        return new Producer(Integer.parseInt(values.get(0)), String.valueOf(values.get(1)), drugsId);
    }
}
