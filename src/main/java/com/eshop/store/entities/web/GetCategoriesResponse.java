package com.eshop.store.entities.web;

import com.eshop.store.entities.db.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCategoriesResponse {
    private WebResult webResult;
    private List<Category> categories;
}
