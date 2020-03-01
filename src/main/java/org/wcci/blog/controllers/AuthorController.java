package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Author;
import org.wcci.blog.storage.AuthorStorage;

import java.util.Optional;

@Controller
@RequestMapping("authors")
public class AuthorController {

    AuthorStorage storage;

    public AuthorController(AuthorStorage storage) {
        this.storage = storage;
    }
    @RequestMapping
    public String displayAuthors(Model model) {
        model.addAttribute("authors", storage.getAll());
        return "authors";
    }
    @GetMapping("/{authorName}")
    public String displaySingleAuthor(@PathVariable String authorName, Model model) {
        Author retrievedAuthor = storage.findAuthorByName(authorName);
        model.addAttribute("author", retrievedAuthor);
        return "author";
    }


    @GetMapping("/{name}")
    public String getAuthor(@PathVariable String name, Model model) throws Exception {
        Optional<Author> author = Optional.ofNullable(storage.findAuthorByName(name));
        if (author.isPresent()) {
            model.addAttribute("authors", author.get());
        } else {
            throw new Exception("Author not found.");
        }
        return "author";
    }

//    linking to authors/add page
//    @GetMapping("/")
//    public String getAuthorForm(Model model) {
//
//        model.addAttribute("authors", storage.findAuthorByName(""));
//        return "authors/add";
//    }
//
//    @GetMapping("/all")
//    public String getAllAuthors(Model model) {
//        model.addAttribute("authors", storage.findAuthorByName(""));
//        return "authors/all";
//    }

//    Creation of new author on "submit" button
    @PostMapping("/add-author/")
    public String addAuthor(@RequestParam String name) {
        storage.store(new Author(name));
        return "redirect:";
    }


}
