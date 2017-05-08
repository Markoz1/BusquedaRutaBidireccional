package Modelo;


public class Modelo {
	private Grafo plazas;
	private DatosMapa datosMapa;
	public Modelo() {
		this.plazas = new Grafo();
		this.datosMapa = new DatosMapa();
		creacionPlazas();
	}

	private void creacionPlazas() {
		//creamos los Nodos plaza con todos los parametro q requiera y los insertamos en el Grafo y DatosMapa
		Nodo nodoA = new Nodo("A",4,1,2);
		int[] b = {0};
		Nodo nodoB = new Nodo("B",1,6,b,2);
		int[] c = {0};
		Nodo nodoC = new Nodo("C",7,3,c,3);
		int[] d = {2};
		Nodo nodoD = new Nodo("D",13,4,d,2);
		int[] e = {2};
		Nodo nodoE = new Nodo("E",8,8,e,2);
		int[] f = {1};
		Nodo nodoF = new Nodo("F",3,15,f,2);
		int[] g = {4,5};
		Nodo nodoG = new Nodo("G",8,17,g,4);
		int[] h = {3,6};
		Nodo nodoH = new Nodo("H",13,19,h,2);
		int[] i = {6};
		Nodo nodoI = new Nodo("I",7,22,i,1);
		
		//creacion de caminos partiendo desde un nodo
		String[] caminoDir1 = {"r","r","u","u","r","u","r"};
		Camino camino1 = new Camino(1,caminoDir1,nodoA);
		
		String[] caminoDir2 = {"d","d","d","r"};
		Camino camino2 = new Camino(2,caminoDir2,nodoA);
		
		String[] caminoDir3 = {"r","r","r","r","d","d","r","r","r","r"};
		Camino camino3 = new Camino(3,caminoDir3,nodoB);
		
		String[] caminoDir4 = {"r","r","r","r","r"};
		Camino camino4 = new Camino(4,caminoDir4,nodoC);
		
		String[] caminoDir5 = {"d","d","d","d","d","d"};
		Camino camino5 = new Camino(5,caminoDir5,nodoC);
		
		String[] caminoDir6 = {"r","r","r","r","r","r","r","r","r","r","r","r","r","r"};
		Camino camino6 = new Camino(6,caminoDir6,nodoD);
		
		String[] caminoDir7 = {"r","r","r","r","r","r","r","r"};
		Camino camino7 = new Camino(7,caminoDir7,nodoE);
		
		String[] caminoDir8 = {"r","r","d","d","d","d"};
		Camino camino8 = new Camino(8,caminoDir8,nodoF);
		
		String[] caminoDir9 = {"r","r","r","r","r"};
		Camino camino9 = new Camino(9,caminoDir9,nodoG);
		
		String[] caminoDir10 = {"d","d","r","r","d","d"};
		Camino camino10 = new Camino(10,caminoDir10,nodoG);
		
		this.plazas.insertarNodo(nodoA);
		this.plazas.insertarNodo(nodoB);
		this.plazas.insertarNodo(nodoC);
		this.plazas.insertarNodo(nodoD);
		this.plazas.insertarNodo(nodoE);
		this.plazas.insertarNodo(nodoF);
		this.plazas.insertarNodo(nodoG);
		this.plazas.insertarNodo(nodoH);
		this.plazas.insertarNodo(nodoI);
		
		this.datosMapa.insertarPlaza(nodoA);
		this.datosMapa.insertarPlaza(nodoB);
		this.datosMapa.insertarPlaza(nodoC);
		this.datosMapa.insertarPlaza(nodoD);
		this.datosMapa.insertarPlaza(nodoE);
		this.datosMapa.insertarPlaza(nodoF);
		this.datosMapa.insertarPlaza(nodoG);
		this.datosMapa.insertarPlaza(nodoH);
		this.datosMapa.insertarPlaza(nodoI);
		
		this.datosMapa.insertarCamino(camino1.getCoordenadas());
		this.datosMapa.insertarCamino(camino2.getCoordenadas());
		this.datosMapa.insertarCamino(camino3.getCoordenadas());
		this.datosMapa.insertarCamino(camino4.getCoordenadas());
		this.datosMapa.insertarCamino(camino5.getCoordenadas());
		this.datosMapa.insertarCamino(camino6.getCoordenadas());
		this.datosMapa.insertarCamino(camino7.getCoordenadas());
		this.datosMapa.insertarCamino(camino8.getCoordenadas());
		this.datosMapa.insertarCamino(camino9.getCoordenadas());
		this.datosMapa.insertarCamino(camino10.getCoordenadas());
		
		
		
		this.datosMapa.recorrerTablero();
	}
	public Grafo getPlazas() {
		return plazas;
	}
	public DatosMapa getModeloMapa() {
		return datosMapa;
	}
	public void prueba(Nodo n){
		n.setIndice(9);
	}
}
