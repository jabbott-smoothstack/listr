package com.jabbott.listr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jabbott.listr.model.User;

@Repository("userDao")
public class UserDao extends AbstractSession implements Dao<User> {

	@Override
	public User save(User object) {
		getSession().persist(object);
		return object;
	}

	@Override
	public User delete(User object) {
		getSession().delete(object);
		return object;
	}

	@Override
	public User findById(Long id) {
		String query_str = "FROM User WHERE user_id = ?1";
		User retrievedUser = (User) getSession().createQuery(query_str).setParameter(1, id).uniqueResult();
		return retrievedUser;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> findAll() {
		return (List<User>) getSession().createCriteria(User.class).list();
	}
	
	public User findByEmail(String email) {
		String query_str = "FROM User WHERE email = ?1";
		User retrievedUser = (User) getSession().createQuery(query_str).setParameter(1, email).getSingleResult();
		return retrievedUser;
	}
	
}
