package com.jabbott.listr.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;

import com.jabbott.listr.model.Item;

@Transactional
public class ItemDao extends AbstractSession implements Dao<Item>{

	@Override
	public Item save(Item model) {
		getSession().persist(model);
		return model;
	}

	@Override
	public Item findById(Long id) {
		String query = "FROM item WHERE item.item_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, id);
		return (Item) q.getSingleResult();
	}

	@Override
	public Item deleteById(Long id) {
		Item itemToDelete = findById(id);
		getSession().delete(itemToDelete);
		return itemToDelete;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Item> findAll() {
		Criteria criteria = getSession().createCriteria(Item.class);
		return (List<Item>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> findAllByCategoryId(Long categoryId) {
		String query = "FROM item WHERE item.item_category_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, categoryId);
		return (List<Item>) q.getResultList();
	}

}
