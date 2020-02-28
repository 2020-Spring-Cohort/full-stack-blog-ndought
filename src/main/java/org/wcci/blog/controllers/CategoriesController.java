package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;

@Controller
@RequestMapping("categories")
public class CategoriesController {

    CategoryStorage storage;

    public CategoriesController(CategoryStorage storage) {
        this.storage = storage;
    }
    @RequestMapping
    public String displayCategories(Model model) {
        model.addAttribute("categories", storage.getAll());
        return "categories";
    }

    @GetMapping("/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = storage.findCategoryByName(categoryName);
        model.addAttribute("category", retrievedCategory);
        return "category";
    }
    @PostMapping("/add-category")
    public String addCategory(@RequestParam String name) {
        storage.store(new Category(name));
        return "redirect";
    }

}
