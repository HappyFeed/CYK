package model;

import java.util.ArrayList;

/**
* 
* The CYK program implements the CYK algorithm to check if a word
* is generated by a grammar that is in FNC
*
* @authors  Jose David Jimenez & Alejandro Martinez
* @version 1.0
* @since   2020-11-15	
*/
public class CYK {
		
	String[][] matriz;
	String[][]gramatica;
	public CYK() {
		
	}
	
	/**
	   * This method is used to check if the grammar generates the string
	   * @param gramatica This is the grammar that we are going to use
	   * @param cadena  This string is the one we will use to see if it is generated
	   * @return boolean This is a logical value indicating whether it generates it or not
	 */
	
	public boolean algoritmoCYK(String[][] gramatica, String[] cadena) {
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
		
		for (int j = 1; j < matriz.length; j++) {
			for (int i = 2; i < matriz.length; i++) {
				calcularBusqueda(i,cadena.length);
			}
		}
		
		/*for (int x=0; x < matriz.length; x++) {
			  System.out.print("|");
			  for (int y=0; y < matriz[x].length; y++) {
			    System.out.print (matriz[x][y]);
			    if (y!=matriz[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
		}*/
		
		if(matriz[1][matriz.length-1].contains("S")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/**
	   * This method looks for what symbols generate the string that arrives
	   * @param a It is the string sent to verify if it is generated
	   * @return String This is the symbol that generates the string
	 */
	public String buscar(String a) {
		String generadores="";
		for (int i = 0; i < gramatica.length; i++) {
			for (int j = 1; j < gramatica[i].length; j++) {
				if(gramatica[i][j]!=null&&gramatica[i][j].contentEquals(a)) {
					generadores +=gramatica[i][0]+"";
				}
			}			
		}
		if(generadores.equals("")) {
			return "vacio";
		}else {
			return generadores;
		}
		
	}
	
	/**
	   * This method looks for what symbols generate the string that arrives
	   * @param a It is the string sent in the form of an array to verify if it is generated
	   * @return String This is the symbol that generates the string
	 */
	public String buscar(ArrayList<String> a) {
		String newCad = "";
		ArrayList<String> s= new ArrayList<String>();
		for (int k = 0; k < a.size(); k++) {
			for (int i = 0; i < gramatica.length; i++) {
				for (int j = 0; j < gramatica[i].length; j++) {
					if(gramatica[i][j]!=null&&gramatica[i][j].contentEquals(a.get(k))) {
						boolean flag=true;
						for (int j2 = 0; j2 < s.size(); j2++) {
							if(s.get(j2).equals(gramatica[i][0])) {
								flag=false;
							}
						}
						if(flag==true) {
							s.add(gramatica[i][0]);
						}
						
					}
				}
			}
		}
		for (int i = 0; i < s.size(); i++) {
			newCad+=s.get(i);
		}
		if(newCad.equals("")) {
			return "vacio";
		}else {
			return newCad;
		}	
	}
	
	/**
	   * This method uses the formula to calculate what symbols are
	   * @param j This is the first paramter to calcularBusqueda method
	   * @param n This is the second paramter to calcularBusqueda method
	 */
	public void calcularBusqueda(int j, int n) {
		for (int i = 1; i <= (n-j+1); i++) {
			String caso="";
			ArrayList<String> casos= new ArrayList<String>();
			int p=0;
			for (int k = 1; k <=(j-1); k++) {
				if(matriz[i][k].length()>1 && matriz[i+k][j-k].length()==1) {
					String[]combi=matriz[i][k].split("");
					for (int k2 = 0; k2 < combi.length; k2++) {
						casos.add(combi[k2]+matriz[i+k][j-k]);
					}
				}else if(matriz[i][k].length()==1 && matriz[i+k][j-k].length()>1) {
					String[]combi=matriz[i+k][j-k].split("");
					for (int k2 = 0; k2 < combi.length; k2++) {
						casos.add(matriz[i][k]+combi[k2]);
					}
				}else if(matriz[i][k].length()>1 && matriz[i+k][j-k].length()>1) {
					String[]combi=matriz[i+k][j-k].split("");
					String[]combi2=matriz[i][k].split("");
					for (int k2 = 0; k2 < combi.length; k2++) {
						for (int l = 0; l < combi2.length; l++) {
							casos.add(combi2[l]+combi[k2]);
						}
					}
				}else {
					casos.add(matriz[i][k]+matriz[i+k][j-k]);
				}
				
				
			}
			matriz[i][j]=buscar(casos);
		}
	}
	
}
