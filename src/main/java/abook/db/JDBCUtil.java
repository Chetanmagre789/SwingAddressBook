package abook.db;

import java.sql.*;
import javax.swing.JOptionPane;
/**
* @author Pankaj Sharma
*/
public class JDBCUtil {
    static Connection con;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cbook_db", "root", "root");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load JDBC Driver");
        } catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to Database");
        }
    }

    /**
     * Call this method to execute any DML Query(insert/update/delete)
     * @param sql
     */
    public void update(String sql){
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ConvetCompile time exception into Runtime exception
            throw new RuntimeException(ex);
        }
    }

     /**
     * Call this method to execute Select Query
     * @param sql
     */
    public ResultSet select(String sql){
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Convet Compile time exception into Runtime exception
            throw new RuntimeException(ex);
        }
    }



    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            //silent
        }
    }



}
