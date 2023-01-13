package com.jabbott.listr.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;

import com.jabbott.listr.model.Category;

@Transactional
public class CategoryDao extends AbstractSession implements Dao<Category>{
	

	@Override
	public Category save(Category model) {
		getSession().persist(model);
		return model;
	}

	@Override
	public Category findById(Long id) {
		String query = "FROM category WHERE category.category_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, id);
		return (Category) q.getSingleResult();
	}

	@Override
	public Category deleteById(Long id) {
		Category categoryToDelete = findById(id);
		getSession().delete(categoryToDelete);
		return categoryToDelete;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Category> findAll() {
		Criteria criteria = getSession().createCriteria(Category.class);
		return (List<Category>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllByListId(Long listId) {
		String query = "FROM category WHERE category.category_list_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, listId);
		return (List<Category>) q.getResultList();
	}

}
