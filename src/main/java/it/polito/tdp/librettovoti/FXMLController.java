package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Libretto;
import Model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Integer> cmbPunti;

	@FXML
	private TextField txtNome;

	@FXML
	private TextArea txtVoti;

	@FXML
	void HandleNuovoVoto(ActionEvent event) {
		String nome = txtNome.getText();
		int punti = cmbPunti.getValue();
		model.add(new Voto(nome, punti));
		String contenutoLibretto = model.toString();
		txtVoti.setText(contenutoLibretto);
		
	}

	public void setModel(Libretto model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
		cmbPunti.getItems().clear();
		for (int i = 18; i <= 30; i++) {
			cmbPunti.getItems().add(i);
		}
	}

}
