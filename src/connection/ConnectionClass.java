package connection;

import java.sql.*;

/**
 *
 * @author Suleyman
 */
public class ConnectionClass
{
    Connection Conn;
    public Connection connector()
    {
        try
        {
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/ticket";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conn = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex)
        {
            System.out.println("Sql Exceoption " + ex);
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("class not found " + ex);
        }
        return Conn;
    }

}