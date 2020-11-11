package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.CYK;

public class MenuController {

	CYK algoritmo;
	
    @FXML
    private TextArea areaGramatica;

    @FXML
    private TextField palabra;

    @FXML
    private Button buttonGenerar;

    @FXML
    private ImageView picRespuesta;

    @FXML
    private TextField tamañoGramatica;

    
    @FXML
    void calcularCYK(ActionEvent event) throws IOException {
    	algoritmo = new CYK();
    	String gr= areaGramatica.getText();
    	String[] gramatica = gr.split("\n");
    	int tamaño= Integer.parseInt(tamañoGramatica.getText());
    	String[][] gramaticaMatriz = new String[gramatica.length][tamaño];
    	for (int i = 0; i < gramatica.length; i++) {
			String[] fila= gramatica[i].split(",");
			for (int j = 0; j < fila.length; j++) {
				gramaticaMatriz[i][j]= fila[j];
			}
		}
    	String word= palabra.getText();
    	String[] symbols = word.split("");
    	algoritmo.algoritmoCYK(gramaticaMatriz, symbols);
    }

}
