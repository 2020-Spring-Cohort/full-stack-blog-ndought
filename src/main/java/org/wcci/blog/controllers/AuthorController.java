package org.wcci.blog.controllers;


//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.wcci.blog.models.Author;
//import org.wcci.blog.storage.repositories.AuthorRepository;
//import org.wcci.blog.storage.repositories.PostRepository;
//import org.wcci.blog.storage.AuthorStorage;
//
//import javax.annotation.Resource;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/authors")
//public class AuthorController {
//
//}


//    AuthorStorage authorStorage;
//
//
//    public AuthorController(AuthorStorage authorStorage) {
//        this.authorStorage = authorStorage;
//    }
//
//    @GetMapping("/{name}")
//    public String getAuthor(@PathVariable String name, Model model) throws Exception {
//        Optional<Author> author = Optional.ofNullable(authorStorage.findAuthorByName(name));
//        if (author.isPresent()) {
//            model.addAttribute("authors", author.get());
//        } else {
//            throw new Exception("Author not found.");
//        }
//        return "author";
//    }
//
////    linking to authors/add page
//    @GetMapping("/")
//    public String getAuthorForm(Model model) {
//
//        model.addAttribute("authors", authorStorage.findAuthorByName(""));
//        return "authors/add";
//    }
//
//    @GetMapping("/all")
//    public String getAllAuthors(Model model) {
//        model.addAttribute("authors", authorStorage.findAuthorByName(""));
//        return "authors/all";
//    }
//
////    Creation of new author on "submit" button
//    @PostMapping("/add-author/")
//    public String addAuthor() {
//        return "redirect:";
//    }
//
//    public String displaySingleAuthor(String name, Model mockModel) {
//        Author authorToDisplay = authorStorage.findAuthorByName(name);
//        mockModel.addAttribute("author", authorToDisplay);
//        return "author";
//    }
//}
