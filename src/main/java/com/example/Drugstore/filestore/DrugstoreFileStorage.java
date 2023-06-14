package com.example.Drugstore.filestore;

import com.example.Drugstore.model.Drugstore;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DrugstoreFileStorage extends AbstractFileStorage<Drugstore> {
    @Override
    protected String getModelName() {
        return "drugstore";
    }

    @Override
    protected Drugstore convert(List<String> values) {
        List <Integer> drugsId = new LinkedList<>();
        if (!Objects.equals(values.get(3), "")) {
            drugsId = Arrays.stream(values.get(3).split(", "))
                    .map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        }
        return new Drugstore(Integer.parseInt(values.get(0)), String.valueOf(values.get(1)), String.valueOf(values.get(2)), drugsId);
    }
}
