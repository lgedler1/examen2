package curso.java.hibernate.basic.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import curso.java.hibernate.basic.entities.ProductoEntity;
import jakarta.persistence.EntityManager;

public class ProductosDao {
	private EntityManager emg;

	public void escribirFichero (String fichero, List<ProductoEntity> producto) {
		File archivo = new File(fichero);
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, false))) {

			//CABECERA
			//			NOMBRE;TIPO;FECHA_ALTA;PRECIO;UNIDADES
			//			PRODUCTO1;TIPO1;2023-10-10;5000;3
			buffer.append("NOMBRE;TIPO;FECHA_ALTA;PRECIO;UNIDADES");
			buffer.newLine();
			for (ProductoEntity productos : producto) {
				SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
				String fecha = formattedDate.format(productos.getFechaAlta());

				buffer.append(productos.getId() + ";" +
						productos.getNombre() + ";" +
						productos.getTipo() + ";" +
						fecha+ ";" +
						productos.getPrecio() + ";" +
						productos.getUnidades() + ";" 
						);
				buffer.newLine();
			}

			System.out.println("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	private List<ProductoEntity> leerProductosDesdeArchivo (String nombreArchivo) {
		List<ProductoEntity> productos = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(";");
				if (partes.length == 5) {
					String nombre = partes[0].trim();
					String tipo = partes[1].trim();
					Date fechaAlta =  dateFormat.parse(partes[2].trim());
					double precio = Double.parseDouble(partes[3].trim());
					int unidades = Integer.parseInt(partes[4].trim());

					ProductoEntity producto = new ProductoEntity(nombre, tipo, fechaAlta, precio, unidades);
					productos.add(producto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // Manejo básico de excepciones, personaliza según tus necesidades.
		}

		return productos;
	}

}
