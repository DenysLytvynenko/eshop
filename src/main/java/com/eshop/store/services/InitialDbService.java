package com.eshop.store.services;

import com.eshop.store.entities.db.Category;
import com.eshop.store.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class InitialDbService {

    @Autowired
    private CategoryRepository repository;
    @PostConstruct
    public void init (){

        if (repository.count() == 0) {
        List<Category> categories = new ArrayList<>();
            categories.add(Category.builder().id("root").
                    description(Map.of("EN", "Root","RU","Корень")).parentId(null).path(Collections.emptyList()).build());
            categories.add(Category.builder().id("electronics").
                    description(Map.of("EN", "Electronics","RU","Электроника")).parentId("root").path(Arrays.asList("root")).build());
            categories.add(Category.builder().id("autoMoto").
                    description(Map.of("EN", "Auto & Moto","RU","Авто и Мото")).parentId("root").path(Arrays.asList("root")).build());
            categories.add(Category.builder().id("books").
                    description(Map.of("EN", "Books","RU","Книги")).parentId("root").path(Arrays.asList("root")).build());
            categories.add(Category.builder().id("sport").
                    description(Map.of("EN", "Sport","RU","Спорт")).parentId("root").path(Arrays.asList("root")).build());
            categories.add(Category.builder().id("tvAudio")
                    .description(Map.of("EN", "TV & Audio", "RU","Телевизоры и Аудио")).parentId("electronics").path(Arrays.asList("root","electronics")).build());
            categories.add(Category.builder().id("pc")
                    .description(Map.of("EN", "PC", "RU","Компьютеры")).parentId("electronics").path(Arrays.asList("root","electronics")).build());
            categories.add(Category.builder().id("phones")
                    .description(Map.of("EN", "Phones", "RU","Телефоны")).parentId("electronics").path(Arrays.asList("root","electronics")).build());
            categories.add(Category.builder().id("tv")
                    .description(Map.of("EN", "TV", "RU","Телевизоры")).parentId("tvAudio").path(Arrays.asList("root","electronics", "tvAudio")).build());
            categories.add(Category.builder().id("projectors")
                    .description(Map.of("EN", "Projectors", "RU","Проэкторы")).parentId("tvAudio").path(Arrays.asList("root","electronics", "tvAudio")).build());
            categories.add(Category.builder().id("smartPhones")
                    .description(Map.of("EN", "SmartPhones", "RU","Смарфоны")).parentId("phones").path(Arrays.asList("root","electronics", "phones")).build());
            repository.saveAll(categories);
        }
    }

}
