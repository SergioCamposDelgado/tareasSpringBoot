package com.example.ra3.datos;

import org.springframework.stereotype.Component;
import com.example.ra3.Ra3Application;
import com.example.ra3.entidad.Cancion;
import com.example.ra3.servicio.CancionServicio;
import com.github.javafaker.Faker;


import jakarta.annotation.PostConstruct;

@Component
public class IniciarDatos {

    private final Ra3Application ra3Application;

	private final int TOTAL_PRUEBAS = 10;
	private CancionServicio cancionServicio;

	
	public IniciarDatos(CancionServicio cancionServicio, Ra3Application ra3Application) {
		this.cancionServicio = cancionServicio;
		this.ra3Application = ra3Application;
	}
	
	
	@PostConstruct
	public void init() {
		Faker faker = new Faker();
		System.out.println("######### FAKE IniciarDatos.init()###########");
		for(int i=0; i<TOTAL_PRUEBAS; i++) {
			Cancion c = new Cancion();
			c.setNombre(faker.app().name());
			c.setDuracion((int) faker.number().randomNumber(3, false));
			
			cancionServicio.agregarCancion(c);
		}
		
	}
}
