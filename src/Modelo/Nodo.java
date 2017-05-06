package Modelo;

public class Nodo {
	private String nombre;
	private int indice;
	private boolean visitadoInicio;
	private boolean visitadoFin;
	private int[] nodosCercanos;
	
	public Nodo(String nombre, int[] nodosCercanos) {
		this.nombre = nombre;
		this.visitadoInicio = false;
		this.visitadoFin = false;
		this.nodosCercanos = nodosCercanos;
	}
	public Nodo(String nombre){
		this.nombre = nombre;
		this.visitadoInicio = false;
		this.visitadoFin = false;
		this.nodosCercanos = null;
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
}
