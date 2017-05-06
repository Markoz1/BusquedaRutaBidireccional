package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	public Controlador() {
		this.vista = new Vista();
		this.vista.setVisible(true);
		this.modelo = new Modelo();
	}
	public Modelo getModelo() {
		return modelo;
	}
}
