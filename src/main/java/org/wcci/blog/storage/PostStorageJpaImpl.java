package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.PostRepository;

import java.util.Collection;

@Service
public class PostStorageJpaImpl implements PostStorage {

    PostRepository repository;

    public PostStorageJpaImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Post> getAll() {
        return (Collection<Post>) repository.findAll();
    }

    @Override
    public void store(Post newPost) {
        repository.save(newPost);
    }

    @Override
    public Post findPostById(Long id) {
        return repository.findById(id).get();
    }


}
