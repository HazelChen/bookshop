package edu.nju.bookHouse.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mysql.jdbc.Statement;

public class StaticsDaoHelper {
	public List find(String hql) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery(hql);
		List list = query.list();

		session.close();
		sessionFactory.close();
		return list;
	}

	public Object findById(Class className, Serializable id) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Object object = session.get(className, id);
		session.close();
		sessionFactory.close();
		return object;
	}

	public List find(Class className, ArrayList<SimpleExpression> expressions) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(className);
		for (int i = 0; i < expressions.size(); i++) {
			criteria.add(expressions.get(i));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List list = criteria.list();

		session.close();
		sessionFactory.close();
		return list;
	}
	
	public List find(Class className, Criterion criterion) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(className);
		criteria.add(criterion);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List list = criteria.list();
		 
		session.close();
		sessionFactory.close();
		return list;
	}

	public List findAll(Class className) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(className);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List list = criteria.list();
		session.close();
		sessionFactory.close();
		return list;
	}

	public void save(Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public void update(Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void updateNotMerge(Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public void remove(Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void removeAll(List<?> list) {
		for (Object object : list) {
			remove(object);
		}
	}
	
	public List<?> findMax(Class<?> className, String column) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		DetachedCriteria maxId = DetachedCriteria.forClass(className);
		maxId.setProjection(Projections.max(column));
		
		Criteria criteria = session.createCriteria(className);
		criteria.add(Property.forName("id").eq(maxId));
		List<?> list = criteria.list();
		
		session.close();
		sessionFactory.close();
		return list;
	}
	
	private SessionFactory buildSessionFactory() {
		Configuration config = new Configuration().configure("/analyse.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
