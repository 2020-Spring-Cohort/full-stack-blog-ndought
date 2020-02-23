package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Resource
    PostRepository postRepo;

    @Resource
    AuthorRepository authorRepo;
}
