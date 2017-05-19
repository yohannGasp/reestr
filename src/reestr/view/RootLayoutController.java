/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reestr.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import reestr.Reestr;

/**
 *
 * @author evgeniy
 */
public class RootLayoutController {

    private Reestr mainApp;

    public void setMainApp(Reestr mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void about() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("О программе");
        alert.setHeaderText("Обработка реестров");
        alert.setContentText("версия 1.0 от 18.05.2017");

        alert.showAndWait();
    }

    @FXML
    private void loadInfoFromFile() {

        

    }

}
