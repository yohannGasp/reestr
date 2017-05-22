package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class DB {

    private String connectionString;
    private String userCft;
    private String passwordCft;

    public final static String SQL_CHECK_PASSPORT = "{ call ? := BIB_CITYLINK_CHECK_PASSPORT(?,?) }";

    private Connection conn = null;

    /**
     *
     * @param connectionString
     * @param userCft
     * @param passwordCft
     */
    public DB(String connectionString, String userCft, String passwordCft) {
        this.connectionString = connectionString;
        this.userCft = userCft;
        this.passwordCft = passwordCft;
    }

    /**
     * Singletone Connection from Driver
     *
     *
     */
    Connection getConnection() throws SQLException {

        if (this.conn == null) {

            System.setProperty("java.security.egd", "file:///dev/urandom"); //http://blockdump.blogspot.ru/2012/07/connection-problems-inbound-connection.html
            java.sql.DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            this.conn = java.sql.DriverManager.getConnection(this.connectionString, this.userCft, this.passwordCft);

        }

        return this.conn;
    }

    /**
     * close connection
     */
    public void Close() {
        
        try {
            
            if (this.conn != null) {
                this.conn.close();
            }
            
        } catch (SQLException e) {
            System.out.println("close connection: " + e.toString());
        }
        
    }

    /**
     * exec function in oracle with parameters
     *
     * @param SQL
     * @return ResultSet
     */
    public String ExecFuncPS(String SQL, String[] param) {

        CallableStatement statement = null;
        String result = null;

        try {

            statement = getConnection().prepareCall(SQL);

            statement.registerOutParameter(1, Types.VARCHAR);
            for (int i = 0; i < param.length; i++) {
                statement.setString(i + 2, param[i]);
            }

            statement.execute();

            result = statement.getString(1);

        } catch (SQLException e) {
            System.out.println("ExecFuncPS: " + e.toString());
        } finally {

            try {

                statement.close();

            } catch (SQLException ex) {
                System.out.println("ExecFuncPS: close " + ex.toString());
            }

        }
        
        return result;
        
    }

}
