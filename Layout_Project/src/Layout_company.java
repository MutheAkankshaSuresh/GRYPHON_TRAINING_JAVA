import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Layout_company extends JFrame implements ActionListener
{
   JFrame jf;	
   JPanel pp;
   JPanel cp1;
   JPanel cp2;
   CardLayout cl;
   Layout_company()
   {
	   jf=new JFrame("Company Example");
	   cl=new CardLayout();  
	   //creating parent panel which will contain 2 child  panel
	   pp=new JPanel();
	   
	   //creating child Panel
	   cp1=new JPanel();  //Numbers
	   cp2=new JPanel();  //Alphabets
	   
	   //Creating 2 Parent Buttons
	  JButton b1= new JButton("Departments");
	  JButton b2= new JButton("Partners");
	  
	   //Creating 3 Child Buttons
	  JButton b3= new JButton("HR_Department");
	  JButton b4= new JButton("Dev_Team");
	  JButton b5= new JButton("Testing_Team");
	  
	  //add child buttons in child panel 1
	  cp1.add(b3);
	  cp1.add(b4);
	  cp1.add(b5);
	  
	  //creating 
      JButton b6= new JButton("Cisco");
	  JButton b7= new JButton("Tata");
	  JButton b8= new JButton("Juspay");
	  JButton b9= new JButton("Wipro");
	  
	  //add child buttons in child panel 1
	    cp2.add(b6);
	    cp2.add(b7);
	    cp2.add(b8);
	    cp2.add(b9);
	    
	 //setting the positioning of Components in Parent Panel that contains cp1 and cp2 to Crad Layout
	    
	    pp.setLayout(cl);
	    
	    //adding cp1 and cp2 in parent pannel
	    pp.add(cp1,"Departments");
	    pp.add(cp2,"Partners");
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    
	    //Setting Containers JFrames Layout to FlowLayout
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
	  if(e.getActionCommand()=="Departments")
	  {
		  cl.show(pp,"Departments");
	  }
	  else
	  {
		  cl.show(pp,"Partners");
	  }
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Layout_company();

	}

}
