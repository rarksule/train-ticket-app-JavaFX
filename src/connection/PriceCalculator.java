
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceCalculator
{
    public static String Seat, Destination, Departure;
    public static int count;
    ConnectionClass con = new ConnectionClass();
    Connection connect4 =  con.connector();;
    ResultSet rest ;
    String Query =" select * from book where(Date= ? and Seat = ? and (DepartingCity = ? or DestinationCity = ?))"; 
    public static int calculator(String seat, String depart, String dest)
    {
        Seat = seat;
        Destination = dest;
        Departure = depart;
        int price;
        switch (Seat)
        {
            case "Hard seat":
                switch (Departure)
                {
                    case "Addis Ababa":
                        if (Destination.equals("Adama"))
                        {
                            price = 105;
                        }

                        else
                        {
                            price = 490;
                        }
                        break;
                    case "Adama":
                        if (Destination.equals("Addis Ababa"))
                        {
                            price = 105;
                        }

                        else
                        {
                            price = 385;
                        }
                        break;
                    default:
                        if (Destination.equals("Adama"))
                        {
                            price = 385;
                        }

                        else
                        {
                            price = 105;
                        }
                        break;
                }
                break;

            case "UpperHard sleeper":
                switch (Departure)
                {
                    case "Addis Ababa":
                        if (Destination.equals("Adama"))
                        {
                            price = 140;
                        }

                        else
                        {
                            price = 561;
                        }
                        break;
                    case "Adama":
                        if (Destination.equals("Addis Ababa"))
                        {
                            price = 140;
                        }

                        else
                        {
                            price = 525;
                        }
                        break;
                    default:
                        if (Destination.equals("Adama"))
                        {
                            price = 525;
                        }

                        else
                        {
                            price = 561;
                        }
                        break;
                }
                break;

            case "MiddleHard sleeper":
                switch (Departure)
                {
                    case "Addis Ababa":
                        if (Destination.equals("Adama"))
                        {
                            price = 193;
                        }

                        else
                        {
                            price = 700;
                        }
                        break;
                    case "Adama":
                        if (Destination.equals("Addis Ababa"))
                        {
                            price = 193;
                        }

                        else
                        {
                            price = 665;
                        }
                        break;
                    default:
                        if (Destination.equals("Adama"))
                        {
                            price = 665;
                        }

                        else
                        {
                            price = 700;
                        }
                        break;
                }
                break;

            case "lowerHard sleeper":
                switch (Departure)
                {
                    case "Addis Ababa":
                        if (Destination.equals("Adama"))
                        {
                            price = 210;
                        }

                        else
                        {
                            price = 980;
                        }
                        break;
                    case "Adama":
                        if (Destination.equals("Addis Ababa"))
                        {
                            price = 210;
                        }

                        else
                        {
                            price = 770;
                        }
                        break;
                    default:
                        if (Destination.equals("Adama"))
                        {
                            price = 770;
                        }

                        else
                        {
                            price = 980;
                        }
                        break;
                }
                break;

            case "Uppersoft sleeper":
            switch (Departure) 
            {
                case "Addis Ababa":
                    if (Destination.equals("Adama"))
                    {
                        price = 263 ;
                    }

                    else
                    {
                        price = 1225;
                    }
                    break;
                case "Adama":
                    if (Destination.equals("Addis Ababa"))
                    {
                        price = 263 ;
                    }

                    else
                    {
                        price = 945;
                    }
                    break;
                default:
                    if (Destination.equals("Adama"))
                    {
                        price = 945;
                    }

                    else
                    {
                        price = 1225;
                    }
                    break;
            }
                break;

            default:
                switch (Departure)
                {
                    case "Addis Ababa":
                        if (Destination.equals("Adama"))
                        {
                            price = 280;
                        }

                        else
                        {
                            price = 1295;
                        }
                        break;
                    case "Adama":
                        if (Destination.equals("Addis Ababa"))
                        {
                            price = 280;
                        }

                        else
                        {
                            price = 1015;
                        }
                        break;
                    default:
                        if (Destination.equals("Adama"))
                        {
                            price = 1015;
                        }

                        else
                        {
                            price = 1295;
                        }
                        break;
                }
                break;

        }

        return price;

    }
    int Seatno(java.sql.Date dt) throws SQLException
    {
    count = 1;
    PreparedStatement pstm = connect4.prepareStatement(Query);
    pstm.setDate(1,dt);
    pstm.setString(2,Seat );
    pstm.setString(3,Departure);
    pstm.setString(4, Destination);
    rest = pstm.executeQuery();
    while(rest.next())
    {
        
        count++;
    }
    return count;
        
        
        
    }

}