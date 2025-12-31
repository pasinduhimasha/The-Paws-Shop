/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;

import java.util.ArrayList;
import constructor.*;
/**
 *
 * @author pasindu
 */
public interface IpetSupplies {
    public abstract boolean insert(Pet_supplies pet_supplies);
    public abstract ArrayList<Pet_supplies> view();
    public abstract void search();
    public abstract boolean insert(Sign_Up sign_up);
    public abstract boolean insert(Add_New_Category add_new_category);
    public abstract boolean Cashir_Login(String userID, String password);
    public abstract boolean  LoginManager(String username, String password);
     public abstract boolean  LoginCashir(String fullname, String username);
}
