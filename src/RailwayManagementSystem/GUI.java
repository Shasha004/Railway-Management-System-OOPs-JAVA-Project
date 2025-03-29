package RailwayManagementSystem;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static Color background=Color.decode("#EBFFD8");
    public static JLabel JLabel(String text){
        JLabel label =new JLabel(text);
        label.setFont(new Font(null,Font.BOLD,20));
        label.setForeground(Color.decode("#012030"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;

    }
    public static JTextField JTextField(){
        JTextField textField =new JTextField();
        textField.setFont(new Font(null,Font.BOLD,20));
        textField.setForeground(Color.decode("#012030"));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        return textField;

    }
    public static JButton JButton(String text){
        JButton btn=new JButton(text);
        btn.setBackground(Color.decode("#45C4B0"));
        btn.setForeground(Color.white);
        btn.setFont(new Font(null,Font.BOLD,22));
        return btn;
    }
    public static JComboBox<String> JComboBox(String[] data){
        JComboBox<String> box=new JComboBox<>(data);
        box.setFont(new Font(null,Font.BOLD,20));
        box.setBackground(Color.white);
        return box;
    }
}
