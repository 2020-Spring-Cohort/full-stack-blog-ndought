package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Author;
import org.wcci.blog.repositories.AuthorRepository;

import java.util.Collection;


//public class AuthorStorageJpaImpl implements AuthorStorage {

//   private final AuthorRepository authorRepository;
//
//    public AuthorStorageJpaImpl(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }
//
//    @Override
//    public void store(Author authorToStore) {
//        authorRepository.save(authorToStore);
//    }
//    @Override
//    public Collection<Author> getAll() {
//        return (Collection<Author>) repository.findAll();
//    }
//
//    @Override
//    public Author findAuthorByName(String name) {
//        return repository.findByName(name).get();
//    }

//    @Override
//    public Author findAuthorById(Long id){
//        return repository.findById(id).get();
//    }

