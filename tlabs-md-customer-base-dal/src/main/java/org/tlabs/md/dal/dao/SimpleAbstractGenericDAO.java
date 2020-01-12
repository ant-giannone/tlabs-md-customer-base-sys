package org.tlabs.md.dal.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public abstract class SimpleAbstractGenericDAO<T> implements SimpleGenericDAO<T> {

    private EntityManager entityManager;
    private Class<T> clazz;

    public SimpleAbstractGenericDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findOne(final Object id) {

        T t = entityManager.find(clazz, id);

        if(t==null) {
            return Optional.empty();
        }

        return Optional.of(t);
    }

    @Override
    public Optional<List<T>> findAll() {

        List<T> resultList = entityManager.createQuery("from " + clazz.getName()).getResultList();

        if(resultList==null || resultList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(resultList);
    }

    @Override
    public void create(T entity) {

        entityManager.persist(entity);
    }

    @Override
    public T update(T entity) {

        T merge = entityManager.merge(entity);
        entityManager.flush();

        return merge;
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }
}
