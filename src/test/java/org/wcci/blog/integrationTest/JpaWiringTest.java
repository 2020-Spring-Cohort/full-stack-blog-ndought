package org.wcci.blog.integrationTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.models.Tag;
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

    @Test
    public void tagsShouldBeAbleToHaveMultiplePosts() {
        Category testCategory = new Category("sports");
        Post testPost1 = new Post("name", "title", "content");
        Post testPost2 = new Post("name", "title", "content");
        Post testPost3 = new Post("name", "title", "content");

        Tag testTag1 = new Tag("happy", testPost1, testPost2);
        Tag testTag2 = new Tag("awesome", testPost1, testPost3);

        categoryRepo.save(testCategory);

        postRepo.save(testPost1);
        postRepo.save(testPost2);
        postRepo.save(testPost3);

        tagRepo.save(testTag1);
        tagRepo.save(testTag2);

        testPost1.getTags().add(testTag1);
        testPost1.getTags().add(testTag2);
        testPost2.getTags().add(testTag1);
        testPost3.getTags().add(testTag2);

        entityManager.flush();
        entityManager.clear();

        Post retrievedPost = postRepo.findById(testPost1.getId()).get();
        Tag retrievedTag1 = tagRepo.findById(testTag1.getId()).get();
        Tag retrievedTag2 = tagRepo.findById(testTag2.getId()).get();
        assertThat(retrievedPost.getTags()).contains(testTag1, testTag2);
        assertThat(retrievedTag1.getPosts()).contains(testPost1, testPost2);
        assertThat(retrievedTag2.getPosts()).contains(testPost1, testPost3);
    }
}
