package org.wcci.blog.integrationTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringWebAppTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostStorage postStorage;
    @MockBean
    private CategoryStorage categoryStorage;
    @MockBean
    private TagStorage tagStorage;

    @Test
    public void shouldReceiveOkFromPostsEndpoint() throws Exception {
        mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldReceiveOkFromCategoriesEndpoint() throws Exception {
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldReceiveOkFromTagsEndpoint() throws Exception {
        mockMvc.perform(get("/tags"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldReceiveOkFromAuthorsEndpoint() throws Exception {
        mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status().isOk());
    }
 }
