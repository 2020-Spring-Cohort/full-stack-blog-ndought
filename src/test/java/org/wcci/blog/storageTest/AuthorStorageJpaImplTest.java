package org.wcci.blog.storageTest;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.AuthorStorageJpaImpl;
import org.wcci.blog.storage.repositories.AuthorRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AuthorStorageJpaImplTest {

    @Test
    public void shouldStoreAuthor() {
        AuthorRepository authorRepo = mock(AuthorRepository.class);
        AuthorStorage underTest = new AuthorStorageJpaImpl(authorRepo);
        Author testAuthor = new Author("ralph");
        underTest.store(testAuthor);
        verify(authorRepo).save(testAuthor);
    }
}
