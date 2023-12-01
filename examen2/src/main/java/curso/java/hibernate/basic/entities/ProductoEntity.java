package curso.java.hibernate.basic.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Crear entity Productos
//1. Cargar Productos -> Pedir directorio y nombre del fichero con los datos a cargar
//2. Mostrar Productos
//3. Mostrar por Fecha -> Pedir fecha y mostrar los productos dados de alta en ese dia
//4. Mostrar para cada tipo de producto la media de precio y el total de productos
//NOMBRE;TIPO;FECHA_ALTA;PRECIO;UNIDADES


@Entity
@Table(name = "TB_PRODUCTOS")
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "NOMBRE",length = 30, nullable = false) 
	private	 String nombre;
	
	@Column(name = "TIPO",length = 30, nullable = false)
	private String tipo;
	
	@Column(name = "FECHA_ALTA", nullable = false)
	private Date fechaAlta;
	
	@Column(name = "PRECIO", nullable = false)
    private double precio;

    @Column(name = "UNIDADES", nullable = false)
    private int unidades;

	public ProductoEntity() {
		super();
	}

	public ProductoEntity(long id, String nombre, String tipo, Date fechaAlta, double precio, int unidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.unidades = unidades;
	}

	public ProductoEntity(long id, String nombre, String tipo, Date fechaAlta, int unidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.unidades = unidades;
	}

	public ProductoEntity(String nombre, String tipo, Date fechaAlta, double precio, int unidades) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.unidades = unidades;
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

	public final String getTipo() {
		return tipo;
	}

	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public final Date getFechaAlta() {
		return fechaAlta;
	}

	public final void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public final double getPrecio() {
		return precio;
	}

	public final void setPrecio(double precio) {
		this.precio = precio;
	}

	public final int getUnidades() {
		return unidades;
	}

	public final void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "ProductoEntity [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaAlta=" + fechaAlta
				+ ", unidades=" + unidades + "]";
	}

    
    



}
