package org.wcci.blog.storage;


import org.wcci.blog.models.Post;

import java.util.Collection;

public interface PostStorage {

  Collection<Post> getAll();

  void store(Post newPost);

  Post findPostById(Long id);

}
