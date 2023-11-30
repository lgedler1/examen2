package curso.java.hibernate.basic.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
	public class UserEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(length = 20) 
	private	 String nombre;
	@Column(length = 40)
	private String apellidos;
	@Column(length = 10, unique = true)
	private String dni;
	@Column(name = "FECHA_ALTA")
	private Date fechaAlta;
	
	public UserEntities() {
		super();
		System.out.println("Creando objeto");
		
	}
	

	public UserEntities(String nombre, String apellidos, String dni) {
		super();
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = new Date();
	}


	public UserEntities(long id, String nombre, String apellidos, String dni, Date fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
		System.out.println("Creando objeto");
	}

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final String getApellidos() {
		return apellidos;
	}

	public final void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public final String getDni() {
		return dni;
	}

	public final void setDni(String dni) {
		this.dni = dni;
	}

	public final Date getFechaAlta() {
		return fechaAlta;
	}

	public final void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "UserEntities [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", fechaAlta=" + fechaAlta + "]";
	}

	
	
	
	

	
	
}
