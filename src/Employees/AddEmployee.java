package Employees;
import RailwayManagementSystem.GUI;
import RailwayManagementSystem.Database;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddEmployee {
    public AddEmployee(JFrame parent, Database database) throws SQLException {
        JFrame frame=new JFrame("Add Employees");
        frame.setSize(750,600);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(parent);
        frame.getContentPane().setBackground(GUI.background);

        JPanel panel=new JPanel(new GridLayout(7,2,20,20));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,30,50));
        panel.add(GUI.JLabel("ID:"));
        JLabel id= GUI.JLabel(String.valueOf(EmployeesDatabase.getNextID(database)));
        panel.add(id);

        panel.add(GUI.JLabel("Name:"));
        JTextField name= GUI.JTextField();
        panel.add(name);

        panel.add(GUI.JLabel("Email:"));
        JTextField email= GUI.JTextField();
        panel.add(email);

        panel.add(GUI.JLabel("Tel:"));
        JTextField tel= GUI.JTextField();
        panel.add(tel);

        panel.add(GUI.JLabel("Salary:"));
        JTextField salary= GUI.JTextField();
        panel.add(salary);

        panel.add(GUI.JLabel("Position:"));
        JTextField position= GUI.JTextField();
        panel.add(position);

        JButton cancel= GUI.JButton("Cancel");
        panel.add(cancel);

        JButton submit= GUI.JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                Employee e=new Employee();
                e.setId(Integer.parseInt(id.getText()));
                e.setName(name.getText());
                e.setEmail(email.getText());
                e.setTel(tel.getText());
                e.setSalary(Double.parseDouble(salary.getText()));
                e.setPosition(position.getText() );
                try {
                    EmployeesDatabase.AddEmployee(e,database);
                    JOptionPane.showMessageDialog(frame,"Employees.Employee added Sucessfullt");
                    frame.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,"Operation Failed");
                    frame.dispose();
                }
            }
        });
        panel.add(submit);

        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.setVisible(true);



    }
}
