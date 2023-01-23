package com.jabbott.listr.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jabbott.listr.dto.UpdateListDto;
import com.jabbott.listr.model.List;

@Repository("listDao")
public class ListDao extends AbstractSession implements Dao<List>{

	@Override
	public List save(List object) {
		getSession().persist(object);
		return object;
	}

	@Override
	public List delete(List object) {
		getSession().delete(object);
		return object;
	}

	@Override
	public List findById(Long id) {
		String query_str = "FROM List WHERE list_id = ?1";
		return (List) getSession().createQuery(query_str).setParameter(1, id).uniqueResult();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public java.util.List<List> findAll() {
		return (java.util.List<List>) getSession().createCriteria(List.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public java.util.List<List> findAllByUserId(Long userId) {
		return (java.util.List<List>) getSession().createCriteria(List.class).add(Restrictions.eq("list_user_id", userId)).list();
	}
	
	public int editList(UpdateListDto updateListDto) {
		String query_str = "UPDATE List SET list_name = ?1 WHERE list_id = ?2";
		return getSession().createQuery(query_str).setParameter(1, updateListDto.getNewListName()).setParameter(2, updateListDto.getListId()).executeUpdate();
	}

}
