/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reestr.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
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
    private TableColumn<info, String> fieldColumn;
    @FXML
    private TableColumn<info, String> chkPasspColumn;

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
    @FXML
    private ProgressBar pbProgress;

    private ObservableList<String> polData = FXCollections.observableArrayList();

    private Reestr mainApp;

    int CountRowInfoTable;
    info currentInfo;

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
        fieldColumn.setCellValueFactory(cellData -> cellData.getValue().fieldProperty());
        chkPasspColumn.setCellValueFactory(cellData -> cellData.getValue().chkPspProperty());

        polData.add("Мужской");
        polData.add("Женский");
        cbSex.setItems(polData);

        showInfoDetails(null);

        infoTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showInfoDetails(newValue));

        fieldColumn.setCellFactory(column -> {
            return new TableCell<info, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                    } else {

                        setText(item);
                        info info = getTableView().getItems().get(getIndex());

                        if (info.getfield().equals("NOT")) {
                            setStyle("-fx-background-color: red");
                        } else {
                            setStyle("-fx-background-color: inherit");
                        }

                    }
                }
            };
        });

        chkPasspColumn.setCellFactory(column -> {
            return new TableCell<info, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                    } else {

                        setText(item);
                        info info = getTableView().getItems().get(getIndex());

                        if (info.getchkPsp().equals("NOT")) {
                            setStyle("-fx-background-color: red");
                        } else {
                            setStyle("-fx-background-color: inherit");
                        }

                    }
                }
            };
        });

        pbProgress.setProgress(0.0);

    }

    /**
     * increment progress bar
     */
    public void incPb() {

        double delta = (double) 1 / this.CountRowInfoTable;
        pbProgress.setProgress(pbProgress.getProgress() + delta);
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
                cbPdl.setVisible(true);
                cbPdl.setSelected(true);
            } else if (info.getpdl().equals("NOT_IPDL")) {
                cbPdl.setVisible(true);
                cbPdl.setSelected(false);
            } else if ("".equals(info.getpdl())) {
                cbPdl.setVisible(false);
            }
            System.out.println(info.getpdl());
            tfSnils.setText(info.getsnils());

            this.currentInfo = info;

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

        infoTable.getItems().clear();
        infoTable.refresh();
        pbProgress.setProgress(0.0);

        this.mainApp.loadInfoFromFile();
        infoTable.setItems(this.mainApp.getInfoData());
        infoTable.getSelectionModel().selectFirst();

        this.CountRowInfoTable = infoTable.getItems().size();

    }

    private String checkFields(info info) {
        String result = "false";

        if (!"".equals(info.getLastName())
                && !"".equals(info.getFirstName())
                && !"".equals(info.getSecondName())
                && !"".equals(info.getSer())
                && !"".equals(info.getNumber())
                && !"".equals(info.getpDateIssue())
                && !"".equals(info.getpWhom())) {
            result = "true";
        } else {
            result += "".equals(info.getLastName()) ? "Фамилия, " : "";
            result += "".equals(info.getFirstName()) ? "Имя, " : "";
            result += "".equals(info.getSecondName()) ? "Отчество, " : "";
            result += "".equals(info.getSer()) ? "Серия паспорта, " : "";
            result += "".equals(info.getNumber()) ? "Номер паспорта, " : "";
            result += "".equals(info.getpDateIssue()) ? "Дата выдачи паспорта, " : "";
            result += "".equals(info.getpWhom()) ? "Орган выдавший паспорт, " : "";
        }

        return result;
    }

    @FXML
    private void toCft() throws FileNotFoundException {

        // 1. save info
        this.currentInfo.setpWhom(tfWhom.getText());
        this.currentInfo.setpDateIssue(DateUtil.format(dpDateIssue.getValue()));
        this.currentInfo.setpCode(tfCode.getText());
        this.currentInfo.setpBirthPlace(tfBirthPlace.getText());
        this.currentInfo.setppAdressResident(tfAdressResident.getText());
        this.currentInfo.settel(tfTel.getText());
        this.currentInfo.setcodeWord1(tfCodeWord1.getText());
        this.currentInfo.setcodeWord2(tfCodeWord2.getText());

        if (cbSex.getValue().equals("Мужской")) {
            this.currentInfo.setsex("М");
        } else {
            this.currentInfo.setsex("Ж");
        }

        this.currentInfo.setdateBirth(DateUtil.format(dpdateBirth.getValue()));
        this.currentInfo.setadressFact(taadressFact.getText());
        this.currentInfo.setadressPostal(taadressPostal.getText());

        if (cbPdl.isSelected()) {
            this.currentInfo.setpdl("IPDL");
        } else {
            this.currentInfo.setpdl("NOT_IPDL");
        }

        this.currentInfo.setsnils(tfSnils.getText());

        // 2. save to file
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.mainApp.currentFile), "cp1251"))) {

            bw.write("header\n");

            Iterator<info> iterator = infoTable.getItems().iterator();
            while (iterator.hasNext()) {
                info next = iterator.next();

                String[] arrLine = next.getSrcString().split(";");

                StringBuilder sb = new StringBuilder();

                sb.append(arrLine[0].concat(";"));
                sb.append(next.getLastName().concat(";"));
                sb.append(next.getFirstName().concat(";"));
                sb.append(next.getSecondName().concat(";"));
                sb.append(next.getsex().concat(";"));
                sb.append(arrLine[5].concat(";"));
                sb.append(arrLine[6].concat(";"));
                sb.append(next.getdateBirth().concat(";"));
                sb.append(next.getpBirthPlace().concat(";"));
                sb.append(arrLine[9].concat(";"));
                sb.append(arrLine[10].concat(";"));
                sb.append(arrLine[11].concat(";"));
                sb.append(arrLine[12].concat(";"));
                sb.append(arrLine[13].concat(";"));
                sb.append(arrLine[14].concat(";"));
                sb.append(arrLine[15].concat(";"));
                sb.append(arrLine[16].concat(";"));
                sb.append(arrLine[17].concat(";"));
                sb.append(arrLine[18].concat(";"));
                sb.append(arrLine[19].concat(";"));
                sb.append(arrLine[20].concat(";"));
                sb.append(arrLine[21].concat(";"));
                sb.append(arrLine[22].concat(";"));
                sb.append(arrLine[23].concat(";"));
                sb.append(arrLine[24].concat(";"));
                sb.append(arrLine[25].concat(";"));
                sb.append(arrLine[26].concat(";"));
                sb.append(arrLine[27].concat(";"));
                sb.append(arrLine[28].concat(";"));
                sb.append(arrLine[29].concat(";"));
                sb.append(arrLine[30].concat(";"));
                sb.append(next.gettel().concat(";"));
                sb.append(arrLine[32].concat(";"));
                sb.append(next.getSer().concat(";"));
                sb.append(next.getNumber().concat(";"));
                sb.append(next.getpDateIssue().concat(";"));
                sb.append(next.getpWhom().concat(";"));
                sb.append(arrLine[37].concat(";"));
                sb.append(arrLine[38].concat(";"));
                sb.append(arrLine[39].concat(";"));
                sb.append(next.getcodeWord1().concat(";"));
                sb.append(arrLine[41].concat(";"));
                sb.append(next.getsnils().concat(";"));

                bw.write(sb.toString() + System.lineSeparator());

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 3. save to cft
        //this.mainApp.toCft();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(this.mainApp.getPrimaryStage());
        alert.setTitle("Info");
        alert.setHeaderText("info");
        alert.setContentText("Данные сохранены");
        alert.showAndWait();

    }

    @FXML
    private void checkFirstLevel() {

        int countFl = 0;
        int countPs = 0;
        int countAll = 0;

        if (infoTable.getItems().size() > 0) {

            String dir = this.mainApp.getParentDir() + File.separator + "checkFirstLevel";
            if (!new File(dir).exists()) {
                new File(dir).mkdir();
            }

            File file_r1 = new File(dir + File.separator + "OK_" + this.mainApp.currentFile.getName());
            File file_r2 = new File(dir + File.separator + "BAD_" + this.mainApp.currentFile.getName());
            File file_pr = new File(dir + File.separator + "LOG_" + this.mainApp.currentFile.getName());

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
                    incPb();
                    countAll++;

                    // 1. проверка полей
                    String flagCheck = checkFields(next);

                    if (flagCheck.equals("true")) {
                        protokol.write(next.getLastName() + " " + next.getFirstName() + " " + next.getSecondName() + " " + next.getSer() + " " + next.getNumber() + " Проверка полей: успешно;");
                        next.setfield("ok");
                    } else {
                        String spl = flagCheck.substring(5);
                        protokol.write(next.getLastName() + " " + next.getFirstName() + " " + next.getSecondName() + " " + next.getSer() + " " + next.getNumber() + " Проверка полей: НЕ ЗАПОЛНЕНЫ ПОЛЯ - " + spl + ";");
                        next.setfield("NOT");
                        countFl++;
                    }

                    // 2. проверка пасп
                    String res;
                    if (!"".equals(next.getSer()) && !"".equals(next.getNumber())) {
                        res = this.mainApp.checkPassport(next.getSer(), next.getNumber());
                    } else {
                        res = "-1";
                    }

                    if ("1".equals(res)) {
                        protokol.write("Проверка паспорта: успешно" + System.lineSeparator());
                        next.setchkPsp("ok");
                    }
                    if ("-1".equals(res)) {
                        protokol.write("Проверка паспорта: Для проверки необходимо серию и номер документа" + System.lineSeparator());
                    }
                    if ("0".equals(res)) {
                        protokol.write("Проверка паспорта: Внимание паспорт в списке недействительных паспортов !!! " + System.lineSeparator());
                        next.setchkPsp("NOT");
                        countPs++;
                    }

                    //write reestrs
                    if (flagCheck.equals("true") && "1".equals(res)) {
                        goodReestr.write(next.getSrcString() + System.lineSeparator());
                    } else {
                        badReestr.write(next.getSrcString() + System.lineSeparator());
                    }
                    
                    //to msword
                    
                    /**
                     * Тип карты ставим Classic счет не заполняем. 
                     * Сохраняем там же, где хороший реестр с префиксом pril5_
                     * 
                     */

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
            alert.setContentText("Проверки выполнены" + System.lineSeparator() + System.lineSeparator()
                    + "Всего записей в реестре: " + countAll + System.lineSeparator()
                    + "Не прошло проверку обязательных полей: " + countFl + System.lineSeparator()
                    + "Не прошло проверку паспорта: " + countPs);
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
