package Controlador;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		//controlador.getModelo().getPlazas().recorrerGrafo();
		ArrayList<Integer> arreglo = controlador.getRuta();
		for (int i = 0; i < arreglo.size(); i++) {
			System.out.println(arreglo.get(i));
		}

	}

}
