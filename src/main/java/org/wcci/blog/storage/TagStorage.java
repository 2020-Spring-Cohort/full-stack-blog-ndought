package org.wcci.blog.storage;


import org.wcci.blog.models.Tag;

import java.util.Collection;

public interface TagStorage {

    Collection<Tag> getAll();

    void add(Tag tag);

    Tag findTagById(Long id);

    Tag findTagByName(String name);
}
