
package connection;
import java.sql.*;

public class Logins
{
    Connection Connect3;
    ConnectionClass conclass = new ConnectionClass();
    public String usern, userf, userl, useradd, genderu, emailu, upass;
    public int userpo, accty;
    public Date dob;
    String Query = "select * from user where (UName=? And Passwd=?)";
    
    public int LOGIN(String user, String password)
    {

        String pass = password;
        String username = user;
        try
        {
            Connect3 = conclass.connector();

            ResultSet rest;
            PreparedStatement prst3 = Connect3.prepareStatement(Query);
            prst3.setString(1, username);
            prst3.setString(2, pass);
            rest = prst3.executeQuery();
            while (rest.next())
            {
                
                userf = rest.getString(1);
                userl = rest.getString(2);
                useradd = rest.getString(3);
                userpo = rest.getInt(4);
                dob = rest.getDate(5);
                emailu = rest.getString(6);
                usern = rest.getString(7);
                upass = rest.getString(8);
                genderu = rest.getString(9);
                accty = rest.getInt(10);

                userstore.Save3(useradd, emailu, userf, dob, userpo, userl, usern, upass, genderu, accty);

                return 1;
            }

        }
        catch (SQLException ex)
        {
            System.out.println("login sql  " + ex);
        }
        return 0;

    }

}