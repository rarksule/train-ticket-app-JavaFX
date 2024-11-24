
package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class checker
{
    Connection Connect3;
    ConnectionClass conclass = new ConnectionClass();

    public String Seat, DepartingCity, DestinationCity, FName, LName, Gender, Id;
    static int PNo, number,Seatno;

    String Query = "select * from book where(Identification=?)";
    public Date date;
    public int check(String ID)
    {

        String ident = ID;
        try
        {
            Connect3 = conclass.connector();

            ResultSet rest;
            PreparedStatement prst3 = Connect3.prepareStatement(Query);
            prst3.setString(1, ident);
            rest = prst3.executeQuery();
            while (rest.next())
            {
                
                number = rest.getInt(1);
                Seatno = rest.getInt(2);
                FName = rest.getString(3);
                LName = rest.getString(4);
                PNo = rest.getInt(5);
                Seat = rest.getString(6);
                DepartingCity = rest.getString(7);
                DestinationCity = rest.getString(8);
                Gender = rest.getString(9);
                date = rest.getDate(10);
                Id = rest.getString(11);
                

                userstore.Save4(Seat, DepartingCity, DestinationCity, FName, LName, Id, PNo,Seatno, date);

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