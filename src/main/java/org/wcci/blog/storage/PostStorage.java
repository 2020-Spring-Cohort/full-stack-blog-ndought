package org.wcci.blog.storage;


import org.wcci.blog.models.Post;

public interface PostStorage {

    void store(Post newPost);

    Post findPostById(long id);


}
