package vn.iotstar.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.entity.User;

public class UserDao implements IUserDao {

    @Override
    public List<User> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(String userId) {
        EntityManager em = JPAConfig.getEntityManager();
        return em.find(User.class, userId);
    }

    @Override
    public User save(User user) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (user.getUserId() == null) {
                em.persist(user);
            } else {
                em.merge(user);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
        return user;
    }

    @Override
    public void deleteById(String userId) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<User> searchByUsername(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username LIKE :keyword", User.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }
}
