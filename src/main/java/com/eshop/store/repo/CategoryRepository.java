package com.eshop.store.repo;

import com.eshop.store.entities.db.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
