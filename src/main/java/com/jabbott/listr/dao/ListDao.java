package com.jabbott.listr.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;

import com.jabbott.listr.model.List;

@Transactional
public class ListDao extends AbstractSession implements Dao<List> {

	@Override
	public List save(List model) {
		getSession().persist(model);
		return model;
	}

	@Override
	public List findById(Long id) {
		String query = "FROM list WHERE list.list_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, id);
		List result = (List) q.getSingleResult();
		return result;
	}

	@Override
	public List deleteById(Long id) {
		List listToDelete = findById(id);
		getSession().delete(listToDelete);
		return listToDelete;
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<List> findAll() {
		Criteria criteria = getSession().createCriteria(List.class);
		return (java.util.List<List>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public java.util.List<List> findAllByUserId(Long userId) {
		String query = "FROM list WHERE list.list_user_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, userId);
		return (java.util.List<List>) q.getResultList();
	}

}
