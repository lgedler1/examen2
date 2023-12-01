package curso.java.hibernate.basic.daos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import curso.java.hibernate.basic.entities.UserEntities;
import curso.java.hibernate.util.JPAUtilEx2;
import jakarta.persistence.EntityManager;

public class UserDao {
	private EntityManager emg;
	
	
	public UserDao(EntityManager emg) {
		super();
		this.emg = emg;
	}

	public UserDao() {
		emg = JPAUtilEx2.getEM("hibernate Oracle");
	}
	
	public void meterlistado( EntityManager em) {
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
	}
	
	public List<UserEntities> getUsers(EntityManager em ){
		List<UserEntities> usuario;
		usuario = em.createQuery("from UserEntities", UserEntities.class).getResultList();
		return usuario;
	}
	
	public void escribirFichero (String fichero, List<UserEntities> usuarios) {
		File archivo = new File(fichero);
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, false))) {

			//CABECERA
			buffer.append("ID;NOMBRE;APELLIDOS;DNI;FECHA");
			buffer.newLine();
			for (UserEntities userEntity : usuarios) {
				SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
				String fecha = formattedDate.format(userEntity.getFechaAlta());
				
				buffer.append(userEntity.getId() + ";" +
						userEntity.getNombre() + ";" +
						userEntity.getApellidos() + ";" +
						userEntity.getDni() + ";" +
						fecha
						);
				buffer.newLine();
			}

			System.out.println("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
