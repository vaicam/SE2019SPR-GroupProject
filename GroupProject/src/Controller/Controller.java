/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.CustomerDB;
import Model.FileData;
import Menu.MainMenu;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Cameron Patterson
 */
public class Controller {

    /**
     * This class holds the main method for the project and thus runs the menu which uses
     *   the functionality of the model package
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //Initialize MainMenu and Model
        CustomerDB mainDataB = new CustomerDB();
        MainMenu menu = new MainMenu(mainDataB);
        
        //Load db file then add db file to DB
        ArrayList<Customer> client = new ArrayList<>();

        FileData.LoadData(client);
        mainDataB.concatList(client);
        //start program loop
        menu.execute();
    }
    
}
