package org.wcci.blog.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//@Entity
//public class Post {
//
//}

//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private LocalDateTime time;
//
//    @Lob
//    private String body;
//
//    @ManyToMany
//    private Collection<Author> authors;
//
//    @ManyToOne
//    private Category category;
//    private String title;
//
//    @ManyToMany
//    private List<Tag> tags;
//
//
//    public Post() {
//    }
//    public Post(String title, String body, String time, Category category, Author author, Tag ...tags) {
//        this.title = title;
//        this.body = body;
//        this.category = category;
//        this.time = LocalDateTime.now();
////        this.authors = Arrays.asList(author);
//        this.authors = new ArrayList<>(Arrays.asList(authors));
//        this.tags = Arrays.asList(tags);
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public LocalDateTime getTime() {
//        return time;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public Collection<Author> getAuthors() {
//        return authors;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public List<Tag> getTags() {
//        return tags;
//    }
//    public void addTagToTags(Tag tag) {
//        ArrayList<Tag> tags = new ArrayList<Tag>(this.getTags());
//        tags.add(tag);
//        this.tags = tags;
//    }
//    public Long getId() {
//        return id;
//    }
//}
