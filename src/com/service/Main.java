//package com.service;
//
//import java.io.UnsupportedEncodingException;
//import java.security.NoSuchAlgorithmException;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.swing.JOptionPane;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import com.entity.MyMD5Util;
//import com.entity.ReplyTask;
//import com.entity.User;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
//@WebAppConfiguration("WebContent") // web项目的根目录，默认为 file:src/main/webapp
//public class Main {
//	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "用户名或密码错误", "警告", JOptionPane.WARNING_MESSAGE);
//		// TODO Auto-generated method stub
//		// JavaSE环境下，EntityManagerFactory & EntityManager 必须手动关闭释放资源
//		EntityManagerFactory emFactory = null;
//		EntityManager em = null;
//		EntityTransaction transaction = null;
//		try {
//			emFactory = Persistence.createEntityManagerFactory("jpa");
//			em = emFactory.createEntityManager();
//			transaction = em.getTransaction();
//			transaction.begin();
//			User user = new User();
//			ReplyTask replyTask=new ReplyTask();
//			replyTask.setIntroduction("dsd");
//			replyTask.setName("企鹅窝群二");
//			em.persist(replyTask);
////			transaction.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			if (transaction != null && transaction.isActive()) {
//				transaction.rollback();
//			}
//		} finally {
//			// 关闭EntityManager
//			if (em != null && em.isOpen()) {
//				em.close();
//			}
//			// 关闭EntityManagerFactory
//			if (emFactory != null && emFactory.isOpen()) {
//				emFactory.close();
//			}
//		}
//	}
//}