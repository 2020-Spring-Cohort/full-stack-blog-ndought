package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
@RequestMapping("blog")
public class PostController {

    private CategoryStorage categoryStorage;
    private PostStorage storage;
    private TagStorage tagStorage;

    public PostController(CategoryStorage categoryStorage, PostStorage storage, TagStorage tagStorage) {
        this.categoryStorage = categoryStorage;
        this.storage = storage;
        this.tagStorage = tagStorage;
    }

//    Root Path
    @GetMapping
    public String displayPost(Model model) {
        model.addAttribute("posts", storage.getAll());
        model.addAttribute("categories", categoryStorage.getAll());
        return "post";
    }
    @GetMapping("/{id}")
    public String displayPost(@PathVariable long id, Model model) {
        Post retrievedPost = storage.findPostById(id);
        model.addAttribute("post", retrievedPost);
        model.addAttribute("tags", tagStorage.getAll());
        return "post";
    }

}
