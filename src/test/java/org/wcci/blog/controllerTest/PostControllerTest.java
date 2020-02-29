package org.wcci.blog.controllerTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.PostController;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest {

    private PostController underTest;
    private Model model;
    private PostStorage mockStorage;
    private CategoryStorage mockCategoryStorage;
    private TagStorage mockTagStorage;
    private Post testPost;
    private MockMvc mockMvc;
    private Category testCategory;

    @BeforeEach
    void setUp() {
        mockStorage = mock(PostStorage.class);
        mockCategoryStorage = mock(CategoryStorage.class);
        mockTagStorage = mock(TagStorage.class);
        underTest = new PostController(mockCategoryStorage, mockStorage, mockTagStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        model = mock(Model.class);
        testCategory = new Category("tech");
        testPost = new Post("bill", "hello", "test");
        when(mockCategoryStorage.findCategoryByName("tech")).thenReturn(testCategory);
        when(mockStorage.findPostById(1L)).thenReturn(testPost);
    }
    @Test
    public void displayPostReturnsPostTemplate() {
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("post");
    }

    @Test
    public void displayPostInteractsWithDependenciesCorrectly() {
        underTest.displayPost(1L, model);
        verify(mockStorage).findPostById(1L);
        verify(model).addAttribute("post", testPost);
    }
    @Test
    public void displayPostMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/post/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost));
    }
    @Test
    public void addPostShouldRedirect() throws Exception {
        mockMvc.perform(post("add")
                .param("category", "tech")
                .param("postName", "test")
                .param("postDescription", "test")
                .param("userName", "test"))
                .andExpect(status().is3xxRedirection());
        verify(mockStorage).store(new Post("test", testCategory, "test", "test"));
    }


}
