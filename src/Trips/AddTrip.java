package Trips;

import Employees.EmployeesDatabase;
import RailwayManagementSystem.Database;
import RailwayManagementSystem.GUI;
import RailwayManagementSystem.Main;
import Trains.TrainsDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddTrip {
     public AddTrip(JFrame parent, Database database) throws SQLException {
          String[] HH=new String[25];
          HH[0]="HH";
          for (int i=0;i<24;i++){
               HH[i+1]=String.format("%02d",i);
          }
          String[] mm=new String[61];
          mm[0]="mm";
          for (int i=0;i<60;i++){
               mm[i+1]=String.format("%02d",i);
          }
          JFrame frame=new JFrame("Add Trip");
          frame.setSize(750,675);
          frame.getContentPane().setLayout(new BorderLayout());
          frame.setLocationRelativeTo(parent);
          frame.getContentPane().setBackground(GUI.background);

          JPanel panel=new JPanel(new GridLayout(10,2,20,20));
          panel.setBackground(null);
          panel.setBorder(BorderFactory.createEmptyBorder(50,50,30,50));
          panel.add(GUI.JLabel("ID:"));
          JLabel id=GUI.JLabel(String.valueOf(TripsDatabase.getNextID(database)));
          panel.add(id);

          panel.add(GUI.JLabel("Start:"));
          JTextField start=GUI.JTextField();
          panel.add(start);

          panel.add(GUI.JLabel("Destination:"));
          JTextField destination=GUI.JTextField();
          panel.add(destination);

          panel.add(GUI.JLabel("Departure Time:"));
          JPanel dept=new JPanel(new GridLayout(1,2,10,10));
          dept.setBackground(null);
         JComboBox<String> deptHH=GUI.JComboBox(HH);
          JComboBox<String> deptmm=GUI.JComboBox(mm);
          dept.add(deptHH);
          dept.add(deptmm);
          panel.add(dept);

          panel.add(GUI.JLabel("Arrival Time:"));
          JPanel arr=new JPanel(new GridLayout(1,2,10,10));
         arr.setBackground(null);
          JComboBox<String> arrHH=GUI.JComboBox(HH);
          JComboBox<String> arrmm=GUI.JComboBox(mm);
          arr.add(arrHH);
          arr.add(arrmm);
          panel.add(arr);

          String[] dd=new String[32];
          dd[0]="dd";
          for (int i=1;i<32;i++){
               dd[i]=String.format("%02d",i);
          }
          String[] MM=new String[32];
          MM[0]="MM";
          for (int i=1;i<13;i++){
               MM[i]=String.format("%02d",i);
          }
          String[] yyy=new String[51];
          yyy[0]="yyy";
          for (int i=2010;i<2060;i++){
               yyy[i-2009]=String.format("%02d",i);
          }

          panel.add(GUI.JLabel("Date:"));
          JPanel date=new JPanel(new GridLayout(1,3,10,10));
         date.setBackground(null);
          JComboBox<String> dateDD=GUI.JComboBox(dd);
          JComboBox<String> dateMM=GUI.JComboBox(MM);
          JComboBox<String> dateyyy=GUI.JComboBox(yyy);
          date.add(dateDD);
          date.add(dateMM);
          date.add(dateyyy);
          panel.add(date);

          panel.add(GUI.JLabel("Driver:"));
          JComboBox<String> driver=GUI.JComboBox(EmployeesDatabase.getEmployeeNames(database));
          panel.add(driver);
          panel.add(GUI.JLabel("Price:"));
          JTextField price=GUI.JTextField();
          panel.add(price);

          panel.add(GUI.JLabel("Train:"));
          JComboBox<String> train=GUI.JComboBox(TrainsDatabase.getTrainsName(database));
          panel.add(train);
          JButton cancel=GUI.JButton("Cancel");
          cancel.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    frame.dispose();
               }
          });
          panel.add(cancel);

          JButton submit=GUI.JButton("Submit");
         submit.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   if (checkChoice(deptHH,frame)) return;
                   if (checkChoice(deptmm,frame)) return;
                   if (checkChoice(arrHH,frame)) return;
                   if (checkChoice(arrmm,frame)) return;
                   if (checkChoice(dateDD,frame)) return;
                  if (checkChoice(dateMM,frame)) return;
                   if (checkChoice(dateyyy,frame)) return;
                   try{
                        Double.parseDouble(price.getText());
                   }catch (Exception ex){
                        JOptionPane.showMessageDialog(frame,"Price must be a double ");
                        return;
                   }
                   Trip trip=new Trip();
                   trip.setId(Integer.parseInt(id.getText()));
                   trip.setStart(start.getText());
                   trip.setDestination(destination.getText());
                   String deptTime=deptHH.getSelectedItem().toString()+":"+deptmm.getSelectedItem().toString();
                   String arrTime=arrHH.getSelectedItem().toString()+":"+arrmm.getSelectedItem().toString();
                   trip.setDepartureTime(deptTime);
                   trip.setArrivalTime(arrTime);
                   String d=dateyyy.getSelectedItem().toString()+"-"+dateMM.getSelectedItem().toString()+"-"+dateDD.getSelectedItem().toString();
                    trip.setDate(d);
                    trip.setBookedSeats(0);
                    trip.setPrice(Double.parseDouble(price.getText()));
                   try {
                        trip.setDriver(EmployeesDatabase.getEmployeeByName(driver.getSelectedItem().toString(),database));

                        trip.setTrain(TrainsDatabase.getTrainByDescription(train.getSelectedItem().toString(),database));
                   } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(frame,ex.getMessage());
                   }
                    trip.setPassenger(new ArrayList<>());
                   try {
                        TripsDatabase.AddTrip(trip,database);
                        JOptionPane.showMessageDialog(frame,"Trip added successfully");
                       Main.refreshTable(TripsDatabase.getAllTrips(database));
                        frame.dispose();
                   } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame,"Operation Failed");
                        ex.printStackTrace();
                        frame.dispose();
                   }
              }
         });
          panel.add(submit);

          frame.getContentPane().add(panel,BorderLayout.CENTER);
          frame.setVisible(true);



     }
     private boolean checkChoice(JComboBox<String> comboBox,JFrame frame){
         boolean c=false;
          if (comboBox.getSelectedIndex()==0){
               JOptionPane.showMessageDialog(frame,"Data Error: "+comboBox.getSelectedItem().toString());
         c=true;

          }
          return c;
     }
}
