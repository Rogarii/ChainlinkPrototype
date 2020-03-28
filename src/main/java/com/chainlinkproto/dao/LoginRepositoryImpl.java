package com.chainlinkproto.dao;

import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chainlinkproto.model.Users;
import com.chainlinkproto.model.UserAuthority;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired
	private SessionFactory sessionFactory;
	   
	@Override
	public Users getUserByEmail(String emailAddress) {
		   Query<Users> query = sessionFactory.getCurrentSession().createQuery("FROM Users u WHERE u.emailAddress = :emailAddress");
		   query.setParameter("emailAddress", emailAddress);
		   return query.uniqueResult();   
	}

	@Override
	public void saveNewUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		UserAuthority userAuth = new UserAuthority();
		userAuth.setRoleAuth("ROLE_USER");
		userAuth.setUser(user);
		Set<UserAuthority> authorities = new HashSet<UserAuthority>();
		authorities.add(userAuth);
		user.setUserAuthority(authorities);
		session.persist(user);
	}
}
