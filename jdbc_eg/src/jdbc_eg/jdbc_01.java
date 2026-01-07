package jdbc_eg;

import javax.swing.*;    
import java.awt.*;       
import java.awt.event.*; 

public class jdbc_01 {

    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Simple Swing Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with FlowLayout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Swing components
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Submit");

        // Action listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                JOptionPane.showMessageDialog(frame, "Hello, " + name + "!");
            }
        });

        // Add components to panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Add panel to frame
        frame.add(panel);

        // Show frame
        frame.setVisible(true);
    }
}
