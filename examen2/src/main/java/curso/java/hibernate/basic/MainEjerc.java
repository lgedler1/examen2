package curso.java.hibernate.basic;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import curso.java.hibernate.basic.daos.UserDao;
import curso.java.hibernate.basic.entities.UserEntities;
import curso.java.hibernate.util.JPAUtilEx2;
import jakarta.persistence.EntityManager;

public class MainEjerc {
	private static final Logger logger = LogManager.getLogger(MainEjerc.class);
	public static void main(String[] args) {
		EntityManager em = JPAUtilEx2.getEM("hibernateOracle");
		UserDao udao = new UserDao(em);
		
		logger.debug("listar");
		udao.meterlistado(em);
        logger.debug("Final"); 
        List<UserEntities> usuario = udao.getUsers(em);
        usuario.forEach(System.out::println);
        udao.escribirFichero("PruebaFichero", usuario);
        
        
	}
	

}
