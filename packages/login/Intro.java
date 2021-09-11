//Creating package Login
package login;
import inventory.Admin;
import inventory.FileHandling;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


public class Intro implements ActionListener{
//Calling objects of other classes 
	  Admin func= new Admin();
	 
// Intializing the variables
   JFrame jf,lframe;
     JButton b1,b2;
   JTextField tf, tf1 ,tf2,tf3;
  JLabel l,l1,l2,l3;
	public void welcome() {
		// Layout for Welcome Page
    	jf = new JFrame("Welcome Page");
    	jf.pack();
    	JPanel area = new JPanel();
    	JPanel a = new JPanel();
    	area.setBackground(Color.gray);
    	jf.setBackground(new java.awt.Color(204,204,204));
    	jf.setLocationRelativeTo(null);
        l = new JLabel("<html><div style='text-align: center;'>Welcome<br/>To<br/> Inventory Shop</div></html>",SwingConstants.SOUTH_EAST);
        l.setOpaque(true);
        l.setVerticalAlignment(SwingConstants.CENTER);
       
        l.setBackground(Color.darkGray);
        l.setForeground(Color.white);
        l.setFont(new java.awt.Font("TimesRoman", 1, 26));
        l.setHorizontalAlignment(JLabel.CENTER);
        b1 = new JButton("Login");
        l.setPreferredSize(new Dimension(200, 200));
        jf.setLayout(new FlowLayout());
        jf.setSize(400, 300);
        jf.add(l);
        jf.add(b1);
        a.setLayout(new BorderLayout());
        a.add(b1,BorderLayout.SOUTH);
        area.add(l, BorderLayout.CENTER);        
        area.add(l, BorderLayout.EAST);
        jf.add(area);
        jf.add(a);
        b1.addActionListener(this);
        jf.setVisible(true);
    }
    public void display() {
        // Layout for Login Page
        	jf = new JFrame("Login Page");
        	jf.pack();
        	jf.setLocationRelativeTo(null);
            l = new JLabel("Username");
            
            l.setFont(new java.awt.Font("TimesRoman", 1, 24));      
            tf = new JTextField(20);
            l1 = new JLabel("Password");
            l1.setFont(new java.awt.Font("TimesRoman", 1, 24));  
            tf1 = new JTextField(22);
            b1 = new JButton("Sign in");
            jf.setSize(400, 300);
            jf.setLayout(new FlowLayout());
            jf.getContentPane().setBackground(Color.LIGHT_GRAY);

            jf.add(l);
            jf.add(tf);
            jf.add(l1);
            jf.add(tf1);
            jf.add(b1);
          
            b1.addActionListener(this);
            jf.setVisible(true);
        }
    public void Error() {
		JFrame f;  
	    f=new JFrame("Error!");  
	    JOptionPane.showMessageDialog(f,"Wrong Password or Username.","Alert",JOptionPane.WARNING_MESSAGE);
	    f.setVisible(false);
	}
    public void Succesfull() {  
		JFrame f;  
	    f=new JFrame("Welcome :)");  
	
	    JOptionPane.showMessageDialog(f,"Welcome to Admin Portal ");
	    f.setVisible(false);
	}
    public void SuccesfullUser() {  
		JFrame f;  
	    f=new JFrame("Welcome :)");  
	    JOptionPane.showMessageDialog(f,"Welcome to User Portal ");  
	    jf.setVisible(false);
	
	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	try {
    		 String action = e.getActionCommand();
    		 if(action.equals("Login")) {
    			 display();
    		 }
       if(action.equals("Sign in")) {
    	  
    	   String name = tf.getText();
           String pass = tf1.getText();
    	
                if(name.equals("admin") && pass.equals("1234")) {
       			Succesfull();
                   jf.setVisible(false);
               
                 func.choice();
                }
                else  if(name.length()==4 && pass.length()==4) {
                    if(name.equals("user") && pass.equals("1234")) {
           			SuccesfullUser();
                     jf.setVisible(false);
                    
                     func.PurchaseLayout();
           		}}
          	   else{
             		  throw new Exception();
              }
                }
    	}
        	
    	catch(Exception e1) {
  		Error();
  		
    	}
    }
    public static void main (String args[]) {
    	// main function
		new Intro().welcome();
	}

	
}

