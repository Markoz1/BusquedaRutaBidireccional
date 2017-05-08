package Modelo;

public class Marcador{
	private int[] posicion;
	private int indice;
	private boolean termino;

	public Marcador(int[] posicion, int i) {
		this.posicion = posicion;
		this.indice = i;
		this.termino = false;
	}
	public Marcador() {
		this.posicion = new int [2];
		this.indice = 1;
		this.termino = false;
	}
	public int[] getPosicion() {
		return posicion;
	}
	public int getIndice() {
		return indice;
	}
	public void setPosicion(int f, int c) {
		this.posicion[0]=f;
		this.posicion[1]=c;
	}
	public boolean isTermino() {
		return termino;
	}
	public void setTermino(boolean termino) {
		this.termino = termino;
	}
	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
	}
	
}
