package com.example.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.example.pojo.UserLogin;

public class UserLoginDAO extends DAO {

	public UserLogin get(long id) {
		return getSession().get(UserLogin.class, id);
	}
	
	public UserLogin checkUserLogin(String user, String psw) {
		Query q = getSession().getNamedQuery("checklogin");
//		q.setString("email", user);
//		q.setString("password", psw);
//		q.setParameter("email", user);
		
		Criteria crit = getSession().createCriteria(UserLogin.class);
		Criterion c1 = Restrictions.eq("email", user);
		Criterion c2 = Restrictions.eq("password", psw);;
		crit.add(c1);
		crit.add(c2);
		
		return (UserLogin) crit.uniqueResult();
	}
}
