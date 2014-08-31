/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebapantallaspv;

import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reportes.Alumno;


/**
 *
 * @author Ignacio
 */
public class PruebaPantallasPV extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        try{
        JasperReport reporte;    
        File file =new File("../reportes/report1.jasper");
            reporte = (JasperReport)JRLoader.loadObject(file);
            Map parametros = new HashMap();
            Alumno miAlumno = new Alumno();
            miAlumno.setNombre("Ignacio");
            miAlumno.setApellido("Hernández");
            miAlumno.setTelefono("2464636960");
            parametros.put("Nombre",miAlumno.getNombre());
            parametros.put("Apellido",miAlumno.getApellido());
            parametros.put("Telefono",miAlumno.getTelefono());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,new JREmptyDataSource());
            JasperViewer view = new JasperViewer(jasperPrint);
            view.setTitle("Ejemplo");
            view.setVisible(true);
            
        }
        catch(Exception e)
        {
            System.err.println("Error jasper "+e.getMessage());
        }
        
    }
    
}
