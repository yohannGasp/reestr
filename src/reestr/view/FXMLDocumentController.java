/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reestr.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    int CountRowInfoTable;

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
        
        infoTable.getItems().remove(0, infoTable.getItems().size());

        this.mainApp.loadInfoFromFile();
        infoTable.setItems(this.mainApp.getInfoData());
        infoTable.getSelectionModel().selectFirst();

    }

    private boolean checkFields(info info) {
        boolean result = false;

        /**
         * Фамилия Имя Серия паспорта Номер паспорта Дата выдачи паспорта Орган
         * выдавший паспорт
         */
        if (!"".equals(info.getLastName())
                && !"".equals(info.getFirstName())
                && !"".equals(info.getSer())
                && !"".equals(info.getNumber())
                && !"".equals(info.getpDateIssue())
                && !"".equals(info.getpWhom())) {
            result = true;
        }

        return result;
    }

    @FXML
    private void toCft() {
        this.mainApp.toCft();
    }

    @FXML
    private void checkFirstLevel() {

        if (infoTable.getItems().size() > 0) {

            String dir = this.mainApp.getParentDir() + File.separator + "checkFirstLevel";
            if (!new File(dir).exists()) {
                new File(dir).mkdir();
            }

            File file_r1 = new File(dir + File.separator + "good_reestr.txt");
            File file_r2 = new File(dir + File.separator + "bad_reestr.txt");
            File file_pr = new File(dir + File.separator + "protokol.txt");

            try (FileWriter goodReestr = new FileWriter(file_r1, false);
                    FileWriter badReestr = new FileWriter(file_r2, false);
                    FileWriter protokol = new FileWriter(file_pr, false);) {

                protokol.write("===================================================================================" + System.lineSeparator());
                protokol.write("НАЧАЛО ПРОВЕРКИ ПЕРВОГО УРОВНЯ                                                     " + System.lineSeparator());
                protokol.write("===================================================================================" + System.lineSeparator());

                goodReestr.write("Табельный номер;Фамилия;Имя;Отчество;Пол клиента;Фамилия на карте;Имя на карте;Дата рождения;Место рождения;Код страны гражданства;Место регистрации. Код страны адреса;Место регистрации. Почтовый индекс;Место регистрации. Код субъекта РФ;Место регистрации. Район субъекта РФ;Место регистрации. Город;Место регистрации. Населенный пункт;Место регистрации. Улица;Место регистрации. Дом;Место регистрации. Корпус;Место регистрации. Квартира;Код страны адреса;Почтовый индекс;Код субъекта РФ адреса;Район субъекта РФ адреса;Город;Населенный пункт;Улица;Дом;Корпус;Квартира;Телефон;Мобильный телефон;Код типа документа;Серия документа;Номер удостоверения;Дата выдачи документа;Кем выдан документ;Резидент;Документ, подтверждающий право пребывания на территории РФ;Данные миграционной карты;Кодовое слово;Дата приема на работу;СНИЛС;Средний оклад сотрудника за последние 3 месяца;Дополнительная услуга;Подключить дополнительные услуги; Принадлежность ПДЛ" + System.lineSeparator());
                badReestr.write("Табельный номер;Фамилия;Имя;Отчество;Пол клиента;Фамилия на карте;Имя на карте;Дата рождения;Место рождения;Код страны гражданства;Место регистрации. Код страны адреса;Место регистрации. Почтовый индекс;Место регистрации. Код субъекта РФ;Место регистрации. Район субъекта РФ;Место регистрации. Город;Место регистрации. Населенный пункт;Место регистрации. Улица;Место регистрации. Дом;Место регистрации. Корпус;Место регистрации. Квартира;Код страны адреса;Почтовый индекс;Код субъекта РФ адреса;Район субъекта РФ адреса;Город;Населенный пункт;Улица;Дом;Корпус;Квартира;Телефон;Мобильный телефон;Код типа документа;Серия документа;Номер удостоверения;Дата выдачи документа;Кем выдан документ;Резидент;Документ, подтверждающий право пребывания на территории РФ;Данные миграционной карты;Кодовое слово;Дата приема на работу;СНИЛС;Средний оклад сотрудника за последние 3 месяца;Дополнительная услуга;Подключить дополнительные услуги; Принадлежность ПДЛ" + System.lineSeparator());

                infoTable.getSelectionModel().selectFirst(); // встаем на первую
                Iterator<info> iterator = infoTable.getItems().iterator();
                while (iterator.hasNext()) {

                    info next = iterator.next();
                    infoTable.getSelectionModel().select(next); // визуально выделяем 

                    // 1. проверить полей
                    boolean flagCheck = checkFields(next);

                    if (flagCheck) {
                        protokol.write(next.getLastName() + " " + next.getFirstName() + " " + next.getSecondName() + " " + next.getSer() + " " + next.getNumber() + " Проверка полей: успешно" + System.lineSeparator());
                    } else {
                        protokol.write(next.getLastName() + " " + next.getFirstName() + " " + next.getSecondName() + " " + next.getSer() + " " + next.getNumber() + " Проверка полей: НЕ ЗАПОЛНЕНЫ ПОЛЯ" + System.lineSeparator());
                    }

                    // 2. проверить пасп
                    String res = this.mainApp.checkPassport(next.getSer(), next.getNumber());

                    if ("1".equals(res)) {
                        protokol.write(next.getLastName() + " " + next.getFirstName() + " " + next.getSecondName() + " " + next.getSer() + " " + next.getNumber() + " Проверка паспорта: успешно" + System.lineSeparator());
                    } else {
                        protokol.write(next.getLastName() + " " + next.getFirstName() + " " + next.getSecondName() + " " + next.getSer() + " " + next.getNumber() + " Проверка паспорта: Внимание паспорт в списке недействительных паспортов !!!" + System.lineSeparator());
                    }

                    //write reestrs
                    if (flagCheck && "1".equals(res)) {
                        goodReestr.write(next.getSrcString() + System.lineSeparator());
                    } else {
                        badReestr.write(next.getSrcString() + System.lineSeparator());
                    }

                }

                protokol.write("===================================================================================" + System.lineSeparator());
                protokol.write("ОКОНЧАНИЕ ПРОВЕРКИ ПЕРВОГО УРОВНЯ                                                  " + System.lineSeparator());
                protokol.write("===================================================================================" + System.lineSeparator());

            } catch (IOException ex) {

                System.out.println("checkPassport: " + ex.toString());
            }

            this.mainApp.closeDb();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.mainApp.getPrimaryStage());
            alert.setTitle("Info");
            alert.setHeaderText("info");
            alert.setContentText("Проверки выполнены");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(this.mainApp.getPrimaryStage());
            alert.setTitle("Info");
            alert.setHeaderText("info");
            alert.setContentText("Пустой реестр");
            alert.showAndWait();
        }

    }

    /**
     * chkFirstLevel
     */
    public void chkFirstLevel() {
        this.checkFirstLevel();
    }

    /**
     * ldInfofromfile
     */
    public void ldInfofromfile() {
        this.loadInfoFromFile();
    }

}
