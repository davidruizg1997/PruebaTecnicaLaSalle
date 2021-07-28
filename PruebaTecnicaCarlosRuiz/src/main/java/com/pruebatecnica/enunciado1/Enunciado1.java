package com.pruebatecnica.enunciado1;

public class Enunciado1 {
	
	//Busqueda de palabra en la matriz
	public static boolean search(char [][]matrix, String word) {
		
		//Instancia de variables
		boolean vBoolReturn = false;
		int vIntLetrasPalabra = word.length();
		int vIntFilaActual;
		int vIntColumnaActual;
		char vChrPrimeraLetraWord = word.charAt(0);
		boolean vBoolCaracteresEncontrados;
		
		//Busqueda por fila y columna
		for(int vIntFila=0; vIntFila<matrix.length; vIntFila++) {
			for(int vIntColumna=0; vIntColumna<matrix[vIntFila].length; vIntColumna++) {
				
				//Inicialización de variables
				vIntFilaActual = 0;
				vIntColumnaActual = 0;
				
				//Validación de letra por letra en la matrix con la primera letra de la palabra
				if(matrix[vIntFila][vIntColumna]==vChrPrimeraLetraWord) {
					
					//Busqueda horizontal de la palabra
					vIntFilaActual = vIntFila;
					vIntColumnaActual = vIntColumna;
					vBoolCaracteresEncontrados = false;
					
					//Recorrido y validación letra por letra de la palabra con letras de la matriz de manera horizontal
					for(int vIntIndiceCaracter=0; vIntIndiceCaracter<vIntLetrasPalabra;vIntIndiceCaracter++) {
						if(vIntFilaActual>=matrix.length || vIntColumnaActual>=matrix[vIntFilaActual].length || matrix[vIntFilaActual][vIntColumnaActual]!=word.charAt(vIntIndiceCaracter)) {
							vBoolCaracteresEncontrados = false;
							break;
						}else {
							vIntColumnaActual = vIntColumnaActual+1;
							vBoolCaracteresEncontrados = true;
						}
					}
					
					if(vBoolCaracteresEncontrados==true) {
						vBoolReturn = true;
						break;
					}
					
					//Busqueda vertical de la palabra
					vIntFilaActual = vIntFila;
					vIntColumnaActual = vIntColumna;
					vBoolCaracteresEncontrados = false;
					
					//Recorrido y validación letra por letra de la palabra con letras de la matriz de manera vertical
					for(int vIntIndiceCaracter=0; vIntIndiceCaracter<vIntLetrasPalabra;vIntIndiceCaracter++) {
						if(vIntFilaActual>=matrix.length || vIntColumnaActual>=matrix[vIntFilaActual].length || matrix[vIntFilaActual][vIntColumnaActual]!=word.charAt(vIntIndiceCaracter)) {
							vBoolCaracteresEncontrados = false;
							break;
						}else {
							vIntFilaActual = vIntFilaActual+1;
							vBoolCaracteresEncontrados = true;
						}
					}
					
					//Validación para confirmar que se encontro la palabra
					if(vBoolCaracteresEncontrados==true) {
						vBoolReturn = true;
						break;
					}
				}
			}
		}
		
		return vBoolReturn;
	}
}