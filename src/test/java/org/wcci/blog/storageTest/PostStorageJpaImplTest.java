package org.wcci.blog.storageTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.PostStorageJpaImpl;
import org.wcci.blog.storage.repositories.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostStorageJpaImplTest {

    private PostRepository postRepository;
    private PostStorage storage;
    private Post post;

    @BeforeEach
    void setUp() {
        postRepository = mock(PostRepository.class);
        storage = new PostStorageJpaImpl(postRepository);
        Category category = new Category("tech");
        post = new Post(category, "test", "test", "test");
    }
    @Test
    public void shouldFindPostById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        Post retrievedPost = storage.findPostById(1L);
        assertThat(retrievedPost).isEqualTo(post);
    }
}
