package Modelo;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Nodo> listaNodos;
    private int[][] matrizAdyacencia;
    
	public Grafo() {
		this.listaNodos = new ArrayList<Nodo>();
        matrizAdyacencia = new int[50][50];
        //Se llena la matris inicialmente con ceros
        for (int x = 0; x < matrizAdyacencia.length; x++) {
            for (int y = 0; y < matrizAdyacencia[1].length; y++) {  
                matrizAdyacencia[x][y] = 0;
            }     
        }
	}
	
	public void insertarNodo(Nodo nodo){
        if (!listaNodos.isEmpty()) {
            int filNodo = listaNodos.size();
            int colNodo = nodo.getNodosCercanos().length;
            //
            for (int i = 0; i < colNodo; i++) {
                int adyacencia = nodo.getNodosCercanos()[i];
                matrizAdyacencia[filNodo][adyacencia] = 1;
                matrizAdyacencia[adyacencia][filNodo] = 1;
            }
            nodo.setIndice(filNodo);
        }
        else{
        	nodo.setIndice(0);
        }
        listaNodos.add(nodo);
    }
	public ArrayList<Integer> getIndiceAdyacentesInicio( ArrayList<Nodo> nodos) {
		//tambien registra la ruta desde el incio para los nodo adyacentes q genere
        ArrayList<Integer> res = new ArrayList<Integer>();
        int indice;
        for (int j = 0; j < nodos.size(); j++) {
        	indice = nodos.get(j).getIndice();
        	for (int i = 0; i < matrizAdyacencia.length; i++) {
                if (matrizAdyacencia[indice][i] == 1 && !listaNodos.get(i).isVisitadoInicio()) {
                    res.add(listaNodos.get(i).getIndice());
                    listaNodos.get(i).setRutaInicio(nodos.get(j).getRutaInicio());
                }
            }
		}
        return res;
    }
	public ArrayList<Integer> getIndiceAdyacentesFinal( ArrayList<Nodo> nodos) {
		//tambien registra la ruta desde el final para los nodo adyacentes q genere
        ArrayList<Integer> res = new ArrayList<Integer>();
        int indice;
        for (int j = 0; j < nodos.size(); j++) {
        	indice = nodos.get(j).getIndice();
        	for (int i = 0; i < matrizAdyacencia.length; i++) {
                if (matrizAdyacencia[indice][i] == 1 && !listaNodos.get(i).isVisitadoFin()) {
                    res.add(listaNodos.get(i).getIndice());
                    listaNodos.get(i).setRutaFinal(nodos.get(j).getRutaFinal());
                }
            }
		}
        return res;
    }
	public ArrayList<Nodo> getListaNodos() {
		return listaNodos;
	}
	/*
	 * solo para ver como recorre el grafo
	 */
	public void recorrerGrafo(){
        for (int i = 0; i < listaNodos.size(); i++) {
            //System.out.println(listaNodos.get(i).getNombre()+" ("+listaNodos.get(i).getIndice()+")"+" vecinos:"+listaNodos.get(i).getNodosCercanosCadena());
        }
    }
}
