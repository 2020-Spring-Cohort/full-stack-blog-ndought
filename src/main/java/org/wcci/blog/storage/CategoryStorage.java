package org.wcci.blog.storage;

import org.wcci.blog.models.Category;

public interface CategoryStorage {


    Object findCategoryByName(String tech);

    Object getAll();

    void store(Category category);
}
