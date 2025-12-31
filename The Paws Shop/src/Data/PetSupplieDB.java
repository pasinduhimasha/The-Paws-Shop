/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import constructor.*;

/**
 *
 * @author pasindu
 */
public class PetSupplieDB implements IpetSupplies{
Pet_supplies pet_supplies;
File file=new File("Pet_Supplie_Details.txt");
    @Override
    public boolean insert(Pet_supplies pet_supplies) {
        
        try {
            FileWriter fileWriter=new FileWriter(file,true);
            fileWriter.write(pet_supplies.getPet()+" : "+pet_supplies.getCategory()+" : "+pet_supplies.getColor()+" : "+pet_supplies.getPrice()+" : "+pet_supplies.getBrand()+" : "+pet_supplies.getSize()+" : "+pet_supplies.getMetirial()+" : "+pet_supplies.getDiscription()+"\n");
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PetSupplieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Pet_supplies> view() {
    try { 
        Scanner scan= new Scanner (file);
        ArrayList<Pet_supplies> pet_supplieslist=new  ArrayList<>();
        while (scan.hasNextLine()){
            String line=scan.nextLine();
            String arr[]=line.split(" : ");
            String Pet=arr[0];
            String Category=arr[1];
            String Color=arr[2];
            int Price =Integer.valueOf(arr[3]);
            String Brand = arr[4];
            String Size=arr[5];
            String Metirial =arr[6];
            String Discription =arr[7];
            pet_supplies=new Pet_supplies(Pet, Category, Color, Price, Brand, Size, Metirial, Discription);
            pet_supplieslist.add(pet_supplies);
            
        }
        return pet_supplieslist;
    } catch (FileNotFoundException ex) {
        Logger.getLogger(PetSupplieDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public void search() {
        
    }

    @Override
    public boolean insert(Sign_Up sign_up) {
        File file=new File("Cashir_details.txt");
        try {
            FileWriter fileWriter=new FileWriter(file,true);
            fileWriter.write(sign_up.getFullName()+","+sign_up.getUserName()+","+sign_up.getPassword()+"\n");
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PetSupplieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean insert(Add_New_Category add_new_category) {
       File file=new File("Category.txt"); 
    try {
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write(add_new_category.getCategory()+"\n");
        fileWriter.close();
        return true;
    } catch (IOException ex) {
        Logger.getLogger(PetSupplieDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }

    @Override
    public boolean Cashir_Login(String userID, String password) {
        File file = new File("Cashir_details.txt"); // Ensure file is accessible

    // Check if the file exists
    if (!file.exists()) {
        System.out.println("File not found: " + file.getAbsolutePath());
        return false;
    }

    try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] arr = line.split(",");

            if (arr.length == 3) {  // Expect fullname, username, and password
                String fileUserID = arr[1].trim();
                String filePassword = arr[2].trim();

                // Validate credentials
                if (fileUserID.equals(userID) && filePassword.equals(password)) {
                    return true;  // Match found
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }

    return false;  // No match found
}

    @Override
    public boolean LoginManager(String username, String password) {
        boolean validCredentials = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Manager_details.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(",")) {
                    String[] fields = line.split(",");
                    if (fields.length >= 2) {
                        String name = fields[0].trim();
                        String pass = fields[1].trim();
                        if (username.equals(name) && password.equals(pass)) {
                            validCredentials = true;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return validCredentials;
    }

    @Override
    public boolean LoginCashir(String username, String password) {
        
    boolean validCredentials = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Cashir_details.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(",")) {
                    String[] fields = line.split(",");
                    if (fields.length >= 3) {
                        String name = fields[1].trim();
                        String pass = fields[2].trim();
                        if (username.equals(name) && password.equals(pass)) {
                            validCredentials = true;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return validCredentials;
    }
    
}
   
    

