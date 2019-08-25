package com.uj.ifm.typ.mobileprototype;

public class Product {

    public int getP_ID() {
        return P_ID;
    }

    public String getP_Name() {
        return P_Name;
    }

    public int getP_Price() {
        return P_Price;
    }

    public String getP_Image() {
        return P_Image;
    }

    public String getP_Code() {
        return P_Code;
    }

    public int getP_Quantity() {
        return P_Quantity;
    }

    public String getSupplier_Name() {
        return Supplier_Name;
    }

    public String getP_Type() {
        return P_Type;
    }

    public String getW_Name() {
        return W_Name;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public void setP_Price(int p_Price) {
        P_Price = p_Price;
    }

    public void setP_Image(String p_Image) {
        P_Image = p_Image;
    }

    public void setP_Quantity(int p_Quantity) {
        P_Quantity = p_Quantity;
    }

    public void setSupplier_Name(String supplier_Name) {
        Supplier_Name = supplier_Name;
    }

    public void setP_Type(String p_Type) {
        P_Type = p_Type;
    }

    public void setW_Name(String w_Name) {
        W_Name = w_Name;
    }

    public void setP_Code(String p_Code) {
        P_Code = p_Code;
    }

    private int P_ID;
    private String P_Name;
    private int P_Price;
    private String P_Image;
    private int P_Quantity;
    private String Supplier_Name;
    private String P_Type;
    private String W_Name;
    private String P_Code;
    private String Bin_location;

    public String getBin_location() {
        return Bin_location;
    }

    public void setBin_location(String bin_location) {
        Bin_location = bin_location;
    }

    public Product(int p_id, String p_name, int p_price, String p_image, int p_quantity, String supplier_name, String p_type, String w_name, String p_code, String bin_location){

        P_ID = p_id;
        P_Name = p_name;
        P_Price = p_price;
        P_Image = p_image;
        P_Quantity = p_quantity;
        Supplier_Name = supplier_name;
        P_Type = p_type;
        W_Name = w_name;
        P_Code = p_code;
        Bin_location = bin_location;
    }

    @Override
    public String toString() {
        return P_Code + " Amt: " + P_Quantity + " Price: R" + P_Price + " Type: " + P_Type;
    }
}
