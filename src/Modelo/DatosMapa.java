package Modelo;

import java.util.ArrayList;

import sun.awt.RepaintArea;

public class DatosMapa implements Runnable{
	private int[][] tablero;
	Marcador marcador;
	public Thread hilo;
	
	public DatosMapa() {
		crearTableroIsla();
		marcador = new Marcador();
		hilo = new Thread(this);
	}
	private void crearTableroIsla(){
        
        int f = 15;
        int c = 25;
        tablero = new int [f][c];
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
            	tablero[i][j]= 9;
            	//System.out.print(tablero[i][j]);
            }
            //System.out.print("\n");
        }
    }
	public int[][] getTablero() {
		return tablero;
	}
	public void insertarPlaza(Nodo plaza){
		int[] posicion = plaza.getPosicion();
		int i = posicion[0];
		int j = posicion[1];
		this.tablero[i][j] = plaza.getIndice();
	}
	public void insertarCamino(ArrayList<ArrayList<Integer>> camino){
		for (int i = 0; i < camino.size(); i++) {
			ArrayList<Integer> posicion = camino.get(i);
			this.tablero[posicion.get(0)][posicion.get(1)] = 10;
		}
	}
	public void recorrerTablero(){
		for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
            	//System.out.print(tablero[i][j]);
            }
            //System.out.print("\n");
        }
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!this.marcador.isTermino()){
			pintarRecorrido();
		}
		
	}
	public void pintarRecorrido(Marcador m){
		//modificar 
		int[] posicion = m.getPosicion();
		int f = posicion[0];
		int c = posicion[1];
		//f-1=arriba,f+1=abajo,c-1=izquierda,c+1=derecha
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(caminoLibre(f-1, c)){
			f--;
		}
		else{
			if(caminoLibre(f+1, c)){
				f++;
			}
			else{
				if(caminoLibre(f, c-1)){
					c--;
				}
				else{
					if(caminoLibre(f, c+1)){
						c++;
					}
					else{
						m.setTermino(true);
					}
				}
			}
		}
		setCaminoVisitado(f, c);
		m.setPosicion(f, c);
	}
	public void pintarRecorridoMod(Marcador m){
		//modificar 
		int[] posicion = m.getPosicion();
		int f = posicion[0];
		int c = posicion[1];
		//f-1=arriba,f+1=abajo,c-1=izquierda,c+1=derecha
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(caminoLibre(f-1, c)){
			f--;
			setCaminoVisitado(f, c);
		}
		if(caminoLibre(f+1, c)){
			f++;
			setCaminoVisitado(f, c);
		}
		if(caminoLibre(f, c-1)){
			c--;
			setCaminoVisitado(f, c);
		}
		if(caminoLibre(f, c+1)){
			c++;
			setCaminoVisitado(f, c);
		}		
		
		setCaminoVisitado(f, c);
		m.setPosicion(f, c);
	}
	public void pintarRecorrido(){
		//modificar 
		int[] posicion = marcador.getPosicion();
		int f = posicion[0];
		int c = posicion[1];
		//f-1=arriba,f+1=abajo,c-1=izquierda,c+1=derecha
		if(caminoLibre(f-1, c)){
			f--;
		}
		else{
			if(caminoLibre(f+1, c)){
				f++;
			}
			else{
				if(caminoLibre(f, c-1)){
					c--;
				}
				else{
					if(caminoLibre(f, c+1)){
						c++;
					}
					else{
						marcador.setTermino(true);
					}
				}
			}
		}
		setCaminoVisitado(f, c);
		marcador.setPosicion(f, c);
	}
	public boolean caminoLibre(int fil, int col){
		boolean res = false;
		if(tablero[fil][col] == 10){
			res = true;
		}
		return res;
	}
	public void setCaminoVisitado(int fil, int col){
		tablero[fil][col]=11;
	}
	public Marcador getMarcador() {
		return marcador;
	}
}
