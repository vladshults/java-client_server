/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author student
 */
public class GridPaneController implements Initializable {

    @FXML
    private void btnFindClickAction(ActionEvent event){
        System.out.println("Find!");
    }
    
    @FXML
    public void btnCancelClickAction(ActionEvent event) {
        System.out.println("You clicked Cancel!");
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //;
    }    
    
}
