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
    private FXMLDocumentController FXMLDocumentController;

    public void setMainApp(Reestr mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void about() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("О программе");
        alert.setHeaderText("Обработка реестров");
        alert.setContentText("версия 1.2.1 от 26.05.2017");

        alert.showAndWait();
    }

    public void setFXMLDocumentController(FXMLDocumentController FXMLDocumentController) {
        this.FXMLDocumentController = FXMLDocumentController;
    }

    @FXML
    private void loadInfoFromFile() {
        this.FXMLDocumentController.ldInfofromfile();
    }

    @FXML
    private void chkfirstLevel() {
        this.FXMLDocumentController.chkFirstLevel();
    }

}
