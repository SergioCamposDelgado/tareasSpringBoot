package com.example.ra3.servicio;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.ra3.entidad.Cancion;
import com.example.ra3.repositorio.CancionRepositorio;

@Primary
@Service
public class CancionServicioH2 implements CancionServicio{

	CancionRepositorio repositorio;
	
	public CancionServicioH2(CancionRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public List<Cancion> obtenerCanciones() {
		return repositorio.findAll();		
	}

	@Override
	public Cancion obtenerCancionPorId(int id) {
		return repositorio.getReferenceById(id);
	}

	@Override
	public void agregarCancion(Cancion cancion) {
		repositorio.save(cancion);
	}

	@Override
	public void actualizarCancion(Cancion cancion) {
		if(repositorio.existsById(cancion.getId())) {
			repositorio.save(cancion);
		}		
	}

	@Override
	public void eliminarCancion(int id) {
		repositorio.deleteById(id);		
	}

}
