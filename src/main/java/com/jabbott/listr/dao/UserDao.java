package com.jabbott.listr.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import com.jabbott.listr.model.User;

@Transactional
public class UserDao extends AbstractSession implements Dao<User> {

	@Override
	public User save(User model) {
		getSession().persist(model);
		return model;
	}

	@Override
	public User findById(Long id) {
		String query = "FROM user WHERE user.user_id = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, id);
		return (User) q.getSingleResult();
	}

	@Override
	public User deleteById(Long id) {
		User userToDelete = findById(id);
		getSession().delete(userToDelete);
		return userToDelete;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}
	
	public User findUserByEmail(String email) {
		String query = "FROM user WHERE user.email = ?1";
		Query q = getSession().createQuery(query);
		q.setParameter(1, email);
		return (User) q.getSingleResult();
	}
	
	

}
