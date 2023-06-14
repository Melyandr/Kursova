package com.example.Drugstore.filestore;

import com.example.Drugstore.enums.Category;
import com.example.Drugstore.enums.Packaging;
import com.example.Drugstore.model.Drug;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugFileStorage extends AbstractFileStorage<Drug> {

    @Override
    protected String getModelName() {
        return "drug";
    }

    @Override
    protected Drug convert(List<String> values) {
        return new Drug(Integer.parseInt(values.get(0)), String.valueOf(values.get(1)), Boolean.parseBoolean(values.get(2)), Category.valueOf(values.get(3)), Integer.parseInt(values.get(4)), Double.parseDouble(values.get(5)), Packaging.valueOf(values.get(6)), String.valueOf(values.get(7)));
    }
}
