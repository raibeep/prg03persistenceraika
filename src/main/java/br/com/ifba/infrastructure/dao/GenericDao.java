package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("gerenciamento_curso");

    private Class<Entity> type;

    public GenericDao() {
        this.type = (Class<Entity>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private EntityManager getEm() {
        return factory.createEntityManager();
    }

    @Override
    public Entity save(Entity entity) {
        EntityManager em = getEm();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        EntityManager em = getEm();
        em.getTransaction().begin();
        Entity merged = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return merged;
    }

    @Override
    public void delete(Entity entity) {
        EntityManager em = getEm();
        em.getTransaction().begin();
        Entity ref = em.find(type, entity.getId());
        em.remove(ref);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Entity> findAll() {
        EntityManager em = getEm();
        List<Entity> list = em.createQuery("from " + type.getName()).getResultList();
        em.close();
        return list;
    }

    @Override
    public Entity findById(Long id) {
        EntityManager em = getEm();
        Entity found = em.find(type, id);
        em.close();
        return found;
    }
}
