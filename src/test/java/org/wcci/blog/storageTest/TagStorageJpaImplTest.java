package org.wcci.blog.storageTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.TagStorage;
import org.wcci.blog.storage.TagStorageJpaImpl;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagStorageJpaImplTest {

    private TagRepository tagRepo;
    private TagStorage underTest;
    private Tag testTag;

    @BeforeEach
    void setUp() {
        tagRepo = mock(TagRepository.class);
        underTest = new TagStorageJpaImpl(tagRepo);
        Category testCategory = new Category("tech");
        Post testPost = new Post(testCategory, "test", "test", "test");
        testTag = new Tag("awesome", testPost);
    }
    @Test
    public void shouldFindTagByName() {
        when(tagRepo.findByName("awesome")).thenReturn(Optional.of(testTag));
        Tag retrievedTag = underTest.findTagByName("awesome");
        assertThat(retrievedTag).isEqualTo(testTag);
    }
}
