package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBContext {

    public Connection conn = null;

    public DBContext(String URL, String userName, String password) {
        try {
            //        URL: connection string:address,port,database of sever
            //call driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, userName, password);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public DBContext() {
        this("jdbc:sqlserver://localhost:1433;databaseName=SWPgroup3", "sa", "123456");
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public void closePreparedStatement(PreparedStatement ps) throws Exception {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }
    public void closeResultSet(ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    public static void main(String[] args) {
        new DBContext();
    }
}
