package com.example.Drugstore.filestore;

import com.example.Drugstore.model.BaseClass;
import com.example.Drugstore.utils.TimeUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractFileStorage<T extends BaseClass> {
    public static final String RESOURCES_FILES = "src/main/resources/storage";

    public List<T> read() throws IOException {
        String fileName = RESOURCES_FILES + "/" + getModelName() + "-" + TimeUtil.getDate();
        if (Files.exists(Paths.get(fileName))) {
            return readFrom(new File(fileName));
        }
        return new LinkedList<>();
    }

    protected List<T> readFrom(File file) throws IOException {
        List<T> result = new LinkedList<>();
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        } else {
            return result;
        }
        while (scanner.hasNextLine()) {

            List<String> values = Arrays.stream(scanner.nextLine().split(", ")).toList();
            result.add(convert(values));
        }
        return result;
    }

    public void save(List<T> records) throws IOException {
        String date = TimeUtil.getDate();
        File file = new File(RESOURCES_FILES + "/" + getModelName() + "-" + date + ".csv");
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(records.get(0).getHeaders() + "\n");
            for (T record : records) {
                writer.write(record.toCSV() + "\n");
            }

        }


    }

    protected abstract String getModelName();

    protected abstract T convert(List<String> values);

}
