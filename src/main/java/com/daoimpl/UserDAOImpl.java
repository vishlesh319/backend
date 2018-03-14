package com.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDAO;
import com.model.User;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(){}

	public UserDAOImpl(SessionFactory sessionFactory) {

     this.sessionFactory=sessionFactory;
	}


	//@Transactional
	public void insertUser(User user)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	@SuppressWarnings("deprecation")
	public User getUserId(String email) {

		Criteria c=sessionFactory.openSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));
		
		return  (User) c.uniqueResult();
		
		
	               
	}
	 
	

}