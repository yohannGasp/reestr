package reestr;

import DAO.DB;
import DAO.serviceDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import reestr.model.info;
import reestr.view.FXMLDocumentController;
import reestr.view.RootLayoutController;

/**
 * Made on the basis of code.makery.ch/library/javafx-8-tutorial/ru/part1/
 *
 * @author evgeniy
 */
public class Reestr extends Application {

    private serviceDAO serviceDAO;
    private DB db;
    private static final String connectionString = "YR3oJGx4TwrKhHuMuamMHmmfORDLsJ2fa7eL7Xx/wJv1DQV2cf8DuVPDvf6QB178";
    private static final String userCft = "rWwm5KsgumCmyBzLBsdBTw==";
    private static final String passwordCft = "XpXUcBBYASd/kzwvM1b/eA==";

    //переделать курсы, чтобы чипер расшифровывал на лету, а не пароль в открытом виде
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane infoOverview;

    private String login = null;
    private String psw = null;

    private String parentDir;
    private File lastDir = null;
    public File currentFile;

    private ObservableList<info> infoData = FXCollections.observableArrayList();

    public Reestr() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("view/FXMLDocument.fxml"));
        infoOverview = (AnchorPane) loader1.load();

        rootLayout.setCenter(infoOverview);

        Scene scene = new Scene(rootLayout);

        this.primaryStage = primaryStage;

        primaryStage.setTitle("Reestr");
        primaryStage.getIcons().add(new Image("file:resources/images/Address_Book.ico"));
        primaryStage.setScene(scene);
        primaryStage.show();

        RootLayoutController rootController = loader.getController();
        rootController.setMainApp(this);

        FXMLDocumentController controller = loader1.getController();
        controller.setMainApp(this);

        rootController.setFXMLDocumentController(controller);

        db = new DB(getStr(connectionString), getStr(userCft), getStr(passwordCft));
        serviceDAO = new serviceDAO(db);

    }

    /**
     * loadInfoFromFile
     */
    public void loadInfoFromFile() {
        int ind = 0;
        String lastName = null;
        String firstName = null;
        String secondName = null;
        String ser = null;
        String number = null;

        String DateIssue = null;
        String whom = null;
        String Code = null;
        String BirthPlace = null;
        String AdressResident = null;
        String adressFact = null;
        String adressPostal = null;
        String tel = null;
        String codeWord1 = null;
        String codeWord2 = null;
        String sex = null;
        String dateBirth = null;
        String pdl = null;
        String snils = null;

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Document");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt", "*.TXT");

        fileChooser.getExtensionFilters().add(extFilter);
        if (lastDir != null) {
            fileChooser.setInitialDirectory(lastDir);
        }
        File file = fileChooser.showOpenDialog(this.primaryStage);

        this.parentDir = file.getParentFile().toString();
        this.lastDir = file.getParentFile();
        this.currentFile = file;

        if (file != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));) {
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    ind++;
                    if (ind > 1) {

                        try {

                            String[] arrLine = strLine.split(";");

                            lastName = arrLine[1] != null ? arrLine[1] : "";
                            firstName = arrLine[2] != null ? arrLine[2] : "";
                            secondName = arrLine[3] != null ? arrLine[3] : "";
                            ser = arrLine[33] != null ? arrLine[33] : "";
                            number = arrLine[34] != null ? arrLine[34] : "";
                            DateIssue = arrLine[35] != null ? arrLine[35] : "";
                            whom = arrLine[36] != null ? arrLine[36] : "";
                            Code = "";
                            BirthPlace = arrLine[8] != null ? arrLine[8] : "";

                            AdressResident = arrLine[10] != null ? arrLine[10] : ",";
                            AdressResident += arrLine[11] != null ? "," + arrLine[11] : ",";
                            AdressResident += arrLine[12] != null ? "," + arrLine[12] : ",";
                            AdressResident += arrLine[13] != null ? "," + arrLine[13] : ",";
                            AdressResident += arrLine[14] != null ? "," + arrLine[14] : ",";
                            AdressResident += arrLine[15] != null ? "," + arrLine[15] : ",";
                            AdressResident += arrLine[16] != null ? "," + arrLine[16] : ",";
                            AdressResident += arrLine[17] != null ? "," + arrLine[17] : ",";
                            AdressResident += arrLine[18] != null ? "," + arrLine[18] : ",";
                            AdressResident += arrLine[19] != null ? "," + arrLine[19] : ",";

                            tel = arrLine[31] != null ? arrLine[31] : "";
                            codeWord1 = arrLine[40] != null ? arrLine[40] : "";
                            codeWord2 = "";
                            sex = arrLine[4] != null ? arrLine[4] : "";
                            dateBirth = arrLine[7] != null ? arrLine[7] : "";

                            adressFact = arrLine[20] != null ? arrLine[20] : ",";
                            adressFact += arrLine[21] != null ? "," + arrLine[21] : ",";
                            adressFact += arrLine[22] != null ? "," + arrLine[22] : ",";
                            adressFact += arrLine[23] != null ? "," + arrLine[23] : ",";
                            adressFact += arrLine[24] != null ? "," + arrLine[24] : ",";
                            adressFact += arrLine[25] != null ? "," + arrLine[25] : ",";
                            adressFact += arrLine[26] != null ? "," + arrLine[26] : ",";
                            adressFact += arrLine[27] != null ? "," + arrLine[27] : ",";
                            adressFact += arrLine[28] != null ? "," + arrLine[28] : ",";
                            adressFact += arrLine[29] != null ? "," + arrLine[29] : ",";

                            adressPostal = AdressResident;

                            if (arrLine.length > 45) {
                                pdl = arrLine[46] != null ? arrLine[46] : "";
                            } else {
                                pdl = "";
                            }

                            snils = arrLine[42] != null ? arrLine[42] : "";

                        } catch (ArrayIndexOutOfBoundsException e) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.initOwner(this.primaryStage);
                            alert.setTitle("Error");
                            alert.setHeaderText(e.getClass().toString());
                            alert.setContentText(e.toString());
                            alert.showAndWait();
                        }

                        info info = new info(lastName, firstName, secondName, ser, number);
                        info.setpDateIssue(DateIssue);
                        info.setpWhom(whom);
                        info.setpCode(Code);
                        info.setpBirthPlace(BirthPlace);
                        info.setppAdressResident(AdressResident);
                        info.settel(tel);
                        info.setcodeWord1(codeWord1);
                        info.setcodeWord2(codeWord2);
                        info.setsex(sex);
                        info.setdateBirth(dateBirth);
                        info.setadressFact(adressFact);
                        info.setadressPostal(adressPostal);
                        info.setpdl(pdl);
                        info.setsnils(snils);
                        info.setSrcString(strLine);

                        infoData.add(info);

                    }

                }

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(this.primaryStage);
                alert.setTitle("Error");
                alert.setHeaderText(e.getClass().toString());
                alert.setContentText(e.toString());
                alert.showAndWait();

            }

            file = null;
        }

    }

    public ObservableList<info> getInfoData() {
        return infoData;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * checkPassport
     *
     * @param ser
     * @param num
     * @return
     */
    public String checkPassport(String ser, String num) {
        String res = "";

        res = this.serviceDAO.chechPassport(ser, num);

        return res;

    }

    /**
     * toCft
     *
     * @return
     */
    public String toCft() {
        String res = "";

        if (login == null && psw == login) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.primaryStage);
            alert.setTitle("Login");
            alert.setHeaderText("");
            alert.setContentText("");
            alert.showAndWait();
            login = "";
            psw = "";
        }

        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * closeDb
     */
    public void closeDb() {
        db.Close();
    }

    public String getParentDir() {
        return parentDir;
    }

    /**
     * getStr
     *
     * @param property
     * @return
     */
    public static String getStr(String property) {

        byte[] result = null;
        final String ALGORITHM = "AES";

        byte[] property_pool = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);

        try {

            SecretKeySpec secretKey = new SecretKeySpec(property_pool, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            result = cipher.doFinal(Base64.getDecoder().decode(property));

        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("getStr: " + e.toString());
        }

        return new String(result);
    }

}
