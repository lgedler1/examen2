package curso.java.hibernate.basic;

import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import curso.java.hibernate.basic.entities.UserEntities;
import curso.java.hibernate.util.JPAUtilEx2;
import jakarta.persistence.EntityManager;

public class HibernateListar {
	//private static final Logger logger = LogManager.getLogger(HibernateListar.class);
	public static void main(String[] args) {
		//logger.debug("listar");
		EntityManager em = JPAUtilEx2.getEM("hibernateOracle");
		UserEntities user1 = new UserEntities( "user1 ", "apellido1", "DNI001");
		UserEntities user2 = new UserEntities( "user2 ", "apellido2", "DNI002");
		UserEntities user3 = new UserEntities( "user3 ", "apellido3", "DNI003");
		UserEntities user4 = new UserEntities( "user4 ", "apellido4", "DNI004");
		UserEntities user5 = new UserEntities( "user5 ", "apellido5", "DNI005");
		em.getTransaction().begin();
		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		em.persist(user4);
		em.persist(user5);
		em.getTransaction().commit();
		
		
		List<UserEntities> users = em.createQuery("from UserEntities", UserEntities.class).getResultList();
        users.forEach(System.out::println);//Método Referencia
        em.close();
        //logger.debug("Final"); 
		
	}

}
