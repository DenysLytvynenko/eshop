package com.eshop.store.entities.db;

import lombok.*;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private Map<String, String> shortDescription;
    private Map<String, String> fullDescription;
    private List<String> imagesList;
    private Map<String, String> characteristics;
    private List<String> tags;
    private Money price;

}
