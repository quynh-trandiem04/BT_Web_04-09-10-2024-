package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IVideoDao;
import vn.iotstar.entity.Video;

public class VideoDao implements IVideoDao {

    @Override
    public List<Video> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
        return query.getResultList();
    }

    @Override
    public Video findById(String videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        return em.find(Video.class, videoId);
    }

    @Override
    public Video save(Video video) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (video.getVideoId() == null) {
                em.persist(video);
            } else {
                em.merge(video);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
        return video;
    }

    @Override
    public void deleteById(String videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Video video = em.find(Video.class, videoId);
            if (video != null) {
                em.remove(video);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Video> searchByTitle(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        TypedQuery<Video> query = em.createQuery("SELECT v FROM Video v WHERE v.title LIKE :keyword", Video.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }
}