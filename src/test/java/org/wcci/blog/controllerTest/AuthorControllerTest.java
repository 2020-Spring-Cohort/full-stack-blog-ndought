package org.wcci.blog.controllerTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.AuthorController;
import org.wcci.blog.models.Author;
import org.wcci.blog.repositories.AuthorRepository;
import org.wcci.blog.storage.AuthorStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class AuthorControllerTest {

    private MockMvc mockMvc;
    private AuthorController underTest;
    private AuthorStorage mockStorage;
    private Model mockModel;

    @Autowired
    private AuthorRepository storage;

    @BeforeEach
    void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(AuthorStorage.class);
        underTest = new AuthorController(mockStorage, storage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }
    @Test
    public void shouldReturnViewWithOneAuthor() {
        Author testAuthor = new Author("bill");
        when(mockStorage.findAuthorByName("bill")).thenReturn(testAuthor);

        underTest.displaySingleAuthor("name", mockModel);

        verify(mockStorage).findAuthorByName("bill");
        verify(mockModel).addAttribute("authors", testAuthor);
    }
    @Test
    public void shouldReturnViewNamedAuthorWhenDisplaySingleAuthorIsCalled() {
        String viewName = underTest.displaySingleAuthor("author", mockModel);
        assertThat(viewName).isEqualTo("author");
    }
    @Test
    public void shouldGoToIndividualEndpoint() throws Exception {
        Author testAuthor = new Author("dave");
        when(mockStorage.findAuthorByName("dave")).thenReturn(testAuthor);
        mockMvc.perform(get("/authors/dave"))
                .andExpect(status().isOk())
                .andExpect(view().name("author"))
                .andExpect(model().attributeExists("authors"))
                .andExpect(model().attribute("authors", testAuthor));

    }
    @Test
    public void authorsEndPointShouldDisplayAllAuthors() throws Exception {
        Author testAuthor = new Author("Test");

        List<Author> authorList = Collections.singletonList(testAuthor);

        when(mockStorage.getAll()).thenReturn(authorList);

        mockMvc.perform(get("/author/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("author"))
                .andExpect(model().attributeExists("authors"))
                .andExpect(model().attribute("authors", testAuthor));
    }
 }
