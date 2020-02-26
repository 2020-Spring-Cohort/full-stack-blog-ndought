package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;
import org.wcci.blog.repositories.PostRepository;

@Service
public class PostStorageJpaImpl implements PostStorage {

    PostRepository postRepository;

    public PostStorageJpaImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void store(Post newPost) {
        postRepository.save(newPost);
    }

    @Override
    public Post findPostById(long id) {
        return postRepository.findById(id).get();
    }
}
