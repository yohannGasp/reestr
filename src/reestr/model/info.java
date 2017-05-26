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
    private StringProperty field;
    private StringProperty chkPsp;

    private StringProperty pWhom;
    private StringProperty pDateIssue;
    private StringProperty pCode;
    private StringProperty pBirthPlace;
    private StringProperty pAdressResident;

    private StringProperty adressRegCodeCountry;
    private StringProperty adressRegIndex;
    private StringProperty adressRegCodeSubject;
    private StringProperty adressRegRayonSubject;
    private StringProperty adressRegCity;
    private StringProperty adressRegNasPunkt;
    private StringProperty adressRegStreet;
    private StringProperty adressRegHouse;
    private StringProperty adressRegKorpus;
    private StringProperty adressRegKvartira;

    /*
        
    Место регистрации. Код страны адреса	
    Место регистрации. Почтовый индекс	
    Место регистрации. Код субъекта РФ	
    Место регистрации. Район субъекта РФ	
    Место регистрации. Город	
    Место регистрации. Населенный пункт	
    Место регистрации. Улица	
    Место регистрации. Дом	
    Место регистрации. Корпус	
    Место регистрации. Квартира
    
    Код страны адреса	
    Почтовый индекс	
    Код субъекта РФ адреса	
    Район субъекта РФ адреса	
    Город	
    Населенный пункт	
    Улица	
    Дом	
    Корпус	
    Квартира

     */
    private StringProperty adressFactCodeCountry;
    private StringProperty adressFactIndex;
    private StringProperty adressFactCodeSubject;
    private StringProperty adressFactRayonSubject;
    private StringProperty adressFactCity;
    private StringProperty adressFactNasPunkt;
    private StringProperty adressFactStreet;
    private StringProperty adressFactHouse;
    private StringProperty adressFactKorpus;
    private StringProperty adressFactKvartira;

    private StringProperty adressMailCodeCountry;
    private StringProperty adressMailIndex;
    private StringProperty adressMailCodeSubject;
    private StringProperty adressMailRayonSubject;
    private StringProperty adressMailCity;
    private StringProperty adressMailNasPunkt;
    private StringProperty adressMailStreet;
    private StringProperty adressMailHouse;
    private StringProperty adressMailKorpus;
    private StringProperty adressMailKvartira;

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
        this.field = new SimpleStringProperty("");
        this.chkPsp = new SimpleStringProperty("");

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

        this.adressRegCodeCountry = new SimpleStringProperty("");
        this.adressRegIndex = new SimpleStringProperty("");
        this.adressRegCodeSubject = new SimpleStringProperty("");
        this.adressRegRayonSubject = new SimpleStringProperty("");
        this.adressRegCity = new SimpleStringProperty("");
        this.adressRegNasPunkt = new SimpleStringProperty("");
        this.adressRegStreet = new SimpleStringProperty("");
        this.adressRegHouse = new SimpleStringProperty("");
        this.adressRegKorpus = new SimpleStringProperty("");
        this.adressRegKvartira = new SimpleStringProperty("");
        this.adressFactCodeCountry = new SimpleStringProperty("");
        this.adressFactIndex = new SimpleStringProperty("");
        this.adressFactCodeSubject = new SimpleStringProperty("");
        this.adressFactRayonSubject = new SimpleStringProperty("");
        this.adressFactCity = new SimpleStringProperty("");
        this.adressFactNasPunkt = new SimpleStringProperty("");
        this.adressFactStreet = new SimpleStringProperty("");
        this.adressFactHouse = new SimpleStringProperty("");
        this.adressFactKorpus = new SimpleStringProperty("");
        this.adressFactKvartira = new SimpleStringProperty("");
        this.adressMailCodeCountry = new SimpleStringProperty("");
        this.adressMailIndex = new SimpleStringProperty("");
        this.adressMailCodeSubject = new SimpleStringProperty("");
        this.adressMailRayonSubject = new SimpleStringProperty("");
        this.adressMailCity = new SimpleStringProperty("");
        this.adressMailNasPunkt = new SimpleStringProperty("");
        this.adressMailStreet = new SimpleStringProperty("");
        this.adressMailHouse = new SimpleStringProperty("");
        this.adressMailKorpus = new SimpleStringProperty("");
        this.adressMailKvartira = new SimpleStringProperty("");

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

    //field
    public String getfield() {
        return field.get();
    }

    public void setfield(String field) {
        this.field.set(field);
    }

    public StringProperty fieldProperty() {
        return field;
    }

    //chkPsp
    public String getchkPsp() {
        return chkPsp.get();
    }

    public void setchkPsp(String chkPsp) {
        this.chkPsp.set(chkPsp);
    }

    public StringProperty chkPspProperty() {
        return chkPsp;
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

    //adressRegCodeCountry
    public String getadressRegCodeCountry() {
        return adressRegCodeCountry.get();
    }

    //adressRegIndex
    public String getadressRegIndex() {
        return adressRegIndex.get();

    }

    //adressRegCodeSubject
    public String getadressRegCodeSubject() {
        return adressRegCodeSubject.get();

    }

    //adressRegRayonSubject
    public String getadressRegRayonSubject() {
        return adressRegRayonSubject.get();

    }

    //adressRegCity
    public String getadressRegCity() {
        return adressRegCity.get();

    }

    //adressRegNasPunkt
    public String getadressRegNasPunkt() {
        return adressRegNasPunkt.get();

    }

    //adressRegStreet
    public String getadressRegStreet() {
        return adressRegStreet.get();

    }

    //adressRegHouse
    public String getadressRegHouse() {
        return adressRegHouse.get();

    }

    //adressRegKorpus
    public String getadressRegKorpus() {
        return adressRegKorpus.get();

    }

    //adressRegKvartira
    public String getadressRegKvartira() {
        return adressRegKvartira.get();
    }

    //adressFactCodeCountry
    public String getadressFactCodeCountry() {
        return adressFactCodeCountry.get();
    }

    //adressFactIndex
    public String getadressFactIndex() {
        return adressFactIndex.get();

    }

    //adressFactCodeSubject
    public String getadressFactCodeSubject() {
        return adressFactCodeSubject.get();

    }

    //adressFactRayonSubject
    public String getadressFactRayonSubject() {
        return adressFactRayonSubject.get();

    }

    //adressFactCity
    public String getadressFactCity() {
        return adressFactCity.get();

    }

    //adressFactNasPunkt
    public String getadressFactNasPunkt() {
        return adressFactNasPunkt.get();

    }

    //adressFactStreet
    public String getadressFactStreet() {
        return adressFactStreet.get();

    }

    //adressFactHouse
    public String getadressFactHouse() {
        return adressFactHouse.get();

    }

    //adressFactKorpus
    public String getadressFactKorpus() {
        return adressFactKorpus.get();

    }

    //adressFactKvartira
    public String getadressFactKvartira() {
        return adressFactKvartira.get();
    }

    //adressMailCodeCountry
    public String getadressMailCodeCountry() {
        return adressMailCodeCountry.get();
    }

    //adressMailIndex
    public String getadressMailIndex() {
        return adressMailIndex.get();

    }

    //adressMailCodeSubject
    public String getadressMailCodeSubject() {
        return adressMailCodeSubject.get();

    }

    //adressMailRayonSubject
    public String getadressMailRayonSubject() {
        return adressMailRayonSubject.get();

    }

    //adressMailCity
    public String getadressMailCity() {
        return adressMailCity.get();

    }

    //adressMailNasPunkt
    public String getadressMailNasPunkt() {
        return adressMailNasPunkt.get();

    }

    //adressMailStreet
    public String getadressMailStreet() {
        return adressMailStreet.get();

    }

    //adressMailHouse
    public String getadressMailHouse() {
        return adressMailHouse.get();

    }

    //adressMailKorpus
    public String getadressMailKorpus() {
        return adressMailKorpus.get();

    }

    //adressMailKvartira
    public String getadressMailKvartira() {
        return adressMailKvartira.get();
    }
    
    /* ok */

    public void setadressRegCodeCountry(String adressRegCodeCountry) {
        this.adressRegCodeCountry.set(adressRegCodeCountry);
    }

    public void setadressRegIndex(String adressRegIndex) {
        this.adressRegIndex.set(adressRegIndex);
    }

    public void setadressRegCodeSubject(String adressRegCodeSubject) {
        this.adressRegCodeSubject.set(adressRegCodeSubject);
    }

    public void setadressRegRayonSubject(String adressRegRayonSubject) {
        this.adressRegRayonSubject.set(adressRegRayonSubject);
    }

    public void setadressRegCity(String adressRegCity) {
        this.adressRegCity.set(adressRegCity);
    }

    public void setadressRegNasPunkt(String adressRegNasPunkt) {
        this.adressRegNasPunkt.set(adressRegNasPunkt);
    }

    public void setadressRegStreet(String adressRegStreet) {
        this.adressRegStreet.set(adressRegStreet);
    }

    public void setadressRegHouse(String adressRegHouse) {
        this.adressRegHouse.set(adressRegHouse);
    }

    public void setadressRegKorpus(String adressRegKorpus) {
        this.adressRegKorpus.set(adressRegKorpus);
    }

    public void setadressRegKvartira(String adressRegKvartira) {
        this.adressRegKvartira.set(adressRegKvartira);
    }

    public void setadressFactCodeCountry(String adressFactCodeCountry) {
        this.adressFactCodeCountry.set(adressFactCodeCountry);
    }

    public void setadressFactIndex(String adressFactIndex) {
        this.adressFactIndex.set(adressFactIndex);
    }

    public void setadressFactCodeSubject(String adressFactCodeSubject) {
        this.adressFactCodeSubject.set(adressFactCodeSubject);
    }

    public void setadressFactRayonSubject(String adressFactRayonSubject) {
        this.adressFactRayonSubject.set(adressFactRayonSubject);
    }

    public void setadressFactCity(String adressFactCity) {
        this.adressFactCity.set(adressFactCity);
    }

    public void setadressFactNasPunkt(String adressFactNasPunkt) {
        this.adressFactNasPunkt.set(adressFactNasPunkt);
    }

    public void setadressFactStreet(String adressFactStreet) {
        this.adressFactStreet.set(adressFactStreet);
    }

    public void setadressFactHouse(String adressFactHouse) {
        this.adressFactHouse.set(adressFactHouse);
    }

    public void setadressFactKorpus(String adressFactKorpus) {
        this.adressFactKorpus.set(adressFactKorpus);
    }

    public void setadressFactKvartira(String adressFactKvartira) {
        this.adressFactKvartira.set(adressFactKvartira);
    }

    public void setadressMailCodeCountry(String adressMailCodeCountry) {
        this.adressMailCodeCountry.set(adressMailCodeCountry);
    }

    public void setadressMailIndex(String adressMailIndex) {
        this.adressMailIndex.set(adressMailIndex);
    }

    public void setadressMailCodeSubject(String adressMailCodeSubject) {
        this.adressMailCodeSubject.set(adressMailCodeSubject);
    }

    public void setadressMailRayonSubject(String adressMailRayonSubject) {
        this.adressMailRayonSubject.set(adressMailRayonSubject);
    }

    public void setadressMailCity(String adressMailCity) {
        this.adressMailCity.set(adressMailCity);
    }

    public void setadressMailNasPunkt(String adressMailNasPunkt) {
        this.adressMailNasPunkt.set(adressMailNasPunkt);
    }

    public void setadressMailStreet(String adressMailStreet) {
        this.adressMailStreet.set(adressMailStreet);
    }

    public void setadressMailHouse(String adressMailHouse) {
        this.adressMailHouse.set(adressMailHouse);
    }

    public void setadressMailKorpus(String adressMailKorpus) {
        this.adressMailKorpus.set(adressMailKorpus);
    }

    public void setadressMailKvartira(String adressMailKvartira) {
        this.adressMailKvartira.set(adressMailKvartira);
    }

    /* ok */
    
    public StringProperty adressRegCodeCountryProperty() {
        return adressRegCodeCountry;
    }

    public StringProperty adressRegIndexProperty() {
        return adressRegIndex;
    }

    public StringProperty adressRegCodeSubjectProperty() {
        return adressRegCodeSubject;
    }

    public StringProperty adressRegRayonSubjectProperty() {
        return adressRegRayonSubject;
    }

    public StringProperty adressRegCityProperty() {
        return adressRegCity;
    }

    public StringProperty adressRegNasPunktProperty() {
        return adressRegNasPunkt;
    }

    public StringProperty adressRegStreetProperty() {
        return adressRegStreet;
    }

    public StringProperty adressRegHouseProperty() {
        return adressRegHouse;
    }

    public StringProperty adressRegKorpusProperty() {
        return adressRegKorpus;
    }

    public StringProperty adressRegKvartiraProperty() {
        return adressRegKvartira;
    }

    public StringProperty adressFactCodeCountryProperty() {
        return adressFactCodeCountry;
    }

    public StringProperty adressFactIndexProperty() {
        return adressFactIndex;
    }

    public StringProperty adressFactCodeSubjectProperty() {
        return adressFactCodeSubject;
    }

    public StringProperty adressFactRayonSubjectProperty() {
        return adressFactRayonSubject;
    }

    public StringProperty adressFactCityProperty() {
        return adressFactCity;
    }

    public StringProperty adressFactNasPunktProperty() {
        return adressFactNasPunkt;
    }

    public StringProperty adressFactStreetProperty() {
        return adressFactStreet;
    }

    public StringProperty adressFactHouseProperty() {
        return adressFactHouse;
    }

    public StringProperty adressFactKorpusProperty() {
        return adressFactKorpus;
    }

    public StringProperty adressFactKvartiraProperty() {
        return adressFactKvartira;
    }

    public StringProperty adressMailCodeCountryProperty() {
        return adressMailCodeCountry;
    }

    public StringProperty adressMailIndexProperty() {
        return adressMailIndex;
    }

    public StringProperty adressMailCodeSubjectProperty() {
        return adressMailCodeSubject;
    }

    public StringProperty adressMailRayonSubjectProperty() {
        return adressMailRayonSubject;
    }

    public StringProperty adressMailCityProperty() {
        return adressMailCity;
    }

    public StringProperty adressMailNasPunktProperty() {
        return adressMailNasPunkt;
    }

    public StringProperty adressMailStreetProperty() {
        return adressMailStreet;
    }

    public StringProperty adressMailHouseProperty() {
        return adressMailHouse;
    }

    public StringProperty adressMailKorpusProperty() {
        return adressMailKorpus;
    }

    public StringProperty adressMailKvartiraProperty() {
        return adressMailKvartira;
    }
    
    /* ok */
}
