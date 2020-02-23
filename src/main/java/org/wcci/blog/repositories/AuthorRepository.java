package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByAuthor(String author);
}
