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
    private String body;
    private String author;
    private LocalDateTime localDateTime;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "post")
    private Collection<Tag> tag;

    public Post() {
    }

    public Post(LocalDateTime localDateTime, String author, String title, String body) {
        this.localDateTime = localDateTime;
        this.author = author;
        this.title = title;
        this.body = body;
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

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Tag> getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", localDateTime=" + localDateTime +
                ", category=" + category +
                ", tag=" + tag +
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
        if (author != null ? !author.equals(post.author) : post.author != null) return false;
        if (localDateTime != null ? !localDateTime.equals(post.localDateTime) : post.localDateTime != null)
            return false;
        if (category != null ? !category.equals(post.category) : post.category != null) return false;
        return tag != null ? tag.equals(post.tag) : post.tag == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (localDateTime != null ? localDateTime.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}

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
