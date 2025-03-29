package RailwayManagementSystem;

import Employees.AddEmployee;
import Employees.EditEmployee;
import Passengers.AddPassenger;
import Passengers.EditPassenger;
import Trains.AddTrain;
import Trips.EditTrip;
import Trips.AddTrip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ModifyList {
   public ModifyList(JFrame oldFrame,Database database){
       JFrame frame=new JFrame("Modify");
       frame.setSize(400,600);
       frame.getContentPane().setLayout(new BorderLayout());
       frame.setLocationRelativeTo(oldFrame);
       frame.getContentPane().setBackground(Color.decode("#EBFFD8"));

       JPanel  panel=new JPanel(new GridLayout(8,18,10,10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JButton addTrain=JButton("Add Trains");
        addTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddTrain(frame,database);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(addTrain);

        JButton editTrain=JButton("Edit Trains");
        editTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EditTrip(frame,database);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(editTrain);

        JButton addEmployee=JButton("Add Employees");
        addEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddEmployee(frame,database);
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(frame,ex.getMessage());
                }

            }
        });
        panel.add(addEmployee);

        JButton editEmployee=JButton("Edit Employees");
        editEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EditEmployee(frame,database);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,ex.getMessage());
                }

            }
        });
        panel.add(editEmployee);

        JButton addPassenger=JButton("Add Passengers");
        addPassenger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddPassenger(frame,database);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,ex.getMessage());
                }
            }
        });
        panel.add(addPassenger);

        JButton editPassenger=JButton("Edit Passenger");
        editPassenger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EditPassenger(frame,database);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,ex.getMessage());
                }
            }
        });
        panel.add(editPassenger);

       JButton addTrip=JButton("Add Trips");
       addTrip.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   new AddTrip(frame,database);
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(frame,ex.getMessage());
               }
           }
       });
       panel.add(addTrip);

       JButton editTrip=JButton("Edit Trips");
       editTrip.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   new EditTrip(frame,database);
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(frame,ex.getMessage());
               }
           }
       });
       panel.add(editTrip);

       frame.getContentPane().add(panel,BorderLayout.CENTER);


        frame.setVisible(true);
   }
   private JButton JButton(String text){
       JButton btn=new JButton(text);
       btn.setBackground(Color.decode("#45C4B0"));
       btn.setForeground(Color.white);
       btn.setFont(new Font(null,Font.BOLD,22));
       return btn;
   }
}
