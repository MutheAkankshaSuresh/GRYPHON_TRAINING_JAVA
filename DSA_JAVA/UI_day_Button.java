import java.awt.*;
import java.awt.event.*;

public class UI_day_Button extends Frame implements ActionListener {

    Button R, G, B;

    UI_day_Button() {
        R = new Button("Red");
        G = new Button("Green");
        B = new Button("Blue");

        setLayout(new FlowLayout());
        add(R);
        add(G);
        add(B);

        R.addActionListener(this);
        G.addActionListener(this);
        B.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == R) {
            setBackground(Color.red);
        } else if (e.getSource() == G) {
            setBackground(Color.green);
        } else {
            setBackground(Color.blue);
        }
    }

    public static void main(String[] args) {
        UI_day_Button ob = new UI_day_Button();
        ob.setSize(350, 350);
        ob.setVisible(true);

        ob.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });
    }
}
