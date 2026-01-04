import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Card17 extends JFrame implements ActionListener
{
   JFrame jf;	
   JPanel pp;
   JPanel cp1;
   JPanel cp2;
   CardLayout cl;
   Card17()
   {
	   jf=new JFrame("Card Layout Example");
	   cl=new CardLayout();  
	   //creating parent panel which will contain 2 child  panel
	   pp=new JPanel();
	   
	   //creating child Panel
	   cp1=new JPanel();  //Numbers
	   cp2=new JPanel();  //Alphabets
	   
	   //Creating 2 Parent Buttons
	  JButton b1= new JButton("Numbers");
	  JButton b2= new JButton("Alphabets");
	  
	   //Creating 3 Child Buttons
	  JButton b3= new JButton("1");
	  JButton b4= new JButton("2");
	  JButton b5= new JButton("3");
	  
	  //add child buttons in child panel 1
	  cp1.add(b3);
	  cp1.add(b4);
	  cp1.add(b5);
	  
	  //creating 
      JButton b6= new JButton("A");
	  JButton b7= new JButton("B");
	  JButton b8= new JButton("C");
	  JButton b9= new JButton("D");
	  
	    //add child buttons in child panel 1
	    cp2.add(b6);
	    cp2.add(b7);
	    cp2.add(b8);
	    cp2.add(b9);
	    
	    //setting the positioning of Components in Parent Panel that contains cp1 and cp2 to Crad Layout
	    
	    pp.setLayout(cl);
	    
	    //adding cp1 and cp2 in parent pannel
	    pp.add(cp1,"Numbers");
	    pp.add(cp2,"Alphabets");
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    
	    //Setting Cantainer JFrames Layout to FlowLayout
	    jf.setLayout(new FlowLayout());
	    
	    //Adding 2 Buttons to Jframes,this buttons will remain commonly visible to all panel
	    jf.add(b1);
	    jf.add(b2);
	    
	    //adding pp  to JFrame
	    
	    jf.add(pp);
	    
	    jf.setSize(300,200);
	    jf.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e)
   {
	  if(e.getActionCommand()=="Numbers")
	  {
		  cl.show(pp,"Numbers");
	  }
	  else
	  {
		  cl.show(pp,"Alphabets");
	  }
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
