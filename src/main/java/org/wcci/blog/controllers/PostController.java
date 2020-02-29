package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.models.Tag;
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
    @PostMapping("add")
    public String processAddPostForm(@RequestParam("category") String category, @RequestParam("postName") String postName, @RequestParam("postDescription") String postDescription,
                                     @RequestParam(value = "userName", required = false) String userName) {

        Category retrievedCategory = categoryStorage.findCategoryByName(category);
        if (userName == null || userName.isEmpty()) {
            storage.store(new Post(retrievedCategory, postName, postDescription));
        } else {
            storage.store(new Post(userName, retrievedCategory, postName, postDescription));
        }
        return "redirect:";
    }

    @PostMapping("/{id}/set-tag")
    public String addTagToPost(@RequestParam("tagName") String tagName, @PathVariable long id) {
        Tag retrievedTag = tagStorage.findTagByName(tagName);
        Post retrievedPost = storage.findPostById(id);

        if (retrievedPost.getTags().contains(retrievedTag)) {
            return "redirect:/post/" + id;
        }
        retrievedPost.getTags().add(retrievedTag);
        storage.store(retrievedPost);
        return "redirect:/post/" + id;
    }

}
