
package connection;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class buys
{




    PriceCalculator price = new PriceCalculator();
    Connection Connect;
    ConnectionClass conclass = new ConnectionClass();
    public  String Seat, DepartingCity, DestinationCity, FName, LName, Gender, F, L;
    public static String ID;
    String Datain = "INSERT INTO book(FName,LName,PNo,Seat,DepartingCity,DestinationCity,Gender,Date,Identification,seatNo)values(?,?,?,?,?,?,?,?,?,?)";
     int PNo;
     DateTimeFormatter Form = DateTimeFormatter.ofPattern("ssddyyHHMMmm");
     LocalDate Date;
     Date DATE;
     LocalDateTime Now = LocalDateTime.now();
     public static int SeatNo;

    public  void save(String st, String dp, String ds, LocalDate date, String Fname, String Lname, String Pno, String gender)
    {
        Seat = st;
        DepartingCity = dp;
        DestinationCity = ds;
        Date = date;
        DATE = java.sql.Date.valueOf(Date);
        FName = Fname;
        LName = Lname;
        PNo = Integer.parseInt(Pno);
        Gender = gender;
        F = FName.substring(0, 1).toUpperCase();
        L = LName.substring(0, 1).toUpperCase();
        ID = "OTT" + F + Form.format(Now) + L;
        try {
        SeatNo = price.Seatno(DATE);
        } catch (SQLException ex) {
            System.out.println("seat no   "+ ex);
        }
        
        
    }

    public boolean Save()
    {
        try
        {

            Connect = conclass.connector();
            PreparedStatement prst = Connect.prepareStatement(Datain);
            prst.setString(1, FName);
            prst.setString(2, LName);
            prst.setInt(3, PNo);
            prst.setString(4, Seat);
            prst.setString(5, DepartingCity);
            prst.setString(6, DestinationCity);
            prst.setString(7, Gender);
            prst.setDate(8, DATE);
            prst.setString(9, ID);
            prst.setInt(10,SeatNo);
            prst.executeUpdate();
            return true;

        }
        catch (SQLException ex)
        {
            System.out.println("savesql " + ex);
        } 
        return false;

    }
}