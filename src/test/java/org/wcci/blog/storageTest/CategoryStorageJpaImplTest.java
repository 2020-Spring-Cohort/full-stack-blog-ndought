package org.wcci.blog.storageTest;

import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.CategoryStorageJpaImpl;
import org.wcci.blog.storage.repositories.CategoryRepository;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpaImplTest {

    @Test
    public void shouldStoreCategory() {
        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        CategoryStorage storage = new CategoryStorageJpaImpl(categoryRepository);
        Category testCategory = new Category("tech");
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(testCategory));
        storage.store(testCategory);
        verify(categoryRepository).save(testCategory);
        assertThat(storage.getAll()).contains(testCategory);
    }
}
