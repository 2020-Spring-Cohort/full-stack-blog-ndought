package org.wcci.blog;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private PostStorage postStorage;
    private TagStorage tagStorage;

    public Populator(CategoryStorage categoryStorage, PostStorage postStorage, TagStorage tagStorage) {
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
        this.tagStorage = tagStorage;
    }
    @Override
    public void run(String... args) {
        Category tech = new Category("Tech");
        Category movies = new Category("Movies");
        Category games = new Category("Gaming");
        Category life = new Category("Life");
        categoryStorage.store(tech);
        categoryStorage.store(movies);
        categoryStorage.store(games);
        categoryStorage.store(life);

        Post techPost = new Post(tech, "Noah D.", "Graphene Batteries", "Amazing stuff, the first Graphene battery was just released by a california start-up...");
        Post moviesPost = new Post(movies, "Harry Potter", "I love the Harry Potter movies! I could watch them...");
        Post gamesPost = new Post(games, "Noah D.", "GTA VI", "GTA VI should be coming out around Holiday 2020...");
        Post lifePost = new Post(life, "Coding Bootcamp", "This program has been the hardest thing I have ever done by far...");
        postStorage.store(techPost);
        postStorage.store(moviesPost);
        postStorage.store(gamesPost);
        postStorage.store(lifePost);

        Tag fastcharge = new Tag("fastcharge", techPost);
        Tag patronus = new Tag("patronus", moviesPost);
        Tag vicecity = new Tag("vicecity", gamesPost);
        Tag determination = new Tag("determination", lifePost);

        tagStorage.add(fastcharge);
        tagStorage.add(patronus);
        tagStorage.add(vicecity);
        tagStorage.add(determination);

        techPost.getTags().add(fastcharge);
        moviesPost.getTags().add(patronus);
        gamesPost.getTags().add(vicecity);
        lifePost.getTags().add(determination);

        postStorage.store(techPost);
        postStorage.store(moviesPost);
        postStorage.store(gamesPost);
        postStorage.store(lifePost);
    }
}

