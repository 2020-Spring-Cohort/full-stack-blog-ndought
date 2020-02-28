package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Collection;

@Service
public class TagStorageJpaImpl implements TagStorage {

    TagRepository repository;

    public TagStorageJpaImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Tag> getAll() {
        return (Collection<Tag>) repository.findAll();
    }

    @Override
    public void add(Tag tag) {
        repository.save(tag);
    }

    @Override
    public Tag findTagById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Tag findTagByName(String name) {
        return repository.findByName(name).get();
    }
}
