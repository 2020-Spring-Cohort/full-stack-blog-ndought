package org.wcci.blog.models;



import javax.persistence.Entity;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
//    private LocalDateTime localDateTime;


    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Tag> tags;
    @Lob
    private String body;

    public Post() {
    }

    public Post(String author, String title, String body) {
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<>();
    }

    public Post(Category category, String author, String title, String body) {
        this.category = category;
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<>();
    }
    public Post(Category category, String author, String title, String body, Tag... tags) {
        this.category = category;
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<>();
    }
    public Collection<Tag> getTags() {
        return tags;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }



//    public LocalDateTime getLocalDateTime() {
//        return localDateTime;
//    }

    public Category getCategory() {
        return category;
    }



    @Override
    public String toString() {
        return "Post{" +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (body != null ? !body.equals(post.body) : post.body != null) return false;
        return category != null ? category.equals(post.category) : post.category == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}


