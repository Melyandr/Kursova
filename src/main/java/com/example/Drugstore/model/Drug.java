package com.example.Drugstore.model;

import com.example.Drugstore.enums.Category;
import com.example.Drugstore.enums.Packaging;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Drug extends BaseClass {

    private Integer id;
    private String name;
    private boolean isAvailable;
    private Category category;
    private Integer producerId;
    private double priceInDollars;
    private Packaging packaging;
    private String activeIngredient;

    public String getHeaders() {
        return "Id, Name, Is available, Category, Producer id, Price in dollars, Packaging, Active ingredient";
    }

    public String toCSV() {
        return this.getId() + ", " + this.getName() + ", " + this.isAvailable + ", " + this.getCategory() + ", " + this.getProducerId() + ", " + this.getPriceInDollars() + ", " + this.getPackaging() + ", " + this.getActiveIngredient();
    }
}
