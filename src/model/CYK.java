package model;

import java.util.ArrayList;

public class CYK {
		
	String[][] matriz;
	String[][]gramatica;
	public CYK() {
		
	}
	
	public String algoritmoCYK(String[][] gramatica, String[] cadena) {
		matriz= new String[cadena.length+1][cadena.length+1];
		this.gramatica=gramatica;
		for (int j = 0; j < cadena.length; j++) {
			matriz[j+1][0]=cadena[j];
			matriz[0][j+1]=(j+1)+"";
		}
		
		for (int j = 1; j < matriz.length; j++) {
			for (int i = 1; i < matriz[j].length; i++) {
				if(i==1) {
					matriz[j][i]=buscar(matriz[j][i-1]);	
				}
							
			}
		}
		calcularBusqueda(2,cadena.length);
		
		/*for (int j = 1; j < matriz.length; j++) {
			for (int i = 2; i < matriz.length; i++) {
				calcularBusqueda(i,cadena.length);
			}
		}*/
		
		for (int x=0; x < matriz.length; x++) {
			  System.out.print("|");
			  for (int y=0; y < matriz[x].length; y++) {
			    System.out.print (matriz[x][y]);
			    if (y!=matriz[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
		}
		return null;
	}
	
	public String buscar(String a) {
		String generadores="";
		for (int i = 0; i < gramatica.length; i++) {
			for (int j = 0; j < gramatica[i].length; j++) {
				if(gramatica[i][j].contentEquals(a)) {
					generadores +=gramatica[i][0]+",";
				}
			}			
		}
		if(generadores.equals("")) {
			return "vacio";
		}else {
			return generadores;
		}
		
	}
	
	public ArrayList<String> buscar(String[] a) {
		ArrayList<String> generadores=new ArrayList<String>();
		String cadena="";
		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < gramatica.length; i++) {
				for (int j = 0; j < gramatica[i].length; j++) {
					if(gramatica[i][j].contentEquals(a[k])) {
						cadena+=gramatica[i][j];
					}
				}
				generadores.add(cadena);
			}
		}
		return generadores;	
	}
	
	
	public void calcularBusqueda(int j, int n) {
		for (int i = 1; i <= (n-j+1); i++) {
			String caso="";
			int p=0;
			for (int k = 1; k <=(j-1); k++) {
				caso=matriz[i][k]+matriz[i+k][j-k];
				System.out.println(caso);
			}
			matriz[i][j]=buscar(caso);
		}
	}
	
}
