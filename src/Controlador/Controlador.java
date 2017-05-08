package Controlador;

import java.util.ArrayList;

import Modelo.Marcador;
import Modelo.Modelo;
import Modelo.Nodo;
import Vista.Vista;

public class Controlador implements Runnable{
	private Modelo modelo;
	private Vista vista;
	private ArrayList<Integer> ruta;
	Thread hilo;
	
	public Controlador() {
		hilo = new Thread(this);
		this.vista = new Vista();
		this.vista.setVisible(true);
		this.modelo = new Modelo();
		this.ruta = new ArrayList<Integer>();
		crearMapa();
		//busquedaBidireccional(0, 8);
		hilo.start();

		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		busquedaBidireccional(0, 8);
		
	}
	private void crearMapa() {
		//cargamos los datos de ModeloMapa en la vista Mapa
		this.vista.getMapa().setDatos(this.modelo.getModeloMapa());
		
	}
	public void busquedaBidireccional(int inicio, int fin){
        //Se toma el nodo inicio y final
        Nodo nodoInicio = modelo.getPlazas().getListaNodos().get(inicio);
        Nodo nodoFin = modelo.getPlazas().getListaNodos().get(fin);
        
        boolean cruzeRutasInicioFin = false;
        boolean termino = false;
        
        nodoInicio.setVisitadoInicio(true);
        nodoFin.setVisitadoFin(true);
        
        nodoInicio.setRutaIncio();
        nodoFin.setRutaFinal();
        mostrarGraficoNodoInicio(nodoInicio);
        mostrarGraficoNodoInicio(nodoFin);
        ArrayList<Nodo> listaAuxI = new ArrayList<Nodo>();
        ArrayList<Nodo> listaAuxF = new ArrayList<Nodo>();
        
        listaAuxI.add(nodoInicio);
        listaAuxF.add(nodoFin);
        
        while (!termino) {  
        	
        	int x = 0;          
            ArrayList<Integer> indiceAdyacentesInicio = modelo.getPlazas().getIndiceAdyacentesInicio(listaAuxI);//lista de indices de los nodos adyacentes de todo los nodos en la  ListaAuxI
            listaAuxI.clear(); 
            
            while ( x < indiceAdyacentesInicio.size() ) {
                
                Nodo nodoActualInicio = modelo.getPlazas().getListaNodos().get(indiceAdyacentesInicio.get(x));//devuelve el nodo adyacente en la posicion x 
                //System.out.println(nodoActualInicio.getIndice());
                listaAuxI.add(nodoActualInicio);
              
                nodoActualInicio.setVisitadoInicio(true);
                mostrarGraficoNodoInicio(nodoActualInicio);
                
                if ((nodoActualInicio.isVisitadoInicio()) && ( nodoActualInicio.isVisitadoFin())) {
                    cruzeRutasInicioFin = true;
                    //System.out.println( nodoActualInicio.getIndice());
                    ruta = nodoActualInicio.crearRutaBusqueda();
                }
                x++;
            }
            if(cruzeRutasInicioFin){
            	termino = true;
            }
            else{
            	ArrayList<Integer> indiceAdyacentesFinal = modelo.getPlazas().getIndiceAdyacentesFinal(listaAuxF);//DE FIN A INICIO
            	listaAuxF.clear();
            	
            	int y = 0;
            	while ( y < indiceAdyacentesFinal.size() ) {
                    
                    Nodo nodoActualFin = modelo.getPlazas().getListaNodos().get(indiceAdyacentesFinal.get(y));
                    //System.out.println(nodoActualFin.getIndice());
                    listaAuxF.add(nodoActualFin);
                    mostrarGraficoNodoInicio(nodoActualFin);
                    nodoActualFin.setVisitadoFin(true);
                    
                    if ((nodoActualFin.isVisitadoInicio()) && ( nodoActualFin.isVisitadoFin())) {
                        cruzeRutasInicioFin = true;
                        //System.out.println( nodoActualFin.getIndice());
                        ruta = nodoActualFin.crearRutaBusqueda();
                    }
                    y++;
                }
            	if(cruzeRutasInicioFin){
            		termino = true;
            	}
            	
            }
                
        }
    }
	private void mostrarGraficoNodoInicio(Nodo n) {
		for (int i = 0; i < n.getMarcadores().size(); i++) {
			Marcador nuevo = n.getMarcadores().get(i);
			this.vista.getMapa().repaint();
			while(!nuevo.isTermino()){
				this.modelo.getModeloMapa().pintarRecorrido(nuevo);
				this.vista.getMapa().repaint();
			}
		}
		
	}
	public ArrayList<Integer> getRuta() {
		return ruta;
	}
	public Modelo getModelo() {
		return modelo;
	}
}
