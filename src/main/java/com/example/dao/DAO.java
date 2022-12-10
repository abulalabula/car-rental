package com.example.dao;

import java.sql.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.log.Log;

import java.util.logging.Level;
import java.util.logging.Logger;
import ch.qos.logback.core.net.LoginAuthenticator;

public class DAO {
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
//    static final String USER = "test";
//    static final String PASSWORD = "testpw";
	private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal sesstionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    protected DAO() {
		
	}
    public static Session getSession() {
    	Session session = (Session) DAO.sesstionThread.get();
    	if(session == null) {
    		session = sessionFactory.openSession();
    		DAO.sesstionThread.set(session);
    	}
		return session;
	}
    
    protected void begin() {
		getSession().beginTransaction();
	}
    protected void commit() {
    	getSession().getTransaction().commit();
		
	}
    protected void rollback() {
    	try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot rollback", e);
		}
    	try {
			getSession().close();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot close", e);
		}
    	DAO.sesstionThread.set(null);
    }
    public static void close() {
    	getSession().close();
    	DAO.sesstionThread.set(null);
    }
//    public Connection connection;
//    public Connection getConnection() throws Exception {
//        try {
//            Class.forName(JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//            Statement st = connection.createStatement();
//            // class ThreadLocal will have their own variable (copy)
//            // interface SessionFactory: inherited by every session in subclasses
////            ResultSet rs = st.executeQuery("SELECT * FROM jdbc.movies");
////            while(rs.next()){
////                System.out.println(rs.getString("Query Success!"));
////            }
////            st.close();
////            connection.close();
//        } catch (SQLException ex) {
//            // Fail sometimes for high frequency access
//            System.out.println(ex);
//            ex.printStackTrace();
//            throw new Exception();
//        }
//        return this.connection;
//    }
}
