
package connection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class signups
{




    Connection Connect2;
    ConnectionClass conclass = new ConnectionClass();



    public static String Email, FName, LName, UName, Passwd, Gender, Add;
    public static int Phone, accty;
    public static Date Dob;
    public static LocalDate datet;

    public static void save(String Address, String email, String fname, LocalDate date, String phone, String lname, String uname, String passwd,
        String gender)
    {

        Email = email;
        FName = fname;
        datet = date;
        Dob = java.sql.Date.valueOf(datet);
        Phone = Integer.parseInt(phone);
        LName = lname;
        Add = Address;
        UName = uname;
        Passwd = passwd;
        Gender = gender;
        

    }


    //**************************************************************

    String signup = "INSERT INTO user(FName,LName,Address,phone,DateOfBirth,Email,UName,Passwd,Gender,AccountType) values(?,?,?,?,?,?,?,?,?,?)";


    public int SIGNUP()
    {
        int n = 1;
        try
        {
            
            accty = 0;
            Connect2 = conclass.connector();

            PreparedStatement prst2 = Connect2.prepareStatement(signup);
            prst2.setString(1, FName);
            prst2.setString(2, LName);
            prst2.setString(3, Add);
            prst2.setInt(4, Phone);
            prst2.setDate(5, Dob);
            prst2.setString(6, Email);
            prst2.setString(7, UName);
            prst2.setString(8, Passwd);
            prst2.setString(9, Gender);
            prst2.setInt(10, accty);
            prst2.executeUpdate();


        }
        catch (SQLException ex)
        {
            System.out.println("signUpsql " + ex);
            n = 0;
        }

        return n;

    }

}