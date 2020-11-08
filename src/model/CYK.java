package model;

public class CYK {
		
	String[][] matriz;
	
	public CYK() {
		
	}
	
	public String algoritmoCYK(String[][] gramatica, String[] cadena) {
		matriz= new String[cadena.length][cadena.length];
		for (int j = 0; j < matriz.length; j++) {
			matriz[j][0]=cadena[j];
			matriz[0][j]=j+"";
		}
		
		for (int j = 1; j < matriz.length; j++) {
			for (int i = 1; i < matriz[j].length; i++) {
				if(i==1) {
					matriz[j][i]=primerPaso(matriz[j][i-1],gramatica);
				}
			}
		}
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
	
	public String primerPaso(String a, String[][] gramatica) {
		String generadores="{";
		for (int i = 0; i < gramatica.length; i++) {
			for (int j = 0; j < gramatica[i].length; j++) {
				if(gramatica[i][j].contentEquals(a)) {
					generadores +=gramatica[i][0]+",";
				}
			}			
		}
		return generadores+"}";
	}
	
}
