
package com.zjw.blog.base;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


/**
 * @author belldog
 * @CreateDate 2015-7-24 上午10:10:38
 */
public class HibaneteBaseRepository<E extends Serializable, PK extends Serializable> implements BaseRepository<E, PK> {

    private SessionFactory sessionFactory;

    protected final Class<E> entityClass;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public HibaneteBaseRepository() {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public E get(PK id) {
        return (E) getSession().get(entityClass, id);
    }

    @Override
    public void update(E entity) {
        getSession().merge(entity);
    }

    @Override
    public void save(E entity) {
        getSession().persist(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteById(PK id) {
        E entity = get(id);
        getSession().delete(entity);
    }

}
