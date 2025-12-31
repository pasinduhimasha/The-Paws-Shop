/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

import Data.*;

/**
 *
 * @author pasindu
 */
public class Pet_supplies {
    private String Pet;
    private String Category;
    private String Color;
    private int Price;
    private String Brand;
    private String Size;
    private String Metirial;
    private String Discription;

    public Pet_supplies(String Pet, String Category, String Color, int Price, String Brand, String Size, String Metirial, String Discription) {
        this.Pet = Pet;
        this.Category = Category;
        this.Color = Color;
        this.Price = Price;
        this.Brand = Brand;
        this.Size = Size;
        this.Metirial = Metirial;
        this.Discription = Discription;
    }

    public String getPet() {
        return Pet;
    }

    public void setPet(String Pet) {
        this.Pet = Pet;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getMetirial() {
        return Metirial;
    }

    public void setMetirial(String Metirial) {
        this.Metirial = Metirial;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }
    
    
}
