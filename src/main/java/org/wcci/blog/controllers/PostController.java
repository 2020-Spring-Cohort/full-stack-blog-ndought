package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
@RequestMapping("blog")
public class PostController {

    private PostStorage storage;


    public PostController(PostStorage storage) {
        this.storage = storage;

    }
    @RequestMapping
    public String post(Model model) {
        model.addAttribute("title", "My Blog");
        return "post";
    }

//    @GetMapping
//    public String displayPosts(Model model) {
//        model.addAttribute("post", storage.getAll());
//        return "post";
//    }
}
