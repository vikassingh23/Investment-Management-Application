package com.springboot.app.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvestmentDao {


	@Autowired
	EntityManagerFactory entityManagerFactory;

	public <T> T getNodebyName(String name,String columnName, Class<T> classname) {
		Session session = null;
		T node = null;
		try {
			session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			Criteria criteria = session.createCriteria(classname);
			criteria.add(Restrictions.eq(columnName, name));
			node = (T) criteria.uniqueResult();
			return node;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Object saveOrUpdateObject(Object object) {
		Session session = null;
		try {
			session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return object;
	}



}
