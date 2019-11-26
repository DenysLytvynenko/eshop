package com.eshop.store.entities.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "product_images")
public class ProductImage {
    @Id
    private String id;

    private String directory;
    private String fileName;
    private Date uploadDate;
}
