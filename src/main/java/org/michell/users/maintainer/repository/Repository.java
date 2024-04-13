package org.michell.users.maintainer.repository;

import java.util.List;

public interface Repository<T> {

    void update(T t);

    void delete(Long id);

    void create(T t);

    List<T> show();

}
