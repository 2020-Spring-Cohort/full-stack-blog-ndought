package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.models.Author;
import org.wcci.blog.repositories.AuthorRepository;
import org.wcci.blog.repositories.PostRepository;
import org.wcci.blog.storage.AuthorStorage;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Resource
    PostRepository postRepo;

    @Resource
    AuthorRepository authorRepo;

    public AuthorController(AuthorStorage mockStorage) {
        
    }

    @GetMapping("/{id}")
    public String getAuthor(@PathVariable Long id, Model model) throws Exception {
        Optional<Author> author = authorRepo.findById(id);
        if (author.isPresent()) {
            model.addAttribute("authors", author.get());
        } else {
            throw new Exception("Author not found.");
        }
        return "authors/author";
    }

//    linking to authors/add page
    @GetMapping("/")
    public String getAuthorForm(Model model) {

        model.addAttribute("authors", authorRepo.findAll());
        return "authors/add";
    }

    @GetMapping("/all")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepo.findAll());
        model.addAttribute("posts", postRepo.findAll());
        return "authors/all";
    }

//    Creation of new author on "submit" button
    @PostMapping("/")
    public String addAuthor(String author) {
        Author authorToAdd = authorRepo.findByAuthor(author);
        if (authorToAdd == null) {
            authorToAdd = authorRepo.save(new Author(author));
        }
        return "redirect:/authors/" + authorToAdd.getId();
    }

    public String displaySingleAuthor(String name, Model mockModel) {
        return name;
    }
}
