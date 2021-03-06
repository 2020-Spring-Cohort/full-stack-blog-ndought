package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.repositories.CategoryRepository;

import javax.servlet.http.PushBuilder;
import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage {

    CategoryRepository repository;

    public CategoryStorageJpaImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Category> getAll() {
        return (Collection<Category>) repository.findAll();
    }
    @Override
    public void store(Category category) {
        repository.save(category);
    }

    @Override
    public Category findCategoryByName(String name) {
        return repository.findByName(name).get();
    }
}
