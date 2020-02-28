package org.wcci.blog.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.CategoriesController;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest {

    private MockMvc mockMvc;
    private CategoriesController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;


    @BeforeEach
    void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoriesController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }
    @Test
    public void shouldReturnViewWithOneCategory() {
        Category testCategory = new Category("tech");
        when(mockStorage.findCategoryByName("tech")).thenReturn(testCategory);

        underTest.displaySingleCategory("tech", mockModel);

        verify(mockStorage).findCategoryByName("tech");
        verify(mockModel).addAttribute("category", testCategory);
    }
    @Test
    public void shouldReturnViewNamedCategoryWhenDisplaySingleCategoryIsCalled() {
        String viewName = underTest.displaySingleCategory("tech", mockModel);
        assertThat(viewName).isEqualTo("category");
    }

}
