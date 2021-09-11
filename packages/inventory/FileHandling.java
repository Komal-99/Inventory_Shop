package inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileHandling {
	boolean b ;
	Row row;
	String record,record2;
	  public static ArrayList<Row> rows = new ArrayList<>();
 public void write(String a , String b , int  c , int d) throws IOException {
	 row = new Row(a,b,c,d);
	  rows.add(row);
	  System.out.println(rows.add(row));
	  BufferedWriter w = new BufferedWriter( new FileWriter("C:\\Users\\Sandeep\\OneDrive\\Desktop\\komal.txt",true) );
      w.write(a+","+b+","+c+","+d);
      w.flush();
      w.newLine();
      w.close();
 }
 public void Updateitem(String Id , String Item ,int qty, int p) throws IOException {
    
	 try {
		 String   record,record2, newItem;
		 int newQuantity, newPrice;
		 File db = new File("C:\\Users\\Sandeep\\OneDrive\\Desktop\\komal.txt");
		 File tempDB = new File("C:\\Users\\Sandeep\\OneDrive\\Desktop\\komal1.txt");

		  BufferedReader br = new BufferedReader( new FileReader(db) );
		 BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );
		 
		  br.close();
	      newItem = Item;
		 newQuantity = qty;
		 newPrice = p;
		 BufferedReader br2 = new BufferedReader( new FileReader(db) );

		  while( (record2 = br2.readLine() ) != null ) {
		 if(record2.contains(Id)) {
		 bw.write(Id+","+newItem+","+newQuantity+","+newPrice);
		 } else {

		  bw.write(record2);
		 }
		 bw.flush();
		 bw.newLine();
		 }
		
		 bw.close();
		 br2.close();
		 db.delete();
		 boolean success = tempDB.renameTo(db);
		 System.out.println(success);

		  } catch(Exception e) {
		 e.printStackTrace();
		 }

}
 public void Deleteitem(String Id) throws IOException{
        File tempDB = new File("C:\\Users\\Sandeep\\OneDrive\\Desktop\\komal1.txt");
        File db = new File("C:\\Users\\Sandeep\\OneDrive\\Desktop\\komal.txt");
        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );
       
        while( ( record = br.readLine() ) != null ) {
                if( record.contains(Id) )
                        continue;
                bw.write(record);
                bw.flush();
                bw.newLine();
        }
        br.close();
        bw.close();
        db.delete();
        tempDB.renameTo(db);
}
public void Al(String a,String b , int c , int d)
{
        
        
        // Insert the columns for each row
        //             UniqueCode, ItemName, quantity,Price
        row = new Row(a, b,c,d);
        rows.add(row);
        System.out.println("Id\t ItemName\tQuantity\tPrice");
        System.out.println("------------------------------");
        for (Row printRow : rows)
        {
                System.out.println(
                        printRow.getUniqueCode() + "\t" +
                        printRow.getItemName() + "\t" +
                        printRow.getQuantity()+ "\t" + 
                        printRow.getPrice());
 
        }
}

 
}
 
class Row
{
 
// REMEMBER: each attribute is a column
//
private final String UniqueCode;
private final String ItemName;
private final int Quantity;
private final int Price;
 

public Row(String UniqueCode, String ItemName, int Quantity,int Price)
{
        this.UniqueCode = UniqueCode;
        this.ItemName = ItemName;
        this.Quantity = Quantity;
        this.Price = Price;
}
 
public String getUniqueCode()
{
        return UniqueCode;
}
 
public String getItemName()
{
        return ItemName;
}
 
public int getQuantity()
{
        return Quantity;
}
 
public int getPrice()
{
        return Price;
}
}
