package com.eshop.store.entities.db;

import lombok.*;
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
@Document(collection = "categories")
public class Category {
    @Id
    private String id;

    private Map<String, String> locale;
    private String parent_id;
    private List<String> path;
}
