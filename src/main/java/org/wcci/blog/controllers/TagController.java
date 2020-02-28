package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
