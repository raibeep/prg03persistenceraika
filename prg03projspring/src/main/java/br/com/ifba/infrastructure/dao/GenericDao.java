package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

    @PersistenceContext
    private EntityManager em;

    private Class<Entity> type;

    public GenericDao() {
        this.type = (Class<Entity>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Entity save(Entity entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Entity entity) {
        Entity ref = em.find(type, entity.getId());
        em.remove(ref);
    }

    @Override
    public List<Entity> findAll() {
        return em.createQuery("from " + type.getName(), type).getResultList();
    }

    @Override
    public Entity findById(Long id) {
        return em.find(type, id);
    }
}
