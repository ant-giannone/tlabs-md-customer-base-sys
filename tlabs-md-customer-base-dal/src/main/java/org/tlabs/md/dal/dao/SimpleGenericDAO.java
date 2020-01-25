package org.tlabs.md.dal.dao;

import java.util.List;
import java.util.Optional;

public interface SimpleGenericDAO<T> {

    public Optional<T> findOne(final Object id);

    public Optional<List<T>> findAll();

    public void create(final T entity);

    public T update(final T entity);

    public void delete(final T entity);
}
