package inventory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Items.items;
import code.Read;
import login.Intro;
public class Admin  implements ActionListener {
	 FileHandling ar=new FileHandling();
	
	JFrame jf;
    JButton b1,b2,b;
    JTextField tf, tf1 ,tf2,tf3;
    JLabel l,l1,l2,l3;
    String from;
    ResultSet rs1;;
    Statement st;
 
    String ids;
    JComboBox c1;
    String[] columnNames = {" ID", "Item Name", "Quantity", "Price"};
    JTable table;
public String Itemname;
public int quantity;
public String uniquecode;
public int price;
// default constructor 
    public Admin(){
	
    	Itemname="";
    	quantity=0;
    	uniquecode ="";
    	price=0;
    	
}
    public void UserDisplay() throws ClassNotFoundException {
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/AdminRole", "root","1234");
    		st = con.createStatement();
			rs = st.executeQuery("select Id from items");
			   Vector v = new Vector();
		         while (rs.next()) {
		             ids = rs.getString(1);
		             v.add(ids);
		             
		         }
		         c1 = new JComboBox(v);
	             c1.setBounds(150, 110, 150, 20);
		         jf.add(c1);
		        
		         rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
      
        jf = new JFrame("Database Search Result");

       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLayout(new BorderLayout());


        DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columnNames);


        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();

        String Id = "";

        String ItemName = "";

        String Quantity = "";

