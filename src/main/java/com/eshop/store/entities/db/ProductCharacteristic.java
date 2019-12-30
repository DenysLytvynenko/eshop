package com.eshop.store.entities.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "product_characteristics")
public class ProductCharacteristic {
    @Id
    private String id;

    private Map<String, String> description;
    private String categoryId;
}
