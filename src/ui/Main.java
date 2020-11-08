package ui;

import model.CYK;


public class Main {

	public static CYK flag;
	
	public static void main(String[] args) {
		flag= new CYK();
		String line ="aabb";
		String[] parts= line.split("");
		String[][] m= new String[3][3];
		m[0][0]= "S";
		m[1][0]= "A";
		m[2][0]= "B";
		m[0][1]= "BA";
		m[0][2]= "a";
		m[1][1]= "B";
		m[1][2]= "a";
		m[2][1]= "A";
		m[2][2]= "b";
		flag.algoritmoCYK(m, parts );
	}

}
