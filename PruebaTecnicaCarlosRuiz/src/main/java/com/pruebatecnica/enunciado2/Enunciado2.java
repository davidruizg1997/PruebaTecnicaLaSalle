package com.pruebatecnica.enunciado2;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("search-horandvert")
public class Enunciado2 {
	
	//Busqueda de palabra en la matriz
	@POST
	@Path("/{searchword}/{rows}/{word}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response search(@PathParam("searchword") String searchword, @PathParam("rows") int rows, @PathParam("word") String word) {
		
		searchword="abcdefghijklmnopqrstuvwxyzabcdef";
		rows = 4;
		
		//Instancia de variables
		int vIntLetrasIniciales = searchword.length();
		int vIntContadorLetras=0;
		int vIntLetrasFila = vIntLetrasIniciales/rows;
		int vIntLetrasPalabra = word.length();
		int vIntFilaActual;
		int vIntColumnaActual;
		int vIntFilaInicial;
		int vIntColumnaInicial;
		char vChrPrimeraLetraWord = word.charAt(0);
		boolean vBoolCaracteresEncontrados=false;
		String vStrJson="";
		char [][]matrix = new char[rows][vIntLetrasFila];
		
		for(int vIntFilaMatrix=0; vIntFilaMatrix<=rows;vIntFilaMatrix++) {
			for(int vIntColumnaMatrix=0; vIntColumnaMatrix<=vIntLetrasFila;vIntColumnaMatrix++) {
				if(vIntLetrasIniciales<=vIntLetrasIniciales) {
					matrix[vIntFilaMatrix][vIntColumnaMatrix]=searchword.charAt(vIntContadorLetras);
					vIntContadorLetras = vIntContadorLetras+1;
				}else {
					break;
				}
			}
		}
		
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
					vIntFilaInicial=-1;
					vIntColumnaInicial=-1;
						
					//Recorrido y validación letra por letra de la palabra con letras de la matriz de manera horizontal
					for(int vIntIndiceCaracter=0; vIntIndiceCaracter<vIntLetrasPalabra;vIntIndiceCaracter++) {
						if(vIntFilaActual>=matrix.length || vIntColumnaActual>=matrix[vIntFilaActual].length || matrix[vIntFilaActual][vIntColumnaActual]!=word.charAt(vIntIndiceCaracter)) {
							vBoolCaracteresEncontrados = false;
							break;
						}else {
							if(vIntFilaInicial==-1 && vIntColumnaInicial==-1) {
								vIntFilaInicial = vIntFilaActual;
								vIntColumnaInicial = vIntColumnaActual;
							}
							vIntColumnaActual = vIntColumnaActual+1;
							vBoolCaracteresEncontrados = true;
						}
					}
						
					if(vBoolCaracteresEncontrados==true) {
						vStrJson = "{\"searchword\":\""+searchword+"\",\"rows\":\""+Integer.toString(rows)+"\",\"word\":\""+word+"\",\"contains\":\""+Boolean.toString(vBoolCaracteresEncontrados)+"\",\"start_row\":\""+Integer.toString(vIntFilaInicial)+"\",\"start_col\":\""+Integer.toString(vIntColumnaInicial)+"\"}";
						break;
					}
						
					//Busqueda vertical de la palabra
					vIntFilaActual = vIntFila;
					vIntColumnaActual = vIntColumna;
					vBoolCaracteresEncontrados = false;
					vIntFilaInicial=-1;
					vIntColumnaInicial=-1;
						
					//Recorrido y validación letra por letra de la palabra con letras de la matriz de manera vertical
					for(int vIntIndiceCaracter=0; vIntIndiceCaracter<vIntLetrasPalabra;vIntIndiceCaracter++) {
						if(vIntFilaActual>=matrix.length || vIntColumnaActual>=matrix[vIntFilaActual].length || matrix[vIntFilaActual][vIntColumnaActual]!=word.charAt(vIntIndiceCaracter)) {
							vBoolCaracteresEncontrados = false;
							break;
						}else {
							if(vIntFilaInicial==-1 && vIntColumnaInicial==-1) {
								vIntFilaInicial = vIntFilaActual;
								vIntColumnaInicial = vIntColumnaActual;
							}
							vIntFilaActual = vIntFilaActual+1;
							vBoolCaracteresEncontrados = true;
						}
					}
						
					//Validación para confirmar que se encontro la palabra
					if(vBoolCaracteresEncontrados==true) {
						vStrJson = "{\"searchword\":\""+searchword+"\",\"rows\":\""+Integer.toString(rows)+"\",\"word\":\""+word+"\",\"contains\":\""+Boolean.toString(vBoolCaracteresEncontrados)+"\",\"start_row\":\""+Integer.toString(vIntFilaInicial)+"\",\"start_col\":\""+Integer.toString(vIntColumnaInicial)+"\"}";
						break;
					}
				}
			}
		}
		
		if(vBoolCaracteresEncontrados==false) {
			vStrJson = "{\"searchword\":\""+searchword+"\",\"rows\":\""+Integer.toString(rows)+"\",\"word\":\""+word+"\",\"contains\":\""+Boolean.toString(vBoolCaracteresEncontrados)+"\"}";
		}
		
		return Response.ok(vStrJson, MediaType.APPLICATION_JSON).build();
	}
}
