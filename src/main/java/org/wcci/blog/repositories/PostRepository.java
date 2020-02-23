package org.wcci.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
