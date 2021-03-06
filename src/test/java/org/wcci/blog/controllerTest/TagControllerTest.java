package org.wcci.blog.controllerTest;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.TagController;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.TagStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TagControllerTest {

    private TagController underTest;
    private Model model;
    private TagStorage mockStorage;
    private Tag testTag;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockStorage = mock(TagStorage.class);
        underTest = new TagController(mockStorage);
        model = mock(Model.class);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        Category testCategory = new Category("tech");
        Post testPost = new Post(testCategory, "test", "test");
        testTag = new Tag("nice", testPost);
        when(mockStorage.findTagById(1L)).thenReturn(testTag);
    }
    @Test
    public void displayTagReturnsTagTemplate() {
        String result = underTest.displayTags(1L, model);
        assertThat(result).isEqualTo("tag");
        verify(mockStorage).findTagById(1L);
    }
    @Test
    public void displayTagInteractsWithDependenciesCorrectly() {
        underTest.displayTags(1L, model);
        verify(mockStorage).findTagById(1L);
        verify(model).addAttribute("tag", testTag);
    }
    @Test
    public void displayTagMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/tags/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("tag"))
                .andExpect(model().attributeExists("tag"))
                .andExpect(model().attribute("tag", testTag));
    }
    @Test
    public void addTagShouldRedirect() throws Exception {
        mockMvc.perform(post("/tags/add-tag").param("tag", "test"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(mockStorage).add(new Tag("test"));
    }
}
