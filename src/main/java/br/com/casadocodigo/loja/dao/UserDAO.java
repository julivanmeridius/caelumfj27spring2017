package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.User;

/**
 * @author spring7005
 *
 */
@Repository
public class UserDAO implements UserDetailsService, UserDetailsChecker {

	@PersistenceContext
	private EntityManager em;
	
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsChecker#check(org.springframework.security.core.userdetails.UserDetails)
	 */
	@Override
	public void check(UserDetails toCheck) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String jpql = "select u from User u where u.login = :login";
		List<User> users = em.createQuery(jpql, User.class).setParameter("login", username).getResultList();
		if(users.isEmpty()){
			throw new UsernameNotFoundException("O usuário " + username + " não existe!");
		}
		return users.get(0);
	}
}
