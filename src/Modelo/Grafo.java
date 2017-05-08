package Modelo;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;


public class Grafo {
	private ArrayList<Nodo> listaNodos;
	private ArrayList<Nodo> rutaIni;
    private ArrayList<Nodo> rutaFin;
    private int[][] matrizAdyacencia;
    //
    private ArrayList<String> prueba;
    //
	public Grafo() {
		//
		this.prueba= new ArrayList<String>();
		//
		this.listaNodos = new ArrayList<Nodo>();
        this.rutaIni = new ArrayList<Nodo>();
        this.rutaFin = new ArrayList<Nodo>();
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
/*	public void busquedaBidireccional(int inicio, int fin){
        
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
    
                   //
                    
                    
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
    */
	public ArrayList<String> busquedaBidireccional2(int inicio, int fin){
        ArrayList<String> resultado= new ArrayList<String>();
        //Se toma el nodo inicio y final
        Nodo nodoInicio = listaNodos.get(inicio);
        Nodo nodoFin = listaNodos.get(fin);
        boolean cruzeRutasInicioFin = false;
        boolean termino = false;
        
        ArrayList<Nodo> listaAuxI = new ArrayList<Nodo>();
        ArrayList<Nodo> listaAuxF = new ArrayList<Nodo>();
        
        listaAuxI.add(nodoInicio);
        listaAuxF.add(nodoFin);
        
        // ArrayList de ArrayList para ir almacenando los nodos actuales con su predecesor o sucesor
        ArrayList<ArrayList<Integer>> posicionesIni= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> posicionesFin= new ArrayList<ArrayList<Integer>>();
        
        // Array que contiene Arrays con todos los indices adyacentes con su posiciones respectivas
        ArrayList<ArrayList<Integer>> listaAdyaIndices= new ArrayList<ArrayList<Integer>>();
        listaAdyaIndices= getAllIndicesAdyacente(getAllNodosAdyacentes());
        
        //Array para llenar el array de Array
        ArrayList<Integer> aux=new ArrayList<Integer>();
        while (!termino) {            
            
            int x = 0;
              
            
            ArrayList<Nodo> nodosAdyacentesInicio = getNodosAdyacentes(listaAuxI);//DE INCIO A FIN
            listaAuxI.clear();    
            while ( x < nodosAdyacentesInicio.size() ) {
                
                Nodo nodoActualInicio = nodosAdyacentesInicio.get(x);
                
                listaAuxI.add(nodoActualInicio);
                
                nodoActualInicio.setVisitadoInicio(true);
                listaNodos.remove(nodoActualInicio.getIndice());
                listaNodos.add(nodoActualInicio.getIndice(), nodoActualInicio);
                
                rutaIni.add(nodoActualInicio);//AÑADIR NODO PREDECESOR+NODOACTUAL
                for(int u=0;u<2;u++){
                	aux.add(nodoActualInicio.getIndice());
                }
                
                if ( (nodoActualInicio.isVisitadoInicio()) && ( nodoActualInicio.isVisitadoFin() )) {
                    cruzeRutasInicioFin = true;
                }
                x++;
            }
            if(cruzeRutasInicioFin){
            	termino = true;
            }
            else{
            	ArrayList<Nodo> nodosAdyacentesFin = getNodosAdyacentes(listaAuxF);//DE FIN A INICIO
            	listaAuxF.clear();
            	int y = 0;
            	while ( y < nodosAdyacentesFin.size() ) {
                    
                    Nodo nodoActualFin = nodosAdyacentesFin.get(y);
                    
                    listaAuxF.add(nodoActualFin);
                    
                    nodoActualFin.setVisitadoFin(true);
                    listaNodos.remove(nodoActualFin.getIndice());
                    listaNodos.add(nodoActualFin.getIndice(), nodoActualFin);
                    
                    rutaFin.add(nodoActualFin);//AÑADIR NODO SUCESOR+NODOACTUAL
                    
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
        ArrayList<ArrayList<Nodo>> adyaInicio= getAdyacenciasEspecíficas(listaAuxI);
        ArrayList<ArrayList<Nodo>> adyaFin= getAdyacenciasEspecíficas(listaAuxF);
        if (termino) {
			/*
			 * devolver camino de busqueda desde inicio a final
			 * 
			 */
        	prueba=armar(adyaInicio,adyaFin);
        	resultado=armar(adyaInicio, adyaFin);
        	//Para probar la salida del resultado
        	for(int i=0;i<resultado.size();i++){
        		System.out.println("TAM:"+adyaInicio.size()+"LON;"+adyaFin.size());
        	}
        	
		}
        return resultado;
    }
	
	/*
	 * Método para tener un Array de Arrays de adyacencias de Nodos específicos; para inicio y final
	 */
	
	private ArrayList<String> armar(ArrayList<ArrayList<Nodo>> ini, ArrayList<ArrayList<Nodo>> fin){
		
		ArrayList<String> res= new ArrayList<String>();
		
		for(int i=0;i<ini.size();i++){
			for(int j=0;j<ini.get(i).size();j++){
			res.add(ini.get(i).get(j).getNombre());
			}
		}
		for(int i=0;i<fin.size();i++){
			for(int j=0;j<fin.get(i).size();j++){
			res.add(ini.get(i).get(j).getNombre());
			}
		}
		Collections.sort(res);
		
		HashSet<String> hashSet = new HashSet<String>(res);
		res.clear();
		res.addAll(hashSet);
		
		return res;
	}
	
	private ArrayList<ArrayList<Nodo>> getAdyacenciasEspecíficas(ArrayList<Nodo> nod){
		ArrayList<ArrayList<Nodo>> res= new ArrayList<ArrayList<Nodo>>();
		ArrayList<ArrayList<Nodo>> aux= new ArrayList<ArrayList<Nodo>>();
		ArrayList<Nodo> nodoActual= new ArrayList<Nodo>();
		
		aux=getAllNodosAdyacentes();
		listaNodos.get(1);
		for(int i=0;i<nod.size();i++){
			for(int j=0;j<listaNodos.size();j++){
				nodoActual.clear();
				if(nod.get(i).getNombre().equals(listaNodos.get(j).getNombre())){
					for(int k=0;k<aux.get(j).size();k++){
						nodoActual.add(nod.get(i));
						nodoActual.add(aux.get(j).get(k));
						res.add(nodoActual);
					}
				}
			}
		}
		
		return res;
	}
	
	//Método que recibe como parámetros los 2 caminos que generan ambas búsquedas y devuelve el resultado armando la ruta completa.
/*	private ArrayList<Integer> armarCamino(ArrayList<ArrayList<Integer>> rutaIni, ArrayList<ArrayList<Integer>> rutaFin){
		ArrayList<Integer> camino= new ArrayList<Integer>();
		int auxIni, auxFin;
		camino.add(rutaIni.get(0).get(0));	//añadimos el primer elemento o estado Inicial
		for(int i=0;i<rutaIni.size()-1;i++){
			
		//	for(int j=0;j<rutaFin.size();j++){
		//		for(int z=0;z<1;z++){
				int z=0;
					auxIni= rutaIni.get(i).get(z);
					if(auxIni==rutaIni.get(i+1).get(z)){
						camino.add(rutaIni.get(i+1).get(z+1));
					}
					if(auxIni==rutaIni.get(i+1).get(z+1)){
						camino.add(rutaIni.get(i+1).get(z));
					}
		//		}
		//	}
		}
		for(int i=0;i<rutaFin.size()-1;i++){
			
		//	for(int j=0;j<rutaFin.size();j++){
		//		for(int z=0;z<1;z++){
				int z=0;
					auxFin= rutaFin.get(i).get(z);
					if(auxFin==rutaFin.get(i+1).get(z)){
						camino.add(rutaFin.get(i+1).get(z+1));
					}
					if(auxFin==rutaFin.get(i+1).get(z+1)){
						camino.add(rutaFin.get(i+1).get(z));
					}
		//		}
		//	}
		}
		return camino;
	}
*/	
	
	/*
	 * Éste es el método que se usa para hayar los adyacentes
	 */
	
	private ArrayList<Nodo> getNodosAdyacentes(int n) {
        ArrayList<Nodo> res = new ArrayList<Nodo>();
        for (int i = 0; i < matrizAdyacencia.length; i++) {  
            if (matrizAdyacencia[n][i] == 1 ) {
                res.add(listaNodos.get(i));
            }
        }
        return res;
    }
	
	/*
	 * Este metodo devuelve un Array de Array de Nodos Adyacentes de todos los nodos existentes
	 * de acuerdo a su posición.
	 */
	private ArrayList<ArrayList<Nodo>> getAllNodosAdyacentes(){
		ArrayList<ArrayList<Nodo>> res = new ArrayList<ArrayList<Nodo>>();
		for(int i=0;i< matrizAdyacencia.length;i++){
			res.add(getNodosAdyacentes(i));
		}
		return res;
	}
	
	/*
	 * este metodo recibe como parámetro una lista de arrays de los vecinos de los nodos,
	 * y reemplaza los nodos por sus respectivos índices en la lista de nodos
	 */
	private ArrayList<ArrayList<Integer>> getAllIndicesAdyacente(ArrayList<ArrayList<Nodo>> nodosAdyacentes){
		ArrayList<Integer> aux= new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i< nodosAdyacentes.size();i++){
			for(int j=0;j<nodosAdyacentes.get(i).size();j++){
				aux.add(nodosAdyacentes.get(i).get(j).getIndice());
				res.add(aux);
			}
			aux.clear();
		}
		return res;
	}
	/*
	 * Sólo el de arriba es el método que se usa
	 */
	private ArrayList<Nodo> getNodosAdyacentes( ArrayList<Nodo> nodos) {
        ArrayList<Nodo> res = new ArrayList<Nodo>();
        for (int i = 0; i < matrizAdyacencia.length; i++) {  
        	for(int j=0; j<nodos.size();j++){
            	if (matrizAdyacencia[i][j] == 1 ) {
            		res.add(listaNodos.get(j));
            	}
        	}
        }
        //añadir a lista res todos los nodos adyacentes de cada nodo q contenga la lista nodos
        return res;
    }
/*	
	private ArrayList<Integer> getIndiceAdyacentes( ArrayList<Nodo> nodos) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //añadir a lista res todos los nodos adyacentes de cada nodo q contenga la lista nodos
        return res;
    }
	/*
	 * solo para ver como recorre el grafo
	 */
	public void recorrerGrafo(){
		busquedaBidireccional2(0, 3);
		//
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
		insertarNodo(nodo1);
		insertarNodo(nodo2);
		insertarNodo(nodo3);
		insertarNodo(nodo4);
		insertarNodo(nodo5);
		insertarNodo(nodo6);
		busquedaBidireccional2(0, 3);
		//
        for (int i = 0; i < listaNodos.size(); i++) {
            System.out.println(listaNodos.get(i).getNombre()+" ("+listaNodos.get(i).getIndice()+")"+" vecinos:"+listaNodos.get(i).getNodosCercanosCadena()+"tamaño res: "+prueba.size());
        }
        
    	for(int i=0;i<prueba.size();i++){
    		System.out.println("ISRAEL OMAR AGUILAR NERY"+prueba.get(i));
    	}
    }
}
