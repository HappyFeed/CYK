package ui;

import model.CYK;


public class Main {

	public static CYK flag;
	
	public static void main(String[] args) {
		flag= new CYK();
		String line ="bbab";
		String[] parts= line.split("");
		String[][] m= new String[4][3];
		m[0][0]= "S";
		m[1][0]= "A";
		m[2][0]= "B";
		m[3][0]= "C";
		m[0][1]= "BA";
		m[0][2]= "AC";
		m[1][1]= "CC";
		m[1][2]= "b";
		m[2][1]= "AB";
		m[2][2]= "a";
		m[3][1]= "BA";
		m[3][2]= "a";
		flag.algoritmoCYK(m, parts );
	}

}
