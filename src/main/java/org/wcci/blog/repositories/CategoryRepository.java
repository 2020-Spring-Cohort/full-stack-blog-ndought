package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByCategory(String category);

    Optional<Post> findById(Post id);
}
