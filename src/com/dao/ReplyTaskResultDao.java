package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.entity.ReplyTask;
import com.entity.ReplyTaskResult;
import com.entity.User;
@Repository
public class ReplyTaskResultDao {
	EntityManagerFactory emFactory = null;
	EntityManager em = null;
	EntityTransaction transaction = null;
	public ReplyTaskResult replyTaskResult = new ReplyTaskResult();
	
	public int addReplyTaskResult(ReplyTaskResult replyTaskResult) {
		int n=0;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(replyTaskResult);
			n=replyTaskResult.getId();
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
			return 0;
		} finally {
			// 关闭EntityManager
			if (em != null && em.isOpen()) {
				em.isOpen();
			}
			// 关闭EntityManagerFactory
			if (emFactory != null && emFactory.isOpen()) {
				emFactory.close();
			}
		}
		return n;
	}
	
	public List<ReplyTaskResult> QueryRepliedTask(User user) {
		
		List<ReplyTaskResult> replyTaskResults = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			String jpql = "FROM ReplyTaskResult r WHERE  r.user.id="+user.getId();
			replyTaskResults = em.createQuery(jpql, ReplyTaskResult.class).getResultList();
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
			return null;
		} finally {
			// 关闭EntityManager
			if (em != null && em.isOpen()) {
				em.isOpen();
			}
			// 关闭EntityManagerFactory
			if (emFactory != null && emFactory.isOpen()) {
				emFactory.close();
			}
		}
		return replyTaskResults;
	}
	
public ReplyTaskResult QueryReplied(User user,ReplyTask replyTask) {
		
		ReplyTaskResult replyTaskResult = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			String jpql = "FROM ReplyTaskResult r WHERE  r.user.id="+user.getId()+" AND r.replyTask.id="+replyTask.getId();
			replyTaskResult = em.createQuery(jpql, ReplyTaskResult.class).getSingleResult();
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
			return null;
		} finally {
			// 关闭EntityManager
			if (em != null && em.isOpen()) {
				em.isOpen();
			}
			// 关闭EntityManagerFactory
			if (emFactory != null && emFactory.isOpen()) {
				emFactory.close();
			}
		}
		return replyTaskResult;
	}
}
