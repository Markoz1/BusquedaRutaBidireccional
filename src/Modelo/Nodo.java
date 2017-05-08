package Modelo;

import java.util.ArrayList;

public class Nodo {
	private String nombre;
	private int indice;
	private boolean visitadoInicio;
	private boolean visitadoFin;
	private int[] nodosCercanos;
	private int[] posicion;
	private ArrayList<Integer> rutaInicio;
	private ArrayList<Integer> rutaFinal;
	private ArrayList<Camino> aristas;
	private ArrayList<Marcador> marcadores;
	
	public Nodo(String nombre,int fila, int columna, int[] nodosCercanos, int numMarcadores) {
		this.nombre = nombre;
		setPosicion(fila, columna);
		this.visitadoInicio = false;
		this.visitadoFin = false;
		this.nodosCercanos = nodosCercanos;
		this.rutaInicio = new ArrayList<Integer>();
		this.rutaFinal = new ArrayList<Integer>();
		crearMarcadores(numMarcadores);
	}
	public Nodo(String nombre,int fila, int columna, int numMarcadores){
		this.nombre = nombre;
		setPosicion(fila, columna);
		this.visitadoInicio = false;
		this.visitadoFin = false;
		this.nodosCercanos = null;
		this.rutaInicio = new ArrayList<Integer>();
		this.rutaFinal = new ArrayList<Integer>();
		crearMarcadores(numMarcadores);
	}
	public void setPosicion(int fila, int columna) {
		this.posicion = new int[2];
		posicion[0]=fila;
		posicion[1]=columna;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public void setVisitadoInicio(boolean visitadoInicio) {
		this.visitadoInicio = visitadoInicio;
	}
	public void setVisitadoFin(boolean visitadoFin) {
		this.visitadoFin = visitadoFin;
	}
	
	public void setRutaInicio(ArrayList<Integer> rutaNodoAnterio) {
		for (int i = 0; i < rutaNodoAnterio.size(); i++) {
			rutaInicio.add(rutaNodoAnterio.get(i));
		}
		rutaInicio.add(this.getIndice());
	}
	
	public void setRutaIncio(){
		rutaInicio.add(this.getIndice());
	}
	public void setRutaFinal(){
		rutaFinal.add(this.getIndice());
	}
	
	public void setRutaFinal(ArrayList<Integer> rutaNodoAnterio) {
		for (int i = 0; i < rutaNodoAnterio.size(); i++) {
			rutaFinal.add(rutaNodoAnterio.get(i));
		}
		rutaFinal.add(this.getIndice());
	}
	
	public ArrayList<Integer> getRutaInicio() {
		return rutaInicio;
	}
	public ArrayList<Integer> getRutaFinal() {
		return rutaFinal;
	}
	public ArrayList<Integer> crearRutaBusqueda(){
		ArrayList<Integer> res;
		int n = rutaFinal.size()-1;
		for (int i = 0; i < rutaFinal.size(); i++) {
			if(!rutaInicio.contains(rutaFinal.get(n-i))){
				rutaInicio.add(rutaFinal.get(n-i));
			}
		}
		res = rutaInicio;
		return res;
	}
	public int[] getPosicion() {
		return posicion;
	}
	public int getIndice() {
		return indice;
	}
	public int[] getNodosCercanos() {
		return nodosCercanos;
	}
	public String getNombre() {
		return nombre;
	}
	public boolean isVisitadoInicio() {
		return visitadoInicio;
	}
	public boolean isVisitadoFin() {
		return visitadoFin;
	}
	private void crearMarcadores(int n){
		this.marcadores = new ArrayList<Marcador>();
		int[] pos = this.getPosicion();
		int f = pos[0];
		int c = pos[1];
		for (int i = 0; i < n; i++) {
			
			
			Marcador nuevo = new Marcador();
			nuevo.setPosicion(f, c);
			marcadores.add(nuevo);
		}
	}
	/*
	 * solo para ver como recorre el grafo 
	 */
	public String getNodosCercanosCadena(){
		String res = "";
		if(nodosCercanos!=null){
			for (int i = 0; i < nodosCercanos.length; i++) {
				if(i == 0){
					res = res+Integer.toString(nodosCercanos[i]);
				}
				else{
					res = res+","+Integer.toString(nodosCercanos[i]);
				}		
			}
		}
		return res;
	}
	public ArrayList<Marcador> getMarcadores() {
		return marcadores;
	}
}
