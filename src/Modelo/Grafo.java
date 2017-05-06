package Modelo;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Nodo> listaNodos;
	private ArrayList<Nodo> rutaIni;
    private ArrayList<Nodo> rutaFin;
    private int[][] matrizAdyacencia;
    
	public Grafo() {
		this.listaNodos = new ArrayList<Nodo>();
        this.rutaIni = new ArrayList<Nodo>();
        this.rutaIni = new ArrayList<Nodo>();
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
            }
            nodo.setIndice(filNodo);
        }
        else{
        	nodo.setIndice(0);
        }
        listaNodos.add(nodo);
    }
	public void busquedaBidireccional(int inicio, int fin){
        
        //Se toma el nodo inicio y final
        Nodo nodoInicio = listaNodos.get(inicio);
        Nodo nodoFin = listaNodos.get(fin);
        boolean cruzeRutasInicioFin = false;
        
        ArrayList<Nodo> nodosInicio = new ArrayList<Nodo>();
        ArrayList<Nodo> nodosFin = new ArrayList<Nodo>();
        
        nodosInicio.add(nodoInicio);
        nodosFin.add(nodoFin);
        
        ArrayList<Nodo> nodosAdyacentesInicio = getNodosAdyacentes(nodosInicio, inicio);
        ArrayList<Nodo> nodosAdyacentesFin = getNodosAdyacentes(nodosFin, fin);
        
        while (!cruzeRutasInicioFin) {            
            
            int x = 0;
            int y = 0;
            
            while ( ( x < nodosAdyacentesInicio.size() ) && y < nodosAdyacentesFin.size() ) {     
                
                if ( x < nodosAdyacentesInicio.size() ) {
                    
                    Nodo nodoActualInicio = nodosAdyacentesInicio.get(x);
                    nodoActualInicio.setVisitadoInicio(true);
                    listaNodos.remove(nodoActualInicio.getIndice());
                    listaNodos.add(nodoActualInicio.getIndice(), nodoActualInicio);
                    
                    rutaIni.add(nodoActualInicio);
                    
                    if ( (nodoActualInicio.isVisitadoInicio()) && ( nodoActualInicio.isVisitadoFin() )) {
                        
                        cruzeRutasInicioFin = true;
                    }
                }
                if ( y < nodosAdyacentesFin.size() ) {
                    
                    Nodo nodoActualFin = nodosAdyacentesFin.get(y);
                    nodoActualFin.setVisitadoFin(true);
                    listaNodos.remove(nodoActualFin.getIndice());
                    listaNodos.add(nodoActualFin.getIndice(), nodoActualFin);
                    
                    rutaFin.add(nodoActualFin);
                    
                    if ( (nodoActualFin.isVisitadoInicio()) && ( nodoActualFin.isVisitadoFin() )) {
                        
                        cruzeRutasInicioFin = true;
                    }
                }
            }
            if (!cruzeRutasInicioFin) {
                
                nodosAdyacentesInicio = getNodosAdyacentes(nodosAdyacentesInicio, inicio);
                nodosAdyacentesFin = getNodosAdyacentes(nodosAdyacentesFin, inicio);
                x++;
                y++;
            }
        }
    }
	public void busquedaBidireccional2(int inicio, int fin){
        
        //Se toma el nodo inicio y final
        Nodo nodoInicio = listaNodos.get(inicio);
        Nodo nodoFin = listaNodos.get(fin);
        boolean cruzeRutasInicioFin = false;
        boolean termino = false;
        
        ArrayList<Nodo> listaAuxI = new ArrayList<Nodo>();
        ArrayList<Nodo> listaAuxF = new ArrayList<Nodo>();
        
        listaAuxI.add(nodoInicio);
        listaAuxF.add(nodoFin);
        
        ArrayList<Nodo> nodosAdyacentesInicio = getNodosAdyacentes(listaAuxI);
        listaAuxI.clear();
        while (!termino) {            
            
            int x = 0;
            int y = 0;   
                
            while ( x < nodosAdyacentesInicio.size() ) {
                
                Nodo nodoActualInicio = nodosAdyacentesInicio.get(x);
                
                listaAuxI.add(nodoActualInicio);
                
                nodoActualInicio.setVisitadoInicio(true);
                listaNodos.remove(nodoActualInicio.getIndice());
                listaNodos.add(nodoActualInicio.getIndice(), nodoActualInicio);
                
                rutaIni.add(nodoActualInicio);
                
                if ( (nodoActualInicio.isVisitadoInicio()) && ( nodoActualInicio.isVisitadoFin() )) {
                    cruzeRutasInicioFin = true;
                }
                x++;
            }
            if(cruzeRutasInicioFin){
            	termino = true;
            }
            else{
            	ArrayList<Nodo> nodosAdyacentesFin = getNodosAdyacentes(listaAuxF);
            	listaAuxF.clear();
            	while ( y < nodosAdyacentesFin.size() ) {
                    
                    Nodo nodoActualFin = nodosAdyacentesFin.get(y);
                    
                    listaAuxF.add(nodoActualFin);
                    
                    nodoActualFin.setVisitadoFin(true);
                    listaNodos.remove(nodoActualFin.getIndice());
                    listaNodos.add(nodoActualFin.getIndice(), nodoActualFin);
                    
                    rutaFin.add(nodoActualFin);
                    
                    if ( (nodoActualFin.isVisitadoInicio()) && ( nodoActualFin.isVisitadoFin() )) {
                        cruzeRutasInicioFin = true;
                    }
                    y++;
                }
            	if(cruzeRutasInicioFin){
            		termino = true;
            	}
            	
            }
                
        }
        if (termino) {
			/*
			 * devolver camino de busqueda desde inicio a final
			 * 
			 */
		}
    }
	
	private ArrayList<Nodo> getNodosAdyacentes( ArrayList<Nodo> nodo, int n ) {
        ArrayList<Nodo> res = new ArrayList<Nodo>();
        for (int i = 0; i < matrizAdyacencia.length; i++) {  
            if (matrizAdyacencia[n][i] == 1 ) {
                res.add(listaNodos.get(i));
            }
        }
        return res;
    }
	private ArrayList<Nodo> getNodosAdyacentes( ArrayList<Nodo> nodos) {
        ArrayList<Nodo> res = new ArrayList<Nodo>();
        //añadir a lista res todos los nodos adyacentes de cada nodo q contenga la lista nodos
        return res;
    }
	/*
	 * solo para ver como recorre el grafo
	 */
	public void recorrerGrafo(){
        for (int i = 0; i < listaNodos.size(); i++) {
            System.out.println(listaNodos.get(i).getNombre()+" ("+listaNodos.get(i).getIndice()+")"+" vecinos:"+listaNodos.get(i).getNodosCercanosCadena());
        }
    }

}
