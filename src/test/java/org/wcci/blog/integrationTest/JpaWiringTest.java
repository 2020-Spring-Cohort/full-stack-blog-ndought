package org.wcci.blog.integrationTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.PostRepository;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext
public class JpaWiringTest {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private TagRepository tagRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryShouldHaveAListOfPosts() {
        Category testCategory = new Category("tech");
        Post testPost = new Post(testCategory, "name", "title", "body");

        categoryRepo.save(testCategory);
        postRepo.save(testPost);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOptional = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOptional.get();
        Post retrievedPost = postRepo.findById(testPost.getId()).get();

        assertThat(retrievedCategory.getPosts()).contains(testPost);
    }
}
