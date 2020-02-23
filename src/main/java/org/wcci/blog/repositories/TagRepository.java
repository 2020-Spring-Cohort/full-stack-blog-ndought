package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    Tag findByTagLabel(String tagLabel);
}
