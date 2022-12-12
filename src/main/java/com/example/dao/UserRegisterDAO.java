package com.example.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.pojo.UserLogin;
import com.example.pojo.UserRegister;

import antlr.collections.List;

public class UserRegisterDAO extends DAO{
	
//	@Autowired
//	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
//	Session session = sessionFactory.openSession();
//	Transaction tx = session.beginTransaction();
//
//	String hqlInsert = "insert into DelinquentAccount (id, name) select c.id, c.name from Customer c where ...";
//	int createdEntities = s.createQuery( hqlInsert )
//	        .executeUpdate();
//	tx.commit();
//	session.close();
	
	
	
	public void create(UserRegister userRegister) {
//	public void create(String id, String firstName, String lastName, String email, String password, String customer) { // UserRegister userRegister
		Query query = null;
		String q = "";
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(UserRegister.class);
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
//		Session session = HibernateUtil.getSessionFactory().openSession()
		
//		try {
//			transaction = session.beginTransaction();
//			q = "INSERT INTO usertable (id, firstName, lastName, email, password, customer)" + 
//			"SELECT id, firstName, lastName, email, password, customer FROM jdbc.usertable";
//			
//			query = session.createQuery(q);
//			System.out.println("Register: " + id + " " + firstName + " " + lastName);
//			query.executeUpdate();
//			transaction.commit();
		try {
			session.save(userRegister);
			transaction.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
		} 
		
	}
	
//	public void update(UserRegister userRegister) {
//		Query query = null;
//		String q = "";
//		Session session = sessionFactory.openSession();
//		
//		try {
//			q = "UPDATE usertable SET firstName=:firstName AND lastName=:lastName AND password=:password WHERE id=:id";
//			query = session.createQuery(q);
//			query.setParameter("firstName", userRegister.getFirstName());
//			query.setParameter("lastName", userRegister.getLastName());
//			query.setParameter("password", userRegister.getPassword());
//			query.executeUpdate();
//			
//		} catch (Exception e) {
//			
//		} 
//		session.close();
//	}
//	
//	
//	public void delete(UserRegister userRegister) {
//		Query query = null;
//		String q = "";
//		Session session = sessionFactory.openSession();
//		
//		try {
//			q = "DELETE FROM usertable WHERE id=:id";
//			query = session.createQuery(q);
////			query.setParameter("password", userRegister.getPassword());
//			query.executeUpdate();
//			
//		} catch (Exception e) {
//			
//		} 
//		session.close();
//	}
//	
//	public List get(UserRegister userRegister) {
//		Query query = null;
//		String q = "";
//		Session session = sessionFactory.openSession();
//		
//		try {
//			return (List) session.createQuery("from usertable").list();
//			
//		} catch (Exception e) {
//			
//		} 
//		session.close();
//		return null;
//	}
//	
//	public UserRegister checkUserRegister(String user, String psw) {
//		Query q = getSession().getNamedQuery("checklogin");
//		
//		Criteria crit = getSession().createCriteria(UserLogin.class);
//		Criterion c1 = Restrictions.eq("email", user);
//		Criterion c2 = Restrictions.eq("password", psw);;
//		crit.add(c1);
//		crit.add(c2);
//		
//		return (UserRegister) crit.uniqueResult();
//	}
	
	
	
	
	
}
