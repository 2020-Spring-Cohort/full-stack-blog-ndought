package org.wcci.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

//@Entity
//public class Author {
//
//}

//    @Id
//    @GeneratedValue
//    private Long id;
//    private String author;
//
//    @ManyToMany(mappedBy = "authors")
//    private Collection<Post> posts;
//
//    public Author() {}
//
//    public Author(String author) {
//        this.author = author;
//    }
//
//    public Collection<Post> getPosts() {
//             return posts;}
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void addPostsToAuthor(Collection<Post> posts) {
//        this.posts = posts;
//    }
//
//    @Override
//    public String toString() {
//        return "Author{" +
//                "id=" + id +
//                ", author='" + author + '\'' +
//                ", posts=" + posts +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Author author1 = (Author) o;
//
//        if (id != null ? !id.equals(author1.id) : author1.id != null) return false;
//        if (author != null ? !author.equals(author1.author) : author1.author != null) return false;
//        return posts != null ? posts.equals(author1.posts) : author1.posts == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (author != null ? author.hashCode() : 0);
//        result = 31 * result + (posts != null ? posts.hashCode() : 0);
//        return result;
//    }
//}


