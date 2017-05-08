package Modelo;


public class Modelo {
	private Grafo plazas;
	public Modelo() {
		this.plazas = new Grafo();
		creacionPlazas();
		
		this.plazas.busquedaBidireccional2(0, 3);
	}

	private void creacionPlazas() {
		Nodo nodo1 = new Nodo("a");
		int[] b = {0};
		Nodo nodo2 = new Nodo("b",b);
		int[] c = {0};
		Nodo nodo3 = new Nodo("c",c);
		int[] d = {0};
		Nodo nodo4 = new Nodo("d",d);
		int[] e = {2,3};
		Nodo nodo5 = new Nodo("e",e);
		int[] f = {1,3,4};
		Nodo nodo6 = new Nodo("f",f);
		this.plazas.insertarNodo(nodo1);
		this.plazas.insertarNodo(nodo2);
		this.plazas.insertarNodo(nodo3);
		this.plazas.insertarNodo(nodo4);
		this.plazas.insertarNodo(nodo5);
		this.plazas.insertarNodo(nodo6);
		this.plazas.busquedaBidireccional2(0, 3);
	}
	public Grafo getPlazas() {
		return plazas;
	}

}
