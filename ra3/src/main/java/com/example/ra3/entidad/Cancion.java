package com.example.ra3.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Cancion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Nombre no puede estar en blanco")
	private String nombre;
	
	/**
	 * Duracion en segundos
	 */
	@NotNull (message="Debe haber una duracion")
    @Min(value = 10, message = "Demasiado corta para ser una canción")
    @Max(value = 1200, message = "Nadie escucha canciones de mas de 20 minutos ")
	private Integer duracion;
	
	public Cancion() {}
	
	public Cancion(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	
	public String getDuracionString() {
	    int segundosTotal = this.getDuracion(); 
	    
	    int min = segundosTotal / 60;
	    int seg = segundosTotal % 60;
	    
	    return min + ":" + String.format("%02d", seg);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		return "Cancion [" +this.getId() +"] " +this.getNombre() + " : " +this.getDuracion() +"s";
	}
	
}
