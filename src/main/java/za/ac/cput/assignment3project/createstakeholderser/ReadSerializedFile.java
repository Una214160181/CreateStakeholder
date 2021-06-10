/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project.createstakeholderser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author 27677
 */
public class ReadSerializedFile {
    private ObjectInputStream input;
    Customer customer;
    Customer[] customerArray = new Customer[6];
    
    public void openFile(){
        try{
            input = new ObjectInputStream( new FileInputStream("stakeholder.ser"));
            System.out.println("*** ser file opened and opened for reading ***");
        }
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
        }
    }
    
    public void closeFile(){
        try{
        input.close( );
        }
        catch (IOException ioe){
            System.out.println("error closing ser file: " + ioe.getMessage());
        }
            
        }
  
    
     public void readFromFile(){
         try{
             for (int i = 0; i<customerArray.length; i++){
                 customerArray[i] = (Customer)input.readObject();
                 System.out.println(customerArray[i]);
             }
         }
          catch (ClassNotFoundException ioe){
              System.out.println("class error reading ser file: " + ioe);
              
         }
         
         catch (IOException ioe){
             System.out.println("error reading from ser file");
         }
         
         finally{
             closeFile();
             System.out.println("*** file has been closed ");
         }
     }
    
    
}
