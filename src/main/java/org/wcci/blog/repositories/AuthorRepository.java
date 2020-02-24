package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Author;

import java.util.Optional;


public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByName(String name);

    Author findByAuthor(String author);
}
