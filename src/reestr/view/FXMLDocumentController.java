/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reestr.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import reestr.Reestr;
import reestr.model.info;
import util.DateUtil;

/**
 *
 * @author evgeniy
 */
public class FXMLDocumentController {

    @FXML
    private TableView<info> infoTable;
    @FXML
    private TableColumn<info, String> firstNameColumn;
    @FXML
    private TableColumn<info, String> lastNameColumn;
    @FXML
    private TableColumn<info, String> secondNameColumn;
    @FXML
    private TableColumn<info, String> serNameColumn;
    @FXML
    private TableColumn<info, String> numberNameColumn;

    @FXML
    private TextField tfWhom;
    @FXML
    private DatePicker dpDateIssue;
    @FXML
    private TextField tfCode;
    @FXML
    private TextField tfBirthPlace;
    @FXML
    private TextField tfAdressResident;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfCodeWord1;
    @FXML
    private TextField tfCodeWord2;
    @FXML
    private ChoiceBox<String> cbSex;
    @FXML
    private DatePicker dpdateBirth;
    @FXML
    private TextArea taadressFact;
    @FXML
    private TextArea taadressPostal;
    @FXML
    private CheckBox cbPdl;
    @FXML
    private TextField tfSnils;

    private ObservableList<String> polData = FXCollections.observableArrayList();

    private Reestr mainApp;

    public FXMLDocumentController() {
    }

    /**
     * initialize
     */
    @FXML
    private void initialize() {

        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        secondNameColumn.setCellValueFactory(cellData -> cellData.getValue().SecondNameProperty());
        serNameColumn.setCellValueFactory(cellData -> cellData.getValue().SerProperty());
        numberNameColumn.setCellValueFactory(cellData -> cellData.getValue().NumberProperty());

        polData.add("Мужской");
        polData.add("Женский");
        cbSex.setItems(polData);

        showInfoDetails(null);

        infoTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showInfoDetails(newValue));

    }

    public void setMainApp(Reestr mainApp) {

        this.mainApp = mainApp;

    }

    /**
     * showInfoDetails
     *
     * @param info
     */
    private void showInfoDetails(info info) {

        if (info != null) {

            tfWhom.setText(info.getpWhom());
            dpDateIssue.setValue(DateUtil.parse(info.getpDateIssue()));
            tfCode.setText(info.getpCode());
            tfBirthPlace.setText(info.getpBirthPlace());
            tfAdressResident.setText(info.getpAdressResident());
            tfTel.setText(info.gettel());
            tfCodeWord1.setText(info.getcodeWord1());
            tfCodeWord2.setText(info.getcodeWord2());
            if (info.getsex().equals("М")) {
                cbSex.setValue("Мужской");
            } else {
                cbSex.setValue("Женский");
            }
            dpdateBirth.setValue(DateUtil.parse(info.getdateBirth()));
            taadressFact.setText(info.getadressFact());
            taadressPostal.setText(info.getadressPostal());
            if (info.getpdl().equals("IPDL")) {
                cbPdl.setSelected(true);
            } else if (info.getpdl().equals("NOT_IPDL")) {
                cbPdl.setSelected(false);
            }
            tfSnils.setText(info.getsnils());

        } else {

            tfWhom.setText("");
            dpDateIssue.setValue(null);
            tfCode.setText("");
            tfBirthPlace.setText("");
            tfAdressResident.setText("");
            tfTel.setText("");
            tfCodeWord1.setText("");
            tfCodeWord2.setText("");
            cbSex.setValue("");
            dpdateBirth.setValue(null);
            taadressFact.setText("");
            taadressPostal.setText("");
            cbPdl.setSelected(false);
            tfSnils.setText("");
        }

    }

    @FXML
    private void loadInfoFromFile() {
        
        this.mainApp.loadInfoFromFile();
        infoTable.setItems(this.mainApp.getInfoData());
        infoTable.getSelectionModel().selectFirst();

    }
    
    @FXML
    private void toCft(){
        this.mainApp.toCft();
    }

}
