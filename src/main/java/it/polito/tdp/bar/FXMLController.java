/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import it.polito.tdp.bar.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void handleSimula(ActionEvent event) {
    	txtResult.clear();
    	
    	model.run();
    	
    	Statistiche stat = this.model.getStatistiche();
    	
    	txtResult.appendText("Numero totale clienti: "+stat.getNumero_totale_clienti()+"\nNumero clienti soddisfatti: "+stat.getNumero_clienti_soddisfatti()+"\nNumero clienti insoddisfatti: "+stat.getNumero_clienti_insoddisfatti()+"\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
