package curso.java.hibernate.basic.daos;

import java.util.List;

import curso.java.hibernate.basic.entities.UserEntities;
import curso.java.hibernate.util.JPAUtilEx2;
import jakarta.persistence.EntityManager;

public class UserDao {
	private EntityManager em;
	
	public UserDao() {
		em = JPAUtilEx2.getEM("hibernate Oracle");
	}
	
	public List<UserEntities> getUsers(){
		List<UserEntities> usuario;
		usuario = em.createQuery("from UserEntities", UserEntities.class).getResultList();
		return usuario;
	}

}
