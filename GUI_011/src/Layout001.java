import java.awt.*;
import javax.swing.*;
public class Layout001 extends JFrame
{
	JFrame jf;
	Label l1,l2;
	TextField tf1,tf2;
	Button b1,b2,b3;

	public Layout001() {
		
		jf=new JFrame();
		jf.setSize(400,150);
		l1=new Label("Enter Name");
		l2=new Label("Enter Name");
		
		tf1=new TextField(10);
		tf2=new TextField(10);
		
		b1=new Button("Clear");
		b1=new Button("Submit");
		b1=new Button("Exit");
		
		jf.setLayout(new FlowLayout());
		
		
		jf.add(l1);
		jf.add(l2);
		jf.add(tf1);
		jf.add(tf2);
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		
		jf.setSize(300,400);
		jf.setVisible(true);
		

		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Layout001();
		

	}

}
