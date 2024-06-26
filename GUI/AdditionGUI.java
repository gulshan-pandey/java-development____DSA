package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AdditionGUI extends JFrame {
    public AdditionGUI(String str) {
        super(str);
        setSize(600, 600);
        
        JPanel panel = new JPanel();   // Set panel is inside view the JFrame,it helps to arrange the components more efficiently
    
        panel.setLayout(null); // Set layout to null for absolute positioning however we can use ( new FlowLayout()) for dynamic size
        JLabel l = new JLabel("Addition calculator");
        
        
        JButton b = new JButton("Add");
        b.setFocusable(false);        // to remove the border in the button
        b.setBounds(100, 300, 100, 40);
        
        JLabel l1 = new JLabel("Enter first number:");
        JTextField t1 = new JTextField();
        JLabel l2 = new JLabel("Enter second number:");
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        
        JLabel l3 = new JLabel("result");
    
        


        l1.setBounds(50, 50, 300, 20);
        t1.setBounds(200, 50, 100, 20);
        l2.setBounds(50, 120, 200, 20);
        t2.setBounds(200, 120, 100, 20);
        l3.setBounds(50, 180, 200, 50);
        l.setBounds(150,10, 200, 20);
        t3.setBounds(200, 190,100, 20);

        t3.setEditable(false);
        
        panel.setBackground(new Color(108, 245, 131));

        panel.add(l1);
        panel.add(t1);  
        panel.add(l2);
        panel.add(t2);
        panel.add(b);  
        panel.add(l3);
        panel.add(l);
        panel.add(t3);

        setContentPane(panel);            // to add the panel to the jframe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Set default close operation

        setVisible(true);
        
        b.addActionListener(new ActionListener() {          //addActionListener is a method that takes the interface ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(t1.getText());   // this cannot be done by int type casting (int)
                    int b = Integer.parseInt(t2.getText());
                    int sum = a + b;
                    t3.setText((String.valueOf(sum)));    // or (Integer.toString(sum)) 
                } catch (NumberFormatException ex) {
                    t3.setText("Invalid input");
                }
            }
        });
    }

    public static void main(String[] args) {
        AdditionGUI frame = new AdditionGUI("Addition calculator");

    }
}