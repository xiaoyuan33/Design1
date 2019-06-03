package com.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import com.entity.User;

public class UserDao2 {
	EntityManagerFactory emFactory = null;
	EntityManager em = null;
	EntityTransaction transaction = null;

	public boolean modifyUser(int id, String password) {
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			User user = em.find(User.class, id);
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

	public User queryUser(String name, String password) {
		User user = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			// 持久化操作
			String jpql = "select u from User u where u.name='" + name + "' and u.password='" + password+"'";
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
	}
}