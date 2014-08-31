/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebapantallaspv;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilidades.persona;

/**
 * FXML Controller class
 *
 * @author Ignacio
 */
public class Prueba2Controller implements Initializable {
    @FXML
    private Label texto;
    
    private persona persona;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }   
    public void setPersona(persona persona)
    {
        this.persona=persona;
        texto.setText(this.persona.getNombre());
        
        
    }
    
}
