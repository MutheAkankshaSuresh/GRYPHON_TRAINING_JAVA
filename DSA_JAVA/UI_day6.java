import java.awt.*;
import java.awt.event.*;
public class UI_day6 extends Frame implements MouseListener
 {
       Label l1,l2;
       Frame f;
       String str;

       UI_day6()
       {
          f=new Frame("WINDOW");
          l1=new Label("Handling Mouse Event in the Frame Window",Label.CENTER);
          l2=new Label();
          f.setLayout(new FlowLayout());
          f.add(l1);
          f.add(l2);

          f.addMouseListener(this );
          f.setSize(340,200);
          f.setVisible(true);
       }

       public void mouseEntered(MouseEvent e)
       {
            str="Mouse has entered in window area";
            l2.setText(str);
            f.setVisible(true);
       }

        public void mouseExited(MouseEvent e)
       {
            str="Mouse has exited in window area";
            l2.setText(str);
            f.setVisible(true);
       }

         public void mouseClicked(MouseEvent e)
       {
            str="Mouse Button was clicked in window area";
            l2.setText(str);
            f.setVisible(true);
       }

        public void mousePressed(MouseEvent e)
       {
            str="Mouse Button is been Pressed in window area";
            l2.setText(str);
            f.setVisible(true);
       }

        public void mouseReleased(MouseEvent e)
       {
            str="Mouse Button is been Released in window area";
            l2.setText(str);
            f.setVisible(true);
       }

    public static void main(String srgs[])
    {
         new UI_day6();
    }
}
