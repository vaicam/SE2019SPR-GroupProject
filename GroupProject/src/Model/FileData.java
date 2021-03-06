package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;


/**
 *
 * @author clone-sniper
 */
public class FileData {

    //Function to retrieve name of file to be used
    public static String getFileName()
    {
        Scanner in = new Scanner(System.in);      
        System.out.println("Enter name for file");
        String name = in.nextLine();
                   
        return name;
    }

    //Loads Customer data from Byte File 
    public static void LoadData(ArrayList<Customer> client) throws IOException, ClassNotFoundException
    {   
        String name = getFileName();
        File temp = new File(name);
        if(temp.exists())   //Checks if a file exist and loads the data if it does

        {
            FileInputStream in = null;
            Customer holder = null;
        try 
        {
            in = new FileInputStream(name);
            ObjectInputStream s = new ObjectInputStream(in);

            while(in.available() > 0)    //Loads each object individually  into ArrayList until essentially end of file
            {
               holder = (Customer)s.readObject();
               client.add(holder);
            }
            
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File for Customer Data not Found");
        } 
        finally 
        {
            try 
            {
                in.close();
            } catch (IOException ex) 
            {
                System.out.println("File failed to close");
            }
        }
        }
        else
        System.out.println("No Existing Data");
    }
    //Saves Customer Data to a Byte File

    public static void SaveData(ArrayList<Customer> client) throws IOException

    {

            FileOutputStream f = null;
            try 
            {

                f = new FileOutputStream(getFileName());

                ObjectOutput s = new ObjectOutputStream(f);
                for(Customer hold : client)                     //Loads all of objects into specified file
                {
                s.writeObject(hold);
                s.flush();                    
                }
            } 
            catch (FileNotFoundException ex)                  //If no name is entered, file is by deafult called "Customer File"
            {
                f = new FileOutputStream("Customer File");   

                ObjectOutput s = new ObjectOutputStream(f);
                for(Customer hold : client)                     //Loads all of objects into specified file
                {
                s.writeObject(hold);
                s.flush();
                }
            } 
            finally
            {
                try 
                {
                    f.close();
                } 
                catch (IOException ex)
                {
                    System.out.println("File failed to close");
                }
            }
    }    
}