        String price = "";
        try {
            pst = con.prepareStatement("select * from items");
            ResultSet rs = pst.executeQuery();
            int i = 0;
          //ior(i=0;i<=rs;i++) {
            while(rs.next()) {
                Id = rs.getString("Id");
                ItemName = rs.getString("ItemName");
                 Quantity = rs.getString("Quantity");
                price= rs.getString("Price");
                model.addRow(new Object[]{Id, ItemName, Quantity, price});

                i++;
            }

            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        jf.add(scroll);

        jf.setVisible(true);

        jf.setSize(400, 300);

    }

 
  public void PurchaseLayout() {
	  
    	jf = new JFrame("Purchase" );
    	jf.pack();
    	jf.setLocationRelativeTo(null);
        l = new JLabel("<html>ItemName<br/></html>");
        l.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf = new JTextField(30);
        l1 = new JLabel("Quantity");
        l1.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf1 = new JTextField(10);
        b1 = new JButton("Purchase");
        b2 = new JButton("Exit");
        b = new JButton("Available Items");
        jf.setSize(400, 400);
        jf.setLayout(new FlowLayout());
        jf.add(l);
        jf.add(tf);
        jf.add(l1);
        jf.add(tf1);
        jf.add(b1);
        jf.add(b2);
        jf.add(b);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bActionPerformed(evt);
            }
    });

        jf.setVisible(true);
        
    }
  public void Bill(){
	JFrame f;  
    f=new JFrame("Payment");  
    JOptionPane.showMessageDialog(f,"Thanks For Purchasing");  
   
    jf.setVisible(false);

  }
  private void bActionPerformed(java.awt.event.ActionEvent evt) {
	  try {
		UserDisplay();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	

  }

    public void AddLayout() {
    	
    	jf = new JFrame("Add Items");
    	jf.pack();
    	jf.setLocationRelativeTo(null);
    	l3 = new JLabel("Unique Code");
    	l3.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf3 = new JTextField(5);
        l = new JLabel("<html>ItemName<br/></html>");
        l.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf = new JTextField(30);
        l1 = new JLabel("Quantity");
        l1.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf1 = new JTextField(10);
        l2 = new JLabel("Price");
        l2.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf2 = new JTextField(5);
       
        b1 = new JButton("Add");
       
        jf.setSize(400, 400);
        jf.setLayout(new FlowLayout());
        jf.add(l);
        jf.add(tf);
        jf.add(l1);
        jf.add(tf1);
        jf.add(l2);
        jf.add(tf2);
        jf.add(l3);
        jf.add(tf3);
        jf.add(b1);
   
        b1.addActionListener(this);
        jf.setVisible(true);
        
    }
 public void UpdateLayout() {
    	
    	jf = new JFrame("Modify Your Items");
    	jf.pack();
    	jf.setLocationRelativeTo(null);
        l = new JLabel("<html>Enter unique Id of item you want to edit<br/></html>");
        l.setFont(new java.awt.Font("TimesRoman", 1, 24));
        
        tf = new JTextField(5);
       
        l3 = new JLabel("Enter Item Name");
        l3.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf3 = new JTextField(10);
        l1 = new JLabel("Enter Updated Quantity");
        l1.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf1 = new JTextField(10);
        l2 = new JLabel("Enter Updated Price");
        l2.setFont(new java.awt.Font("TimesRoman", 1, 24));
        tf2 = new JTextField(5);
        b1 = new JButton("Update");
        jf.setSize(500, 300);
        jf.setLayout(new FlowLayout());
        jf.add(l);
        jf.add(tf);
        jf.add(l3);
        jf.add(tf3);
        jf.add(l1);
        jf.add(tf1);
        jf.add(l2);
        jf.add(tf2);
       
        jf.add(b1);
        b1.addActionListener(this);
        jf.setVisible(true);
        
    }

 public void DisplayLayout() {
	 
 try{

           
	  FileReader fr = new FileReader("C:\\Users\\Sandeep\\OneDrive\\Desktop\\Book1.csv");

                int i;
                while ((i=fr.read()) != -1)
                        System.out.print((char) i);
        }
        catch(IOException e) {
                System.out.println("Cannot open the file");
        }
 }

 public void DeleteLayout() {
 	
 	jf = new JFrame("Delete Items");
 	jf.pack();
 	jf.setLocationRelativeTo(null);
     l = new JLabel("<html>Enter unique Id of item you want to Delete <br/></html>");
     l.setFont(new java.awt.Font("TimesRoman", 1, 24));
     tf = new JTextField(5);
     b1 = new JButton("Delete");
     jf.setSize(500, 200);
     jf.setLayout(new FlowLayout());
     jf.add(l);
     jf.add(tf);
     jf.add(b1);
     b1.addActionListener(this);
     jf.setVisible(true);
     
 }

   
    public void choice(){
    	jf = new JFrame("Choose what to do");
    	jf.pack();
    	jf.setLocationRelativeTo(null);
        l = new JLabel("<html>Enter 1 To check Stock <br/>Enter 2 To Add Item<br/>Enter 3 to Delete Item <br/>Enter 4 To Modify Item</html>", SwingConstants.CENTER);
        l.setFont(new java.awt.Font("TimesRoman", 1, 24)); 
        tf2 = new JTextField(2);
        b1 = new JButton("Select");
        jf.setSize(300, 300);
        jf.setLayout(new FlowLayout());
        jf.add(l);
        jf.add(tf2);
        jf.add(b1);
        b1.addActionListener(this);
        jf.setVisible(true);
    }
    public void Error() {
		JFrame f;  
	    f=new JFrame("Error");  
	    JOptionPane.showMessageDialog(f,"Try Again","Alert",JOptionPane.WARNING_MESSAGE);  
	  
	
	}
 

    @Override 
    public void actionPerformed(ActionEvent e) {
    	
    	String action = e.getActionCommand();
       Connect();
        if (action.equals("Select")) {
        	String choice =tf2.getText();
        	int l = Integer.parseInt(choice);
         switch(choice) {
         case"1":{
        
			try {
				UserDisplay();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         
        	 break;
         }  
         
          case "2":
          {
        	  AddLayout();
        	
        	 
        	  break;
          }
          
         
          case "4":
        	  
          { UpdateLayout();
         
          	
          	break;
          }
          case "3":{
          	DeleteLayout();

          	 break;
          }
         }}
        if(action.equals("Update")) {
            try {
          	  String id= tf.getText();
          	  String qty =tf1.getText();
          	  String i =tf3.getText();
          	  int q = Integer.parseInt(qty);
          	  String price =tf2.getText();;
          	  int p= Integer.parseInt(price);
  		       update(q,p,id);
  		     try {
				ar.Updateitem(id,i,q,p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  		} catch (SQLException e1) {
  			System.out.print(e1);
  			e1.printStackTrace();
  		}
            }
        if(action.equals("Delete")) {

          	try {
          		String a =tf.getText();
			Delete(a);
			ar.Deleteitem(a);
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
          
         
       
        }
        if(action.equals("Add")) {
        	String uniquecode=tf3.getText();
        	String Itemname=tf.getText();
        	int  quantity=Integer.parseInt(tf1.getText());
        	int price=Integer.parseInt(tf2.getText());
          
      	    try {
				ar.write(uniquecode,Itemname,quantity,price);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
        	try {
				insertuser(uniquecode, Itemname, quantity, price);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
        	 tf.setText("");
        	 tf1.setText("");
        	 tf2.setText("");
        	 tf3.setText("");
        }
    
     
       if(action.equals("Purchase")) {
        	 tf.setText("");
        	 tf1.setText("");
        	    
        }
        if(action.equals("Exit")) {
        	Bill();
        }
     
		
					
    }


  
  public void insertuser(String ID ,String ItemName, int Quantity, int Price) throws SQLException
  {
      String queryInsert =
           "INSERT INTO adminrole.items(ID,ItemName,Quantity,Price)"
         + " VALUES ('"+ID+"','"+ItemName+"','"+Quantity+"','"+Price+"')";
      Statement stm=(Statement) con.createStatement();
      ResultSet rs;
      stm.executeUpdate(queryInsert);
      JOptionPane.showMessageDialog(null, "Record Added.."); 
      stm.close();
  	con.close();
  
  }
  public void update(int Quantity , int Price, String id ) throws SQLException
  {   	
    	Statement stmt=(Statement)con.createStatement(); 
    	
    	String updateQuery = "UPDATE items SET Quantity = "+Quantity+", Price ="+Price
                + " WHERE id ='"+id+"'";
    	
    	 ResultSet rs;
 
    	 stmt.executeUpdate(updateQuery); 
        JOptionPane.showMessageDialog(null, "Record is updated...");  
    	stmt.close();
    	con.close();  
    	}

  public void Delete(String id ) throws SQLException {

	    Statement stmt = con.createStatement();  

		String deleteQuery= "DELETE FROM items WHERE Id='"+id+"'";
		
	    stmt.executeUpdate(deleteQuery);  
	    
	    JOptionPane.showMessageDialog(null, "Record deleted...");  
	    stmt.close();  
	    con.close();  
	    }

Connection con;
	PreparedStatement pst;
	ResultSet rs;
 
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/AdminRole", "root","1234");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }
 
	    }
	}
	



