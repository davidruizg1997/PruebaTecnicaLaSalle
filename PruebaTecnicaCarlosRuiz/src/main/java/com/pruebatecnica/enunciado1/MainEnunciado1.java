package com.pruebatecnica.enunciado1;

public class MainEnunciado1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] vChrLstLetras = new char[][] {
			{'a','b','c','d','e','f','g','h'},
			{'i','j','k','l','m','n','o','p'},
			{'q','r','s','t','u','v','w','x'},
			{'y','z','a','b','c','d','e','f'}
		};
		
		String vStrPalabra="ltb";
		
		if(Enunciado1.search(vChrLstLetras, vStrPalabra)) {
			System.out.println("La palabra: "+vStrPalabra+" fue encontrada en la matriz.");
		}else {
			System.out.println("La palabra: "+vStrPalabra+" no fue encontrada en la matriz.");
		}
	}
}
