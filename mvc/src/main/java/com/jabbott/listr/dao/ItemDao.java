package com.jabbott.listr.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jabbott.listr.dto.UpdateItemDto;
import com.jabbott.listr.model.Item;

@Repository("itemDao")
public class ItemDao extends AbstractSession implements Dao<Item>{

	@Override
	public Item save(Item object) {
		getSession().persist(object);
		return object;
	}

	@Override
	public Item delete(Item object) {
		getSession().delete(object);
		return object;
	}

	@Override
	public Item findById(Long id) {
		String query_str = "FROM Item WHERE item_id = ?1";
		return (Item) getSession().createQuery(query_str).setParameter(1, id).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Item> findAll() {
		return (List<Item>) getSession().createCriteria(Item.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> findAllByCategoryId(Long categoryId) {
		return (List<Item>) getSession().createCriteria(Item.class).add(Restrictions.eq("item_category_id", categoryId)).list();
	}
	
	public int editItem(UpdateItemDto updateItemDto) {
		System.out.println(updateItemDto.getItemName());
		System.out.println(updateItemDto.getItemId());
		String query_str = "UPDATE Item SET item_name = ?1 WHERE item_id = ?2";
		return getSession().createQuery(query_str).setParameter(1, updateItemDto.getItemName()).setParameter(2, updateItemDto.getItemId()).executeUpdate();
	}

}
