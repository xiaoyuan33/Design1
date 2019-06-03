package com.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.entity.ReplyTask;
import com.entity.User;

@Repository
public class ReplyTaskDao {
	EntityManagerFactory emFactory = null;
	EntityManager em = null;
	EntityTransaction transaction = null;
	public ReplyTask replyTask = new ReplyTask();

	// public boolean addReplyTask(String name, String introduction, Date deadline,
	// boolean isClose) {
	public boolean addReplyTask(ReplyTask replyTask) {
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(replyTask);
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
			return false;
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
		return true;
	}

	public List<ReplyTask> QueryReplyTask() {
		List<ReplyTask> replyTasks = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			String jpql = "FROM ReplyTask";
			replyTasks = em.createQuery(jpql, ReplyTask.class).getResultList();
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
		return replyTasks;
	}
	
	public ReplyTask QueryReplyTaskById(int id) {
		ReplyTask replyTask = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			String jpql = "FROM ReplyTask r WHERE r.id="+id;
			replyTask = em.createQuery(jpql, ReplyTask.class).getSingleResult();
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
		return replyTask;
	}
	
	public boolean addUser(String name, String password) {
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
			return false;
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
		return true;
	}

	/*public User queryUser(String name, String password) {
		User user = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("work_2");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			String jpql = "select u from User u where u.name='" + name + "' and u.password='" + password + "'";
			user = em.createQuery(jpql, User.class).getSingleResult();
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
		return user;
	}*/
}
