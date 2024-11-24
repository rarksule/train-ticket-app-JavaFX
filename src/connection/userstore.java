package connection;

import java.util.Date;

/**
 *
 * @author Suleyman
 */
public class userstore
{
    public static String Email, FName, LName, UName, Passwd, Gender, Address, Phone;
    public static String Seat, DepartingCity, DestinationCity, fname, lname, gender, ID, phone,SeatNo;
    public static int Acctype;
    public static Date date, DATE;

    public static void Save3(String address, String email, String fname, Date dob, int phone, String lname, String uname, String passwd, String gender,
        int type)
    {
        /* this method is called by logins to share these datas with user fxml-------*/
        Address = address;
        Email = email;
        FName = fname;
        date = dob;
        Phone = Integer.toString(phone);
        LName = lname;
        UName = uname;
        Passwd = passwd;
        Gender = gender;
        Acctype = type;
        

    }

    public static void Save4(String seat, String departingCity, String destinationCity, String fName, String lName, String Id, int phon,int seatNo,Date dat)
    {
        /* this method is called by 'checker' to share these datas with checkticket.fxml-------*/
        DepartingCity = departingCity;
        DestinationCity = destinationCity;
        fname = fName;
        lname = lName;
        phone = Integer.toString(phon);
        DATE = dat;
        SeatNo = Integer.toString(seatNo);
        Seat = seat;
    }
}