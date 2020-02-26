package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
@RequestMapping("post")
public class PostController {

    private PostStorage storage;
    private CategoryStorage categoryStorage;
    private TagStorage tagStorage;

    public PostController(PostStorage storage, CategoryStorage categoryStorage, TagStorage tagStorage) {
        this.storage = storage;
        this.categoryStorage = categoryStorage;
        this.tagStorage = tagStorage;
    }

    @GetMapping
    public String displayPosts(Model model) {
        model.addAttribute("post", storage.getAll());
        model.addAttribute("category", categoryStorage.getAll());
        return "post";
    }
}
