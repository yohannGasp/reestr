/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author evgeniy
 */
public class serviceDAO {

    private DB db;

    /**
     *
     * @param db
     */
    public serviceDAO(DB db) {
        this.db = db;
    }

    /**
     * chechPassport
     *
     * @param ser
     * @param num
     * @return
     */
    public String chechPassport(String ser, String num) {
        String[] param = new String[2];
        String res = "";

        if (!ser.equals("") & !num.equals("")) {
            param[0] = ser.trim();
            param[1] = num.trim();
            res = db.ExecFuncPS(db.SQL_CHECK_PASSPORT, param);
        }
        return res;
    }

    /**
     * Передать ошибку по ответу
     *
     * @param id_request
     * @param code
     * @return
     */
//    public String setResponseError(String id_request, String code) {
//        String[] param = new String[2];
//        String res = "";
//
//        if (!id_request.equals("") & !code.equals("")) {
//            param[0] = id_request.trim();
//            param[1] = code.trim();
//            res = db.ExecFuncPS(db.SQL_SET_RESPONSE_ERROR, param);
//        }
//        return res;
//    }

}
