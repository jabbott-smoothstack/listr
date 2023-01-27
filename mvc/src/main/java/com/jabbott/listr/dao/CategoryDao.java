package com.jabbott.listr.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jabbott.listr.dto.UpdateCategoryDto;
import com.jabbott.listr.model.Category;

@Repository("categoryDao")
public class CategoryDao extends AbstractSession implements Dao<Category> {

	@Override
	public Category save(Category object) {
		getSession().persist(object);
		return object;
	}

	@Override
	public Category delete(Category object) {
		getSession().delete(object);
		return object;
	}

	@Override
	public Category findById(Long id) {
		String query_str = "FROM Category WHERE category_id = ?1";
		return (Category) getSession().createQuery(query_str).setParameter(1, id).uniqueResult();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Category> findAll() {
		return (List<Category>) getSession().createCriteria(Category.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategoriesByListId(Long listId) {
		return (List<Category>) getSession().createCriteria(Category.class).add(Restrictions.eq("category_list_id", listId)).list();
	}
	
	public int editCategory(UpdateCategoryDto updateCategoryDto) {
		String query_str = "UPDATE Category SET category_name = ?1 WHERE category_id = ?2";
		return getSession().createQuery(query_str).setParameter(1, updateCategoryDto.getNewCategoryName()).setParameter(2, updateCategoryDto.getCategoryId()).executeUpdate();
	}

}
