package com.chainlinkproto.dao;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chainlinkproto.model.Users;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.EnterpriseAffiliates;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.UserAuthority;
import com.chainlinkproto.model.UserGroups;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CLPDaoImpl implements CLPDao {

	private static final Integer defaultGroup = 1;
	
	private static final Integer defaultEnterprise = 1;
	
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
		user.getUserAuthority().add(userAuth);
		session.persist(user);
	}

	@Override
	public Users getUserById(Integer id) {
		 Query<Users> query = sessionFactory.getCurrentSession().createQuery("FROM Users u WHERE u.id = :id");
		   query.setParameter("id", id);
		   return query.uniqueResult();   
	}

	@Override
	public void saveNewAccount(Accounts account, Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Users user = getUserById(id);
		account.setUser(user);
		account.setEnterpriseAffiliate(getEnterpriseById(defaultEnterprise));
		account.setUserGroup(getGroupById(defaultGroup));
		user.getAccounts().add(account);
		session.merge(user);
	}

	@Override
	public UserGroups getGroupById(Integer id) {
		Query<UserGroups> query = sessionFactory.getCurrentSession().createQuery("FROM UserGroups g WHERE g.id = :id");
		query.setParameter("id", id);
		return query.uniqueResult();  
	}

	@Override
	public EnterpriseAffiliates getEnterpriseById(Integer id) {
		Query<EnterpriseAffiliates> query = sessionFactory.getCurrentSession().createQuery("FROM EnterpriseAffiliates e WHERE e.id = :id");
		query.setParameter("id", id);
		return query.uniqueResult();
	}

	@Override
	public void saveNewProperty(IntelProperties property) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(property);
	}

	@Override
	public void updateAccount(Accounts account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(account);
	}

	@Override
	public IntelProperties getPropertyFromId(Integer id) {
		Query<IntelProperties> query = sessionFactory.getCurrentSession().createQuery("FROM IntelProperties i WHERE i.id = :id");
		query.setParameter("id", id);
		return query.uniqueResult();  
	}

	@Override
	public Contracts getContractFromId(Integer id) {
		Query<Contracts> query = sessionFactory.getCurrentSession().createQuery("FROM Contracts c WHERE c.id = :id");
		query.setParameter("id", id);
		return query.uniqueResult(); 
	}
	
}
