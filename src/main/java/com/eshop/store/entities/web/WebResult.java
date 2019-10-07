package com.eshop.store.entities.web;

import lombok.*;

/**
 * Possible values of code:
 * 0 - success
 * 1 - error
 * 2 - other error
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebResult {

    public static final int OK_WEB_CODE = 0;
    public static final int EXCEPTION_WEB_CODE = 1;

    private Integer code;
    private String description;
    }
