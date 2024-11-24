
package connection;
import java.util.Date;


public class table
{
 //initialize global variables
    String Seat, DestinationCity, DepartingCity, FName, LName, Gender,ID,SeatNo;
    int PNo, No ;
    Date Date;

    public table(int No,int seatno, String FName, String LName, int PNo, String Seat, String DepartingCity, String DestinationCity, String Gender, Date Date,String ID)
    {
        this.FName = FName;
        this.LName = LName;
        this.Gender = Gender;
        this.Seat = Seat;
        this.DestinationCity = DestinationCity;
        this.DepartingCity = DepartingCity;
        this.PNo = PNo;
        this.Date = Date;
        this.No = No;
        this.ID = ID;
        this.SeatNo = Integer.toString(seatno);
    }

    public String getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(String SeatNo) {
        this.SeatNo = SeatNo;
    }

    public int getNo()
    {
        return No;
    }

    public void setNo(int No)
    {
        this.No = No;
    }

    public String getFName()
    {
        return FName;
    }


    public void setFName(String FName)
    {
        this.FName = FName;
    }
    public Date getDate()
    {
        return Date;
    }

    public void setDate(Date Date)
    {
        this.Date = Date;
    }

    public String getLName()
    {
        return LName;
    }

    public void setLName(String LName)
    {
        this.LName = LName;
    }

    public String getGender()
    {
        return Gender;
    }

    public void setGender(String Gender)
    {
        this.Gender = Gender;
    }

    public String getSeat()
    {
        return Seat;
    }

    public void setSeat(String Seat)
    {
        this.Seat = Seat;
    }

    public String getDestinationCity()
    {
        return DestinationCity;
    }

    public void setDestinationCity(String DestinationCity)
    {
        this.DestinationCity = DestinationCity;
    }

    public String getDepartingCity()
    {
        return DepartingCity;
    }

    public void setDepartingCity(String DepartingCity)
    {
        this.DepartingCity = DepartingCity;
    }

    public int getPNo()
    {
        return PNo;
    }

    public void setPNo(int PNo)
    {
        this.PNo = PNo;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}