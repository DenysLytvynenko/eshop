package com.eshop.store.entities.web;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryWebResult {
    private WebResult webResult;
    private String id;
}
