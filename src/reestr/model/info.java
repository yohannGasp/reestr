/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reestr.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class info {

    private StringProperty lastName;
    private StringProperty firstName;
    private StringProperty secondName;
    private StringProperty ser;
    private StringProperty number;

    private StringProperty pWhom;
    private StringProperty pDateIssue;
    private StringProperty pCode;
    private StringProperty pBirthPlace;
    private StringProperty pAdressResident;
    private StringProperty adressFact;
    private StringProperty adressPostal;
    private StringProperty tel;
    private StringProperty codeWord1;
    private StringProperty codeWord2;
    private StringProperty sex;
    private StringProperty dateBirth;
    private StringProperty pdl;
    private StringProperty snils;
    
    private String srcString;

    public info(String lastName, String firstName, String secondName, String ser, String number) {
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.ser = new SimpleStringProperty(ser);
        this.number = new SimpleStringProperty(number);

        this.pWhom = new SimpleStringProperty("");
        this.pDateIssue = new SimpleStringProperty("");
        this.pCode = new SimpleStringProperty("");
        this.pBirthPlace = new SimpleStringProperty("");
        this.pAdressResident = new SimpleStringProperty("");
        this.adressFact = new SimpleStringProperty("");
        this.adressPostal = new SimpleStringProperty("");
        this.tel = new SimpleStringProperty("");
        this.codeWord1 = new SimpleStringProperty("");
        this.codeWord2 = new SimpleStringProperty("");
        this.sex = new SimpleStringProperty("");
        this.dateBirth = new SimpleStringProperty("");
        this.pdl = new SimpleStringProperty("");
        this.snils = new SimpleStringProperty("");

    }

    //firstName
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    //lastName
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    //secondName
    public String getSecondName() {
        return secondName.get();
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public StringProperty SecondNameProperty() {
        return secondName;
    }

    //ser
    public String getSer() {
        return ser.get();
    }

    public void setSer(String ser) {
        this.ser.set(ser);
    }

    public StringProperty SerProperty() {
        return ser;
    }

    //number
    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public StringProperty NumberProperty() {
        return number;
    }

    //pWhom
    public StringProperty pWhomProperty() {
        return pWhom;
    }

    public void setpWhom(String pWhom) {
        this.pWhom.set(pWhom);
    }

    public String getpWhom() {
        return pWhom.get();
    }

    //pDateIssue
    public StringProperty pDateIssueProperty() {
        return pDateIssue;
    }

    public void setpDateIssue(String pDateIssue) {
        this.pDateIssue.set(pDateIssue);
    }

    public String getpDateIssue() {
        return pDateIssue.get();
    }

    //pCode
    public StringProperty pCodeProperty() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode.set(pCode);
    }

    public String getpCode() {
        return pCode.get();
    }

    //pBirthPlace
    public StringProperty pBirthPlaceProperty() {
        return pBirthPlace;
    }

    public void setpBirthPlace(String pBirthPlace) {
        this.pBirthPlace.set(pBirthPlace);
    }

    public String getpBirthPlace() {
        return pBirthPlace.get();
    }

    //pAdressResident
    public StringProperty pAdressResidentProperty() {
        return pAdressResident;
    }

    public void setppAdressResident(String pAdressResident) {
        this.pAdressResident.set(pAdressResident);
    }

    public String getpAdressResident() {
        return pAdressResident.get();
    }

    //adressFact
    public StringProperty adressFactProperty() {
        return adressFact;
    }

    public void setadressFact(String adressFact) {
        this.adressFact.set(adressFact);
    }

    public String getadressFact() {
        return adressFact.get();
    }

    //adressPostal;
    public StringProperty adressPostalProperty() {
        return adressPostal;
    }

    public void setadressPostal(String adressPostal) {
        this.adressPostal.set(adressPostal);
    }

    public String getadressPostal() {
        return adressPostal.get();
    }

    //tel;
    public StringProperty telProperty() {
        return tel;
    }

    public void settel(String tel) {
        this.tel.set(tel);
    }

    public String gettel() {
        return tel.get();
    }

    //codeWord1;
    public StringProperty codeWord1Property() {
        return codeWord1;
    }

    public void setcodeWord1(String codeWord1) {
        this.codeWord1.set(codeWord1);
    }

    public String getcodeWord1() {
        return codeWord1.get();
    }

    //codeWord2;
    public StringProperty codeWord2Property() {
        return codeWord2;
    }

    public void setcodeWord2(String codeWord2) {
        this.codeWord2.set(codeWord2);
    }

    public String getcodeWord2() {
        return codeWord2.get();
    }

    //sex;
    public StringProperty sexProperty() {
        return sex;
    }

    public void setsex(String sex) {
        this.sex.set(sex);
    }

    public String getsex() {
        return sex.get();
    }

    //dateBirth;
    public StringProperty dateBirthProperty() {
        return dateBirth;
    }

    public void setdateBirth(String dateBirth) {
        this.dateBirth.set(dateBirth);
    }

    public String getdateBirth() {
        return dateBirth.get();
    }

    //pdl;
    public StringProperty pdlProperty() {
        return pdl;
    }

    public void setpdl(String pdl) {
        this.pdl.set(pdl);
    }

    public String getpdl() {
        return pdl.get();
    }

    //snils;
    public StringProperty snilsProperty() {
        return snils;
    }

    public void setsnils(String snils) {
        this.snils.set(snils);
    }

    public String getsnils() {
        return snils.get();
    }

    public String getSrcString() {
        return srcString;
    }

    public void setSrcString(String srcString) {
        this.srcString = srcString;
    }
    
    

}
