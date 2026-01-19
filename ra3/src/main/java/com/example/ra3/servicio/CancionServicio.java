package com.example.ra3.servicio;

import java.util.List;
import com.example.ra3.entidad.Cancion;

public interface CancionServicio {

	List<Cancion> obtenerCanciones();
	Cancion obtenerCancionPorId(int id);
	void agregarCancion(Cancion cancion);
	void actualizarCancion(Cancion cancion);
	void eliminarCancion(int id);
}
