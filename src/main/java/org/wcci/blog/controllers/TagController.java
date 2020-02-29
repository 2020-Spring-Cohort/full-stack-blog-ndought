package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Tag;
import org.wcci.blog.storage.TagStorage;

@Controller
@RequestMapping("tags")
public class TagController {

    TagStorage storage;

    public TagController(TagStorage storage) {
        this.storage = storage;
    }

    @GetMapping
    public String displayTags(Model model) {
        model.addAttribute("tags", storage.getAll());
        return "tags";
    }
    @GetMapping("/{tagId}")
    public String displayTags(@PathVariable long tagId, Model model) {
        Tag retrievedTag = storage.findTagById(tagId);
        model.addAttribute("tag", retrievedTag);
        return "tag";
    }
    @PostMapping("/add-hashtag")
    public String addTag(@RequestParam String tag) {
        storage.add(new Tag(tag));
        return "redirect:";
    }
}
