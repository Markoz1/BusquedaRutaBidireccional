package Modelo;
import java.util.ArrayList;

public class Camino {
	private int id;
	private ArrayList<ArrayList<Integer>> coordenadas;
	
	public Camino(int id,String[] direccion,Nodo nodoIni ) {
		this.id=id;
		crearCamino(direccion,nodoIni );
	}

	private void crearCamino(String[] direccion,Nodo nodo ) {
		this.coordenadas = new ArrayList<ArrayList<Integer>>();
		String[] dir  = direccion;
		int[]pos = nodo.getPosicion();
		int f = pos[0];
		int c = pos[1];
		for (int i = 0; i < dir.length; i++) {
			if(dir[i]=="u"){
				f--;
				ArrayList<Integer> posicion = new ArrayList<Integer>();
				posicion.add(f);
				posicion.add(c);
				coordenadas.add(posicion);
			}
			if(dir[i]=="d"){
				f++;
				ArrayList<Integer> posicion = new ArrayList<Integer>();
				posicion.add(f);
				posicion.add(c);
				coordenadas.add(posicion);
			}
			if(dir[i]=="l"){
				c--;
				ArrayList<Integer> posicion = new ArrayList<Integer>();
				posicion.add(f);
				posicion.add(c);
				coordenadas.add(posicion);
			}
			if(dir[i]=="r"){
				c++;
				ArrayList<Integer> posicion = new ArrayList<Integer>();
				posicion.add(f);
				posicion.add(c);
				coordenadas.add(posicion);
			}
		}
		
	}
	public ArrayList<ArrayList<Integer>> getCoordenadas() {
		return coordenadas;
	}

}
