package com.example.Drugstore.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Producer extends BaseClass {
    private Integer id;
    private String name;
    private List<Integer> drugsId;

    public String getHeaders() {
        return "Id, Name, Drugs id";
    }

    public String toCSV() {
        return this.getId() + ", " + this.getName() + ", " + this.getDrugsId();
    }
}
