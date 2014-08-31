/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebapantallaspv;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import utilidades.persona;

/**
 *
 * @author Ignacio
 */
public class PrincipalController implements Initializable {
    
    @FXML
    private TableView<persona> tabla;
    @FXML
    private TableColumn clmNombre;
    @FXML
    private TableColumn clmApellido;
    @FXML
    private TableColumn clmEdad;
    @FXML
    private TableColumn clmTelefono;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private Button btnAnadir;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnNuevo;
    
    private ObservableList<persona> miLista;
    private ObservableList<persona> miListaCombo;
    private int posicionSelecionada;
    private ComboBox<persona> cmbxCombo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        clmNombre.setCellValueFactory(new PropertyValueFactory<persona,String>("nombre"));
        clmApellido.setCellValueFactory(new PropertyValueFactory<persona,String>("Apellido"));
        clmEdad.setCellValueFactory(new PropertyValueFactory<persona,String>("Edad"));
        clmTelefono.setCellValueFactory(new PropertyValueFactory<persona,String>("Telefono"));
        miLista= FXCollections.observableArrayList();
        tabla.setItems(miLista);
        
        //Llenar combo
//        miListaCombo = FXCollections.observableArrayList();
//        cmbxCombo.setItems(miListaCombo);
//        cmbxCombo.setPromptText("Seleccione uno");
//        
        
        
    }    

    @FXML
    private void handleButtonAnadirAction(ActionEvent event) {
        persona miPersona = new persona(txtNombre.getText(), txtApellido.getText(), txtEdad.getText(), txtTelefono.getText());
        miLista.add(miPersona);
        miListaCombo.add(miPersona);
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
    }

    @FXML
    private void handleButtonModificarAction(ActionEvent event) {
        persona miPerson =tabla.getSelectionModel().getSelectedItem();
        txtNombre.setText(miPerson.getNombre());
        txtApellido.setText(miPerson.getApellido());
        txtEdad.setText(miPerson.getEdad());
        txtTelefono.setText(miPerson.getTelefono());
        
    }

    @FXML
    private void handleButtonEliminarAction(ActionEvent event) {
        miLista.remove(tabla.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void handleButtonNuevoAction(ActionEvent event) {
        try
        {
            txtApellido.requestFocus();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prueba2.fxml")); 
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setMaximized(true);
        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("");
Parent root = (Parent) fxmlLoader.load();   
Prueba2Controller miController = (Prueba2Controller)fxmlLoader.getController();
Scene scene = new Scene(root);
stage.setScene(scene);    
stage.show();
        }
        catch(Exception e){}
        
        
    }

    private void ComboListener(ActionEvent event) {
        Action response = Dialogs.create()
        .owner(new Stage())
        .title("Envío")
        .masthead("Mandar a la otra ventana esta persona?")
        .message(cmbxCombo.getSelectionModel().getSelectedItem().getNombre())
        .showConfirm();

if (response == Dialog.Actions.YES) {
    try
    {    

FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prueba2.fxml"));      
//Modo inicio de sesion
/*
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prueba2.fxml"));     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prueba2.fxml"));     
Node node = (Node) event.getSource();
//Stage para remplazar lo que está   en la otra ventana
    Stage stage = (Stage) node.getScene().getWindow();
    Scene scene = stage.getScene();
    Parent root = (Parent) fxmlLoader.load();          
    scene.setRoot(root);

*/

Stage stage = new Stage();
Parent root = (Parent) fxmlLoader.load();   
Prueba2Controller miController = (Prueba2Controller)fxmlLoader.getController();
miController.setPersona(cmbxCombo.getSelectionModel().getSelectedItem());
Scene scene = new Scene(root);
stage.setScene(scene);    
stage.show();


    
    
    }
    catch(Exception e)
    {
        
    }
        
        
} else {
    // ... user chose NO, CANCEL, or closed the dialog
}

    }

    
}
