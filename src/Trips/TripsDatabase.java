package Trips;

import Employees.EmployeesDatabase;
import RailwayManagementSystem.Database;
import Trains.TrainsDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;

public class TripsDatabase {
    public static void AddTrip(Trip t, Database database) throws SQLException {
        String insert = "INSERT INTO `trips`(`ID`, `Start`, `Destination`, `DepartureTime`, "+
                "`ArrivalTime`, `Date`, `BookedSeats`, `Price`, `Driver`, `Train`) VALUES ("+
                "'"+ t.getId() +"', '"+ t.getStart() +"', '"+ t.getDestination() +"', '"+
                t.getDepartureTime() +"', '"+ t.getArrivalTime() +"', '"+ t.getDate() +"', "+
                t.getBookedSeats() +", "+ t.getPrice() +", '"+ t.getDriver().getId() +"', '"+
                t.getTrain().getId() +"')";
   database.getStatement().execute(insert);

        String create="CREATE TABLE `Trip"+t.getId()+"Passengers` (Passenger int, Tickets int);";
   database.getStatement().execute(create);

    }
    public static  int getNextID(Database database) throws SQLException {
        int id=0;
        ArrayList<Trip> trips=getAllTrips(database);
        int size=trips.size();
        if(size!=0){
            id=trips.get(size-1).getId()+1;
        }
        return id;
    }
    public static ArrayList<Trip> getAllTrips(Database database) throws SQLException {
        ArrayList<Trip> trips=new ArrayList<>();
        ArrayList<Integer> drivers=new ArrayList<>();
        ArrayList<Integer> trains=new ArrayList<>();
        String select="SELECT * FROM `trips`;";
        ResultSet rs=database.getStatement().executeQuery(select);
        while (rs.next()){
            Trip t=new Trip();
            t.setId(rs.getInt("ID"));
            t.setStart(rs.getString("Start"));
            t.setDestination(rs.getString("Destination"));
            t.setDepartureTime(rs.getString("DepartureTime"));
            t.setArrivalTime(rs.getString("ArrivalTime"));
            t.setDate(rs.getString("Date"));
            t.setBookedSeats(rs.getInt("BookedSeats"));
            t.setPrice(rs.getDouble("Price"));
           drivers.add(rs.getInt("Driver"));
           trains.add(rs.getInt("Train"));
            trips.add(t);

        }
        for (int i=0;i<trips.size();i++){
            trips.get(i).setDriver(EmployeesDatabase.getEmployee(String.valueOf(drivers.get(i)),database));
            trips.get(i).setTrain(TrainsDatabase.getTrain(String.valueOf(trains.get(i)),database));
        }
        return trips;
    }
    public static String[] getIDs(Database database) throws SQLException {
        ArrayList<Trip> trips=getAllTrips(database);
        String[] array=new String[trips.size()];
        for (int i=0;i< trips.size();i++){
            array[i]=String.valueOf(trips.get(i).getId());
        }
        return array;
    }
    public static Trip getTrip(String id,Database database) throws SQLException {
        String select="SELECT `ID`, `Start`, `Destination`, `DepartureTime`, `ArrivalTime`, `Date`, `BookedSeats`, `Price`, `Driver`, `Train` FROM `trips` WHERE `ID`="+id+";";
       ResultSet rs=database.getStatement().executeQuery(select);
       rs.next();
        Trip t=new Trip();
        t.setId(rs.getInt("ID"));
        t.setStart(rs.getString("Start"));
        t.setDestination(rs.getString("Destination"));
        t.setDepartureTime(rs.getString("DepartureTime"));
        t.setArrivalTime(rs.getString("ArrivalTime"));
        t.setDate(rs.getString("Date"));
        t.setBookedSeats(rs.getInt("BookedSeats"));
        t.setPrice(rs.getDouble("Price"));
        int driverID=rs.getInt("Driver");
        int trainID=rs.getInt("Train");
      t.setDriver(EmployeesDatabase.getEmployee(String.valueOf(driverID),database));
        t.setTrain(TrainsDatabase.getTrain(String.valueOf(trainID),database));
        return t;
    }
    public static  void EditTrip(Trip t,Database database) throws SQLException {
        String update = "UPDATE `trips` SET "
                + "`Start`='" + t.getStart() + "', "
                + "`Destination`='" + t.getDestination() + "', "
                + "`DepartureTime`='" + t.getDepartureTime() + "', "
                + "`ArrivalTime`='" + t.getArrivalTime() + "', "
                + "`Date`='" +t.getDate() + "', "
                + "`Price`='" + t.getPrice() + "', "
                + "`Driver`='" + t.getDriver().getId()+ "', "
                + "`Train`='" + t.getTrain().getId()+ "' "
                + "WHERE `ID`=" + t.getId() + ";";
        database.getStatement().execute(update);
    }
    public static void DeleteTrip(String id,Database database) throws SQLException {
        String delete="DELETE FROM `trips` WHERE `ID`="+id+";";
        database.getStatement().execute(delete);
        String drop="DROP TABLE `Trip"+id+"Passengers`;";
        database.getStatement().execute(drop);
    }
}
