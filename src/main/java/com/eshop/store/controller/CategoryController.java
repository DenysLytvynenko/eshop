package com.eshop.store.controller;

import com.eshop.store.entities.db.Category;
import com.eshop.store.entities.web.CategoryWebResult;
import com.eshop.store.entities.web.GetCategoriesResponse;
import com.eshop.store.entities.web.WebResult;
import com.eshop.store.repo.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import static com.eshop.store.entities.web.WebResult.EXCEPTION_WEB_CODE;
import static com.eshop.store.entities.web.WebResult.OK_WEB_CODE;

@RestController
@RequestMapping("/eshop/rest/v1/categories")
@Slf4j

public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @PostConstruct
    public void init() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public GetCategoriesResponse getAll() {
        GetCategoriesResponse response = new GetCategoriesResponse();
        try {
            response.setCategories(repository.findAll());
            response.setWebResult(getSuccessWebResult());
        } catch (Exception e) {
            log.error("", e);
            response.setWebResult(getErrorWebResult(e));
        }

        return response;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public CategoryWebResult addCategory(@RequestBody Category req) {
        CategoryWebResult response = new CategoryWebResult();
        try {
            response.setId(repository.save(req).getId());
            response.setWebResult(getSuccessWebResult());
        } catch (Exception e) {
            log.error("", e);
            response.setWebResult(getErrorWebResult(e));
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CategoryWebResult modifyCategory(@RequestBody Category req) {
        return addCategory(req);
    }

    private WebResult getSuccessWebResult() {
        return WebResult.builder().code(OK_WEB_CODE).description("Ok").build();
    }

    private WebResult getErrorWebResult(Exception e) {
        return WebResult.builder().code(EXCEPTION_WEB_CODE).description(e.getMessage()).build();
    }
}